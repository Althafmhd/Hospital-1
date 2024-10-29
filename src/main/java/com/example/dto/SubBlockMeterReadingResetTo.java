package com.example.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class SubBlockMeterReadingResetTo {
	
	private Long id;
	private String mainmetername;
	private String subblockmetername;
	private Long readingunits;
	private LocalDate date;
}
