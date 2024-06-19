package com.orm.Entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class vendorPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vid;
	private String vame;
	private String vtan;
	private String vpan;
	private String vloc;
    private String vdept;
    
}
