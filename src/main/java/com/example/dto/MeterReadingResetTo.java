package com.example.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class MeterReadingResetTo {
	private Long id;
	private String mainmetername;
	private Long readingunits;
	private LocalDate date;
}
