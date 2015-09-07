package be.ticket.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import be.ticket.entity.AbstractEntity;

public abstract class AbstractDAO<T extends AbstractEntity> {

	@Inject
	EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(T entity) {
		em.persist(entity);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public T find(Object id) {
		return em.find(getEntityClass(), id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public T update(T entity) {
		return em.merge(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(T entity) {
		em.remove(em.merge(entity));
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteById(Object id) {
		em.remove(em.find(getEntityClass(), id));
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public long count() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(getEntityClass())));
		return em.createQuery(cq).getSingleResult().longValue();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
		cq.select(cq.from(getEntityClass()));
		return em.createQuery(cq).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findRange(int from, int to) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
		cq.select(cq.from(getEntityClass()));
		return addRange(cq, from, to).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findByNamedQuery(String namedQuery,
			Map<String, Object> parameters) {
		TypedQuery<T> q = em.createNamedQuery(namedQuery, getEntityClass());
		if (parameters != null && !parameters.isEmpty()) {
			for (Entry<String, Object> entry : parameters.entrySet()) {
				q.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return q.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findAllByParametersLike(Map<String, Object> parameters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
		addPredicates(cb, cq, parameters, PredicateType.LIKE);
		return em.createQuery(cq).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findAllByParametersEqual(Map<String, Object> parameters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
		addPredicates(cb, cq, parameters, PredicateType.EQUAL);
		return em.createQuery(cq).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findRangeByParametersLike(Map<String, Object> parameters,
			int from, int to) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
		addPredicates(cb, cq, parameters, PredicateType.LIKE);
		return addRange(cq, from, to).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> findRangeByParametersEqual(Map<String, Object> parameters,
			int from, int to) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
		addPredicates(cb, cq, parameters, PredicateType.EQUAL);
		return addRange(cq, from, to).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void flush() {
		em.flush();
	}
	
	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		if (entityClass == null) {
			Type type = this.getClass().getGenericSuperclass();
			ParameterizedType paramType = (ParameterizedType) type;
			entityClass = (Class<T>) paramType.getActualTypeArguments()[0];
		}
		return entityClass;
	}
	
	private enum PredicateType { EQUAL, LIKE}

	private void addPredicates(CriteriaBuilder cb, CriteriaQuery<T> cq,
			Map<String, Object> parameters, PredicateType type) {
		Root<T> c = cq.from(getEntityClass());
		List<Predicate> predicates = new ArrayList<Predicate>();
		for (String s : parameters.keySet()) {
			if (c.get(s) != null) {
				switch (type) {
				case LIKE:
					predicates.add(cb.like(c.<String> get(s),
							"%" + parameters.get(s) + "%"));
					break;
				case EQUAL:
					predicates.add(cb.equal(c.get(s), parameters.get(s)));
					break;
				}
			}
		}
		cq.where(predicates.toArray(new Predicate[] {}));
	}
	
	private TypedQuery<T> addRange(CriteriaQuery<T> cq, int from, int to) {
		TypedQuery<T> q = em.createQuery(cq);
		q.setMaxResults(to - from);
		q.setFirstResult(from);
		return q;
	}
}
