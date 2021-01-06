package com.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import com.backend.dto.OrderDTO;
import com.backend.entities.Order;
import com.backend.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
  @Autowired
  private OrderRepository reposiroty;

  @Transactional(readOnly = true)
  public List<OrderDTO> findAll(){
    List<Order> list = reposiroty.findOrdersWithProducts();
    return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
  }
}
