package com.backend.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_products")
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long   id;
  private String name;
  private Double price;
  private String description;
  private String imageUri;

  Product(){}

  Product(Long id, String name, Double price, String description, String imageUri){
    super();
    this.id           = id;
    this.name         = name;
    this.price        = price;
    this.description  = description;
    this.imageUri     = imageUri;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUri() {
    return this.imageUri;
  }

  public void setImageUri(String imageUri) {
    this.imageUri = imageUri;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    return id != null ? id.equals(product.id) : product.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
