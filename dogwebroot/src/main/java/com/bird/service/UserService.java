package com.bird.service;

import com.bird.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: 牛虻.
 * time:2017/11/19 0019
 * email:pettygadfly@gmail.com
 * doc:
 * 传统本地实现接口
 */
@Service
public interface UserService {

    User getUser(User user);

    List<User> getAllUser();

    void test();

//    @Transactional(propagation = Propagation.REQUIRED)
    void addUser(User user);


    User getUserByAccount(User user);

    public void testTx(User user);

}
