package com.orm.Controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orm.DTO.orderDTO;
import com.orm.Entity.OrderPojo;
import com.orm.Exception.OrderException;
import com.orm.Service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {
@Autowired
private	OrderService os;
	
	//private final static Logger log = LoggerFactory.getLogger(OrderController.class);
	@PostMapping("save")
	public ResponseEntity<orderDTO> saveorder(@Validated @RequestBody orderDTO op)
	{
		log.info("Iam at "+log.getName());
		log.info(op.toString());
		os.save(op);
		return new ResponseEntity<orderDTO>(op,HttpStatus.CREATED);
	}
	
	@GetMapping("getbyid/{id}")
	public ResponseEntity<orderDTO> getbyorderid(@PathVariable Integer id) throws OrderException
	{
		
		//log.info("Iam at "+log.getName());
		orderDTO p = os.getbyOrderid(id);	
		log.info(id+"-data-"+p);
		
		
		return new ResponseEntity<orderDTO>(p,HttpStatus.FOUND);
	}
	@Scheduled(cron = "0 * * * * *")
	//@Scheduled(fixedRate = 60000)
	@GetMapping("getall")
	public ResponseEntity<List<orderDTO>> getAll() throws OrderException
	{
		
		List<orderDTO> p = os.getAll();
		log.info("Order controller Data--"+p.toString());
		return new ResponseEntity<List<orderDTO>>(p,HttpStatus.FOUND);
	}
	@PutMapping("update")
	public ResponseEntity<orderDTO> update(@RequestBody orderDTO od)
	{
	 orderDTO d =	os.update(od);
	 return new ResponseEntity<orderDTO>(d,HttpStatus.CREATED);
	}
}
