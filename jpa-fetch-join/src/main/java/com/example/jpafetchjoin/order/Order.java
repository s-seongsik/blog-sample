package com.example.jpafetchjoin.order;


import com.example.jpafetchjoin.address.Address;
import com.example.jpafetchjoin.product.Product;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "orderer", nullable = false)
  private String orderer;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private Set<Product> products = new HashSet<>();

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private Set<Address> addresses = new HashSet<>();

  public Order(String orderer) {
    this.orderer = orderer;
  }

  public void addProduct(final Product product) {
    products.add(product);
  }


  public void addAddress(final Address address){
    addresses.add(address);
  }


}