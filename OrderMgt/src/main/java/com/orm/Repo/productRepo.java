package com.orm.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orm.Entity.ProductPojo;
@Repository
public interface productRepo extends JpaRepository<ProductPojo, Integer>{

}
