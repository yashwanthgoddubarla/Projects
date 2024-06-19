package com.orm.Entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class OrderPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderid;
	@Past
	private Date orderdate;
	@Future
	private Date orderdeliverydate;
	private Integer  orderdeptId;
	private String orderempName;
	private String orderAppManager;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fkorderid")
	private List<OrderProcessPojo> opp;	
}
