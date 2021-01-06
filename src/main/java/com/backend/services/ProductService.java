package com.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import com.backend.dto.ProductDTO;
import com.backend.entities.Product;
import com.backend.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepository repository;

  @Transactional(readOnly = true)
  public List<ProductDTO> findAll(){ 
    List<Product> list = repository.findAll();
    return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
  }
}
