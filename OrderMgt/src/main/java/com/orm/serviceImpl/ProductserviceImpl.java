package com.orm.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.orm.DTO.ProductDTO;
import com.orm.Entity.ProductPojo;
import com.orm.Repo.productRepo;
import com.orm.Service.ProductService;
@Component
public class ProductserviceImpl implements ProductService{
	@Autowired
	private productRepo pr;
	@Autowired
	private ModelMapper mmap;

	@Override
	public ProductDTO save(ProductDTO p) {
		
		ProductPojo pp =mmap.map(p, ProductPojo.class);
		pr.save(pp);
		return p;
	}

	@Override
	public ProductDTO update(ProductDTO p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO getbyId(Integer pid) {
		 Optional<ProductPojo> p =pr.findById(pid);
		  ProductPojo pp =p.get();
		  ProductDTO d =mmap.map(pp, ProductDTO.class);
		 return d;
	}

	@Override
	public List<ProductDTO> getAll() {
		List<ProductPojo> r =pr.findAll();
		ProductDTO[] p =mmap.map(r, ProductDTO[].class);
		List<ProductDTO> d = Arrays.asList(p);
		System.out.println(d);
		return d;
	}

	@Override
	public String deletebypid(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
