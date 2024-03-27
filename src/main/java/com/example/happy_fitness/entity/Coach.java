package src.main.java.com.example.happy_fitness.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="coach")
public class Coach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public float id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "phone_number")
	public String phoneNumber;
	
	@Column(name = "dob")
	public Date dob;
	
	
	@Column(name = "description")
	public String Description;
	
	@ManyToOne
    @JoinColumn(name = "center_id")
	public Center center;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public Coach(float id, String name, String phoneNumber, Date dob, String description, Center center) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		Description = description;
		this.center = center;
	}

	public Coach() {
		super();
	}
	
	
	
}
