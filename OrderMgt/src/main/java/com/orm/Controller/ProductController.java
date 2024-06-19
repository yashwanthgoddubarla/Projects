package com.orm.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orm.DTO.ProductDTO;
import com.orm.Service.ProductService;

@RestController
@RequestMapping("product")

public class ProductController {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService ps;
	@PostMapping("save")
	public ResponseEntity<ProductDTO> save(@Validated @RequestBody ProductDTO p)
	{
		log.info("Iam at "+log.getName());
		ps.save(p);
		log.info("saved data "+p.toString());
		return new ResponseEntity<ProductDTO>(p,HttpStatus.CREATED);
		}
	@PutMapping("update")
	public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO p)
	{
		ps.update(p);
		log.info("update data :"+p);
		return new ResponseEntity<ProductDTO>(p,HttpStatus.OK);
	}
	@GetMapping("getbyid/{id}")
	public ResponseEntity<ProductDTO> getbyId(@PathVariable Integer id)
	{
		ProductDTO pd =	ps.getbyId(id);
		return new ResponseEntity<ProductDTO>(pd,HttpStatus.FOUND);
		
	}
	@Scheduled(fixedRate = 60000)
	@GetMapping("getall")
	public ResponseEntity<List<ProductDTO>> getAll()
	{
		List<ProductDTO> l =ps.getAll();
		return new ResponseEntity<List<ProductDTO>>(l,HttpStatus.FOUND);
	}
}
