package com.orm.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderProcessDTO {

		
		private int productid;
		private String productName;
		private int productquan;
		private String productdeptname;
		private Date productdeliverydate;
		private String producttype;
		private String productAppmanager;
}
