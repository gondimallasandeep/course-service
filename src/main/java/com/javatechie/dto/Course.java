package com.javatechie.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
	
	
	private int courseId;
	private String name;
	private String description;
	private double fees;
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date startDate; // course start date 
	private String duration; // no of days
	private String trainerName;
	private boolean isCertificateAvailable;
	private String courseType; // Live or Recording
	
	
}
