package com.webService;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    User getUserInfo(int id);
}
