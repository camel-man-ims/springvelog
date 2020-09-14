package com.example.springvelog.repository;

import com.example.springvelog.SpringvelogApplicationTests;
import com.example.springvelog.entity.OrderDetail;
import com.example.springvelog.entity.OrderGroup;
import com.example.springvelog.entity.repository.OrderDetailRepository;
import com.example.springvelog.entity.repository.OrderGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

class OrderDetailRepositoryTest extends SpringvelogApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){
        Optional<OrderGroup> orderGroup = orderGroupRepository.findById(2L);

        orderGroup.ifPresent(findGroup->{
            OrderDetail orderDetail = OrderDetail.builder()
                    .status("수정")
                    .orderGroup(findGroup)
                    .build();
            orderDetailRepository.save(orderDetail);
        });
    }
}