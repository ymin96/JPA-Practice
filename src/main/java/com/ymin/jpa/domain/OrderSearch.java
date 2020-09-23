package com.ymin.jpa.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specifications;

import static com.ymin.jpa.domain.OrderSpec.memberNameLike;
import static com.ymin.jpa.domain.OrderSpec.orderStatusEq;

@Getter
@Setter
public class OrderSearch {

    private String memberName; //회원 이름
    private OrderStatus orderStatus; //주문 상태[ORDER, CANCEL]

    public Specifications<Order> toSpecification(){
        return Specifications.where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
    }
}
