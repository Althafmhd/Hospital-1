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
public class SubBlockMeterReadingTo {
	private Long id;
	private String mainmetername;
	private String subblockmetername;
	private Long readingunits;
	private Long todayunits;
	private LocalDate date;

}
