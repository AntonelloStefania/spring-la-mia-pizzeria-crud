package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;


@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 32, nullable=false)
	@Length(min = 5, max = 32, message = "Name must be between 5 and 32 chars")
	@NotBlank(message="name cannot be only whitespaces or empty")
	private String name;
//	descrizione
	
	@Column(columnDefinition = "TEXT", length=100)
	@Length(min = 10, max = 100, message = "Description must be between 10 and 100 chars.")
	@NotBlank(message="name cannot be only whitespaces or empty")
	private String description;
//	foto (url)
	@URL(protocol = "https")
	@NotBlank(message="photo URL cannot be only whitespaces or empty")
	private String photo;

	//	prezzo
	@Column(nullable=false)
	@Positive (message="Price cannot be empty or negative")
	private double price;
	
	public Pizza() { }
	public Pizza(String name,String description, String photo, double price) { 
		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
