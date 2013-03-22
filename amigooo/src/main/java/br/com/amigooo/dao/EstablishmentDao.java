package br.com.amigooo.dao;

import java.util.List;

import br.com.amigooo.model.Establishment;

public interface EstablishmentDao {
	public Establishment getEstablishment(Integer id);
	public List<Establishment> getEstablishmentList();
}
