package com.example.springvelog.controller;

import com.example.springvelog.entity.User;
import com.example.springvelog.network.Header;
import com.example.springvelog.network.request.UserApiRequest;
import com.example.springvelog.network.response.UserApiResponse;
import com.example.springvelog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends CrudController<UserApiRequest, UserApiResponse, User>
{
    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort="id",direction = Sort.Direction.ASC,size=10) Pageable pageable){
      return userService.search(pageable);
    }
}
