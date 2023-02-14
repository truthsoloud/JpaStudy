package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS") //db에는 order가 예약어로 걸려있으므로
public class Order {

//    id
    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

//    member: Member
    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

//    orderItems List
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    //    delivery
    @OneToOne
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

//    orderDate
    private LocalDateTime orderDate;

//    status
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


}
