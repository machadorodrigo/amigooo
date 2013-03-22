package br.com.amigooo.dao;

import java.util.List;

import br.com.amigooo.model.Order;

public interface OrderDao {
	public Order getOrder(Integer id);
	public List<Order> getOrderList();
}
