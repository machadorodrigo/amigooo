package br.com.amigooo.dao;

import java.util.Set;

import br.com.amigooo.model.Role;

public interface RoleDao extends GenericRepository<Role>{
	public Role getRole(String name);
	public Set<Role> getRolesByList(String name);
}
