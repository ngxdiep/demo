package com.example.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="catalog")
public class Catalog implements Serializable {
	
	private static final long serialVersionUD =1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="catalog_id")
	private Integer catalogId;
	
	@Column(name = "catalogname")
	private String catalogName;
	
	@OneToMany(mappedBy ="catalog", cascade=CascadeType.ALL)
	private Set<Product> products;


	public Integer getCatalogId() {
		return catalogId;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
}
