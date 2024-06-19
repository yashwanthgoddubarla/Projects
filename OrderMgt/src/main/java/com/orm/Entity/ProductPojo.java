package com.orm.Entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Entity
@Data
public class ProductPojo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private int pmaxq;
	private int pminq;
	private String pstore;
	private String pman;
	private String ptype;
	private double pprice;
	private double pgst;
	
	@ManyToMany(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "vedpro", joinColumns = {@JoinColumn(name = "fkpid")}, inverseJoinColumns = {@JoinColumn(name = "fkvid")})
	private List<vendorPojo> vpo;
	
}
