package com.example.dto;




import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeterTo {
	 private Long id;
	 private String mainmetername;
	 private Date date;

}
