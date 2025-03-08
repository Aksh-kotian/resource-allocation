package com.in.akshay.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resourceId;
	
	private String resourceName;
	
	private int experience;
	
	@Column(length = 500)
	private String skills; 
	
	
}
