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
@NoArgsConstructor
@AllArgsConstructor
public class OrderProcessPojo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;
	private String productName;
	private int productquan;
	private String productdeptname;
	private Date productdeliverydate;
	private String producttype;
	private String productAppmanager;
	

}
