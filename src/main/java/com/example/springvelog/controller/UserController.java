package com.example.springvelog.controller;

import com.example.springvelog.ifs.CrudInterface;
import com.example.springvelog.network.Header;
import com.example.springvelog.network.request.UserApiRequest;
import com.example.springvelog.network.response.UserApiResponse;
import com.example.springvelog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController implements CrudInterface<UserApiRequest, UserApiResponse>
{
    @Autowired
    private UserService userService;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        return userService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
        return userService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return userService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable(name="id") Long id) {
        return userService.delete(id);
    }
}
