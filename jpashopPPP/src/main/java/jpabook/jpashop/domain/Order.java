package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "ORDERS")
public class Order extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(fetch = LAZY,cascade = ALL)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;


    @OneToMany(mappedBy = "order",cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();


    public Member getMember() {
        return member;
    }

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

public void addOrderItem(OrderItem orderitem){
    orderItems.add(orderitem);
    orderitem.setOrder(this);
}


    public void setId(Long id) {
        this.id = id;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
