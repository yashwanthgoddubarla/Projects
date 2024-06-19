package com.orm.Service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orm.DTO.orderDTO;
import com.orm.Exception.OrderException;

public interface OrderService {
	
	public abstract orderDTO save(orderDTO op);
	public abstract orderDTO update(orderDTO op);
	public abstract orderDTO getbyOrderid(Integer id) throws OrderException;
	public abstract List<orderDTO> getAll() throws OrderException;
	public abstract String deletebyorderid (Integer id);
	

}
