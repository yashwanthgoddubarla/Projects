package com.orm.DTO;

import java.sql.Date;
import java.util.List;
import com.orm.Entity.OrderProcessPojo;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Data;
@Data
public class orderDTO {

	private int orderid;
	@Past
	private Date orderdate;
	@Future
	private Date orderdeliverydate;
	private int  orderdeptId;
	@NotEmpty
	private String orderempName;
	@NotEmpty
	private String orderAppManager;
	private List<OrderProcessDTO> opp;	
}
