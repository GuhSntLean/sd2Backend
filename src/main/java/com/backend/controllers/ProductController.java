package com.backend.controllers;

import java.util.List;

import com.backend.dto.ProductDTO;
import com.backend.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/products")
public class ProductController {
  @Autowired
  private ProductService service;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> findAll(){
    List<ProductDTO> list = service.findAll();

    return ResponseEntity.ok().body(list);
  }
}
