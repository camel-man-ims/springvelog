package com.example.springvelog.ifs;

import com.example.springvelog.network.Header;

public interface CrudInterface<Req,Res> {

   Header<Res> create(Header<Req> request);

   Header read(Long id);

   Header<Res> update(Header<Req> request);

   Header delete(Long id);
}
