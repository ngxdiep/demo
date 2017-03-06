package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="catalog")
public class Catalog implements Serializable {
	
	private static final long serialVersionUD =1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="catalogid")
	private Integer catalogId;
	
	public Integer getCatalogId() {
		return catalogId;
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

	@Column(name = "catalogname")
	private String catalogName;
}
