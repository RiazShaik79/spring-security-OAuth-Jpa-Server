package io.javabrains;

import java.util.List;

import javax.persistence.Column;
//import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="user")
//@Data
public class User {
	
	public User() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccount_expired() {
		return account_expired;
	}

	public void setAccount_expired(boolean account_expired) {
		this.account_expired = account_expired;
	}

	public boolean isCredential_expired() {
		return credential_expired;
	}

	public void setCredential_expired(boolean credential_expired) {
		this.credential_expired = credential_expired;
	}

	public boolean isAccount_locked() {
		return account_locked;
	}

	public void setAccount_locked(boolean account_locked) {
		this.account_locked = account_locked;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	private String email;
	@Column(name = "enabled")
	private boolean enabled;
	@Column(name = "account_expired")
	private boolean account_expired;
	@Column(name = "credential_expired")
	private boolean credential_expired;
	@Column(name = "account_locked")
	private boolean account_locked;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private List<Role> roles;
	
}
