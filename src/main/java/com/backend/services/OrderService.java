package com.backend.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.backend.dto.OrderDTO;
import com.backend.dto.ProductDTO;
import com.backend.entities.Order;
import com.backend.entities.OrderStatus;
import com.backend.entities.Product;
import com.backend.repositories.OrderRepository;
import com.backend.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
  @Autowired
  private OrderRepository reposiroty;

  @Autowired
  private ProductRepository productRepository;

  @Transactional(readOnly = true)
  public List<OrderDTO> findAll(){
    List<Order> list = reposiroty.findOrdersWithProducts();
    return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
  }

  @Transactional
  public OrderDTO insert(OrderDTO dto){
    Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING, null);

    for(ProductDTO p : dto.getProducts()){
      Product product = productRepository.getOne(p.getId());
      order.getProducts().add(product);
    }

    order = reposiroty.save(order);
    return new OrderDTO(order);
  }
}
