package com.example.lab_3_orderservice.valueObject;

import com.example.lab_3_orderservice.entity.Order;

public class ResponseValueObject{
    private Customer customer;
    private Product product;
    private Employee employee;
    private Order order;

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
