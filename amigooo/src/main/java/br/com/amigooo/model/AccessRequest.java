package br.com.amigooo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDO_ACESSO")
public class AccessRequest {
	
	/*
	 * Legenda de status
	 * 0 - Aceito
	 * 1 - Aberto
	 * 2 - Negado pelo estabelecimento
	 * 3 - Cancelado pelo cliente
	 */
	private Integer id,status,establishment;
	private String email,observation;
	private Date dateRequest;
	
	public AccessRequest(){}
	
	public AccessRequest(Integer id, Integer status, Integer establishment, String email,
			String observation, Date dateRequest) {
		
		super();
		this.id = id;
		this.status = status;
		this.email = email;
		this.observation = observation;
		this.dateRequest = dateRequest;
		this.establishment = establishment;
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
	public Date getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public Integer getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Integer establishment) {
		this.establishment = establishment;
	}
}
