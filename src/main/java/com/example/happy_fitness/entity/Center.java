package src.main.java.com.example.happy_fitness.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="center")
public class Center {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public float id;
	
	@Column(name ="name")
	public String name;
	
	@Column(name="addres")
	public String addres;
	
	@Column(name="phoneNumber")
	public String phoneNumber;

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Center() {
		super();
	}
	
	
	
}
