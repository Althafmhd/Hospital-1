package com.example.dto;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor


public class SubBlockMeterTo {
		private Long id;
		private String mainmetername;
		private String subblockmetername;
		private Date date;

}
