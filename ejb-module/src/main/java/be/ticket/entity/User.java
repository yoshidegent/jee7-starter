package be.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

@XmlRootElement
@Entity
@NamedQueries({ @NamedQuery(name = User.FIND_USERS_BY_USERNAME, query = "select u from User u where u.userName = :userName") })
public class User extends AbstractEntity {
	private static final long serialVersionUID = -375968444459999348L;

	public static final String FIND_USERS_BY_USERNAME = "User.findUsersByUserName";

	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String firstName;
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String lastName;
	@NotNull
	@Size(min = 1, max = 100)
	@Email
	@Column(length = 100, nullable = false)
	private String email;
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false, updatable = false)
	private String userName;

	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String userName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", version=" + version + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + "]";
	}

}
