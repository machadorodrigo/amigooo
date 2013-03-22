package br.com.amigooo.dao;

import java.util.List;

import br.com.amigooo.model.AccessRequest;

public interface AccessRequestDao {
	public AccessRequest getAccessRequest(String registration);
	public List<AccessRequest> getAccessRequestList();
}