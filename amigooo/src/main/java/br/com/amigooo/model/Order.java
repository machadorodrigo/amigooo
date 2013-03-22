package br.com.amigooo.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDO")
public class Order {

	/*
	 * Legenda do status do pedido
	 * 0 - Entregue/Finalizado 
	 * 1 - Em aberto
	 * 2 - Sendo preparado/providenciado
	 * 3 - Cancelado pelo estabelecimento
	 * 4 - Cancelado pelo usuário (Poderá cancelar apenas se o pedido estiver em aberto)
	 */
	private Integer id,establishment,quantity,status;
	private Date opening;
	private ActiveSession session;
	private Set<Item> item;
	
	public Order(){}
	
	public Order(Integer id, Set<Item> item, Integer establishment,
			Integer quantity, Integer status, Date opening,
			ActiveSession session) {
		super();
		this.id = id;
		this.item = item;
		this.establishment = establishment;
		this.quantity = quantity;
		this.status = status;
		this.opening = opening;
		this.session = session;
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
	
	@ManyToMany(fetch=FetchType.EAGER)
	public Set<Item> getItem() {
		return item;
	}
	public void setItem(Set<Item> item) {
		this.item = item;
	}
	
	public Integer getEstablishment() {
		return establishment;
	}
	public void setEstablishment(Integer establishment) {
		this.establishment = establishment;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Date getOpening() {
		return opening;
	}
	public void setOpening(Date opening) {
		this.opening = opening;
	}

	@ManyToOne
	@JoinColumn(name="session_id")
	public ActiveSession getSession() {
		return session;
	}
	public void setSession(ActiveSession session) {
		this.session = session;
	}
	
}
