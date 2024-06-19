package com.orm.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.orm.DTO.orderDTO;
import com.orm.Entity.OrderPojo;
import com.orm.Exception.OrderException;
import com.orm.Repo.OrderRepo;
import com.orm.Service.OrderService;

@Component
public class Orderserviceimpl implements OrderService{
	@Autowired
	private OrderRepo or;
	@Autowired
	private ModelMapper mmap;
	
	@Override
	public orderDTO save(orderDTO op) {
		OrderPojo p =mmap.map(op, OrderPojo.class);
		or.save(p);
		return op;
	}

	@Override
	public orderDTO update(orderDTO op) {
		OrderPojo p =mmap.map(op, OrderPojo.class);
		or.save(p);
		return op;
	}

	@Override
	@Cacheable("OrderPojo")
	public orderDTO getbyOrderid(Integer id) throws OrderException 
	{	orderDTO o = null;
		try {
		Optional<OrderPojo> p =or.findById(id);
		OrderPojo l =p.get();
		o= mmap.map(l, orderDTO.class);
		}
		catch (Exception e) {
			throw new OrderException();
		}
		return o;
	}

	@Override
	public List<orderDTO> getAll() throws OrderException {
		List<orderDTO> data = null;
		try {
		List<OrderPojo> p = or.findAll();
		//List<orderDTO> l = new ArrayList<orderDTO>();
		
		orderDTO[] d =	mmap.map(p, orderDTO[].class);
		 data = Arrays.asList(d);
		}catch (Exception e) {
			throw new OrderException();
		}
		return data;
		
//		for(OrderPojo q : p) 
//		{
//			orderDTO d =	mmap.map(q, orderDTO.class);
//			l.add(d);
//		}
//		
//		return l;
	}

	@Override
	public String deletebyorderid (Integer id) {
		or.deleteById(id);
		return "Delete Success";
	}
	

}
