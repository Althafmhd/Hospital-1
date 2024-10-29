package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Meterreading {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String mainmetername;
	private Long readingunits;
	private Long todayunits;
	private LocalDate date;

	
	
}
