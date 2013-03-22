package br.com.amigooo.dao;

import java.util.List;

import br.com.amigooo.model.Item;

public interface ItemDao {
	public Item getItem(Integer id);
	public List<Item> getItemList();
}
