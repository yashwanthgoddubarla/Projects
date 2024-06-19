package com.orm.DTO;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProductDTO {

	private int pid;
	private String pname;
	private int pmaxq;
	private int pminq;
	private String pstore;
	private String pman;
	private String ptype;
	private double pprice;
	private double pgst;
	private List<vendorDTO> vpo;
	
}
