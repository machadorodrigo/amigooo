package br.com.amigooo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAPEL")
public class Role {
	
	public Role(){}
	
	public Role(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	private String name,description;

	@Id
	@Column(unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
