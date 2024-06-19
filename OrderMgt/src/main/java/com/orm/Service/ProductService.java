package com.orm.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orm.DTO.ProductDTO;

public interface ProductService {
	
	public abstract ProductDTO save(ProductDTO p);
	public abstract ProductDTO update(ProductDTO p);
	public abstract ProductDTO getbyId(Integer pid);
	public abstract List<ProductDTO> getAll();
	public abstract String deletebypid(Integer pid);

}
