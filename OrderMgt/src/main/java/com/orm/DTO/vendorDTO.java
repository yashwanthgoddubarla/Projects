package com.orm.DTO;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class vendorDTO {

	
	private int vid;
	private String vame;
	private String vtan;
	private String vpan;
	private String vloc;
    private String vdept;
    
}
