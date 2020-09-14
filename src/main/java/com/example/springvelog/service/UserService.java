package com.example.springvelog.service;

import com.example.springvelog.entity.User;
import com.example.springvelog.entity.repository.UserRepository;
import com.example.springvelog.ifs.CrudInterface;
import com.example.springvelog.network.Header;
import com.example.springvelog.network.request.UserApiRequest;
import com.example.springvelog.network.response.UserApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userData = request.getData();

        User newUser = User.builder()
                .account(userData.getAccount())
                .password(userData.getPassword())
                .phoneNumber("010404031414")
                .build();

        User returnData = userRepository.save(newUser);

        return response(returnData);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        Optional<User> findUser = userRepository.findById(id);

        return findUser.map(user ->
                response(user)
        ).orElseGet(() -> Header.ERROR("에러"));

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        UserApiRequest userApiRequest = request.getData();

        Optional<User> findUser = userRepository.findById(userApiRequest.getId());

        return findUser.map(user -> {
            user.setId(userApiRequest.getId());
            user.setStatus(userApiRequest.getStatus());
            return user;
        }).map(user -> userRepository.save(user))
            .map(user -> response(user))
             .orElseGet(() -> Header.ERROR("에러"));
    }

    @Override
    public Header delete(Long id) {

        Optional<User> findUser = userRepository.findById(id);

        return findUser.map(user->{
            userRepository.delete(user);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("에러"));

    }

    public Header<UserApiResponse> response(User user) {
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .status(user.getStatus())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .account(user.getAccount())
                .build();


        return Header.OK(userApiResponse);
    }
}
