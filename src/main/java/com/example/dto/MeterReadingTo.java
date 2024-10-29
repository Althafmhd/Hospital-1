package com.example.dto;


import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeterReadingTo {
	private Long id;
	private String mainmetername;
	private Long readingunits;
	private Long todayunits;
	private LocalDate date;

}
