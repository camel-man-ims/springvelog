package com.example.springvelog.repository;


import com.example.springvelog.SpringvelogApplicationTests;
import com.example.springvelog.entity.User;
import com.example.springvelog.entity.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class UserRepositoryTest extends SpringvelogApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = User.builder().account("0912").status("좋음").build();

        userRepository.save(user);
    }

    @Test
    @Transactional
    public void read(){
        Optional<User> findUser = userRepository.findById(7L);

        findUser.ifPresent(user->{
            user.getOrderGroupList().stream().forEach(item->{
                System.out.println(item.getOrderDetailList());
            });
        });
    }

    @Test
    public void update(){
        Optional<User> findUser = userRepository.findById(10L);

        findUser.ifPresent(user->{
            user.setStatus("수정");

            userRepository.save(user);
        });
    }

    @Test
    public void delete(){
        Optional<User> findUser = userRepository.findById(10L);

        findUser.ifPresent(user->{
            userRepository.delete(user);
        });
    }
}
