package br.com.amigooo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.amigooo.model.Role;

@Entity
@Table(name="USUARIO")
public class User {
	private String registration,name,email,userPassword,avatar;
	private Date registrationDate;
	private Boolean active;
	private Integer rating;
	private Set<Role> role; 
	
	public User(){}
	
	public User(String registration, String name, String email,
			String userPassword, String avatar, Date registrationDate,
			Boolean active, Integer rating, Set<Role> role) {
		super();
		this.registration = registration;
		this.name = name;
		this.email = email;
		this.userPassword = userPassword;
		this.avatar = avatar;
		this.registrationDate = registrationDate;
		this.active = active;
		this.rating = rating;
		this.role = role;
	}
	
	@Id
	@Column(unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
}
