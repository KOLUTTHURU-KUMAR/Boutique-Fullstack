package com.boutique.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table
public class Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@Column(name = "quantity")
	private String quantity;
	
	private long amount;
	
	private String quality;
	
	private LocalDate mandate;
	
	@Column(nullable = false)
	private long discount;

	
	@Override
	public String toString() {
		return "Details [id=" + id + ", name=" + name + ", quantity=" + quantity + ", amount="
				+ amount + ", quality=" + quality + ", mandate=" + mandate + ", discount=" + discount + "]";
	}
	



	public Details(long id, String name, String quantity, long amount, String quality, 
			LocalDate mandate, long discount) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.amount = amount;
		this.quality = quality;
		this.mandate = mandate;
		this.discount = discount;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getQuantity() {
		return quantity;
	}



	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



	public long getAmount() {
		return amount;
	}



	public void setAmount(long amount) {
		this.amount = amount;
	}



	public String getQuality() {
		return quality;
	}



	public void setQuality(String quality) {
		this.quality = quality;
	}
 

	public LocalDate getMandate() {
		return mandate;
	}



	public void setMandate(LocalDate mandate) {
		this.mandate = mandate;
	}



	public long getDiscount() {
		return discount;
	}



	public void setDiscount(long discount) {
		this.discount = discount;
	}


	public Details() {
		super();
	}

}
