package com.example.springvelog.controller;

import com.example.springvelog.ifs.CrudInterface;
import com.example.springvelog.network.Header;
import com.example.springvelog.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public abstract class CrudController<Req,Res,Entity> implements CrudInterface<Req,Res> {

    @Autowired
    protected BaseService<Req,Res,Entity> baseService;

    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> request) {
        return baseService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header read(@PathVariable(name="id") Long id) {
        return baseService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<Res> update(@RequestBody Header<Req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable(name="id") Long id) {
        return baseService.delete(id);
    }
}
