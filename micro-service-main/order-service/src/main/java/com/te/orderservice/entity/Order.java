package com.te.orderservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="order_tab")
public class Order {
	@Id
	private String orderId;
	private int orderQuantity;
	private double orderAmount;
	private String productId;
	private String customerId;
}
