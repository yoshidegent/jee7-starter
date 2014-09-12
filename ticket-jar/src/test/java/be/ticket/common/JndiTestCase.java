package be.ticket.common;

import be.ticket.dao.PassengerRepository;
import be.ticket.entity.Passenger;
import org.junit.Ignore;
import org.junit.Test;

import javax.naming.InitialContext;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

/**
 * Requires:
 *  - Running JBoss with _deployed_ application on it
 *  - Remote interface to consume
 *  - JBoss client bom maven dependency
 *  See http://middlewaremagic.com/jboss/?tag=jboss-client-7-1-0-final-jar
 *
 *  Does not require:
 *   - Arquillian
 *
 *   Does not have:
 *    - @EJB / @Resource / @Inject dependency injeciton in the unit test
 */
@Ignore
public class JndiTestCase {
    @Test
    public void jndiTest() throws Exception {
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put(InitialContext.PROVIDER_URL, "remote://localhost:4447");
        hashtable.put("jboss.naming.client.ejb.context", true);
        hashtable.put(InitialContext.SECURITY_PRINCIPAL, "kevin");
        hashtable.put(InitialContext.SECURITY_CREDENTIALS, "kevinkevin1");
        hashtable.put(InitialContext.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        hashtable.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");

        InitialContext context = new InitialContext(hashtable);
        PassengerRepository lookup = (PassengerRepository) context.lookup("ticket-ear-1.0-SNAPSHOT/ticket-jar/PassengerRepositoryBean!be.ticket.dao.PassengerRepository");

        Passenger passenger = lookup.find(1);
        assertEquals("Jimi", passenger.getFirstName());
    }
}
