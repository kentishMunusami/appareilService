package com.home.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Appareil {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_appareil")
	private int id;
	
	private String name;
	private String status;
	
	public Appareil(int id, String name, String status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Appareil() {
	}
	
	
	
	

}
