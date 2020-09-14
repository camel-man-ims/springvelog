package com.example.springvelog.repository;

import com.example.springvelog.SpringvelogApplicationTests;
import com.example.springvelog.entity.OrderGroup;
import com.example.springvelog.entity.User;
import com.example.springvelog.entity.repository.OrderGroupRepository;
import com.example.springvelog.entity.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderGroupRepositoryTest extends SpringvelogApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        Optional<User> findUser = userRepository.findById(7L);

        findUser.ifPresent(user -> {
            OrderGroup orderGroup = OrderGroup.builder()
                    .status("생성23")
                    .orderType("아무거나")
                    .user(user)
                    .build();

            orderGroupRepository.save(orderGroup);
        });

    }
}
