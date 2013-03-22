package br.com.amigooo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SESSAO_ATIVA")
public class ActiveSession {

	/*
	 * Legenda do status
	 * 0 - Sessão e pedidos finalizados
	 * 1 - Cancelado pelo estabelecimento
	 * 2 - Cancelado pelo cliente
	 */
	private Integer id,status;
	private String email,observation;
	private Date dateStarted;
	private Set<Order> order;
	
	public ActiveSession(){}
	
	public ActiveSession(Integer id, Integer status, String email,
			String observation, Date dateStarted, Set<Order> order) {
		super();
		this.id = id;
		this.status = status;
		this.email = email;
		this.observation = observation;
		this.dateStarted = dateStarted;
		this.order = order;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(unique=true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Date getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Order> getOrder() {
		return order;
	}
	
	public void setOrder(Set<Order> order) {
		this.order = order;
	}
}