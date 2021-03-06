package com.bird.service.user;

import com.bird.dao.BaseDao;
import com.bird.dao.UserDao;
import com.bird.domain.User;
import com.bird.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: 牛虻.
 * time:2017/11/19 0019
 * email:pettygadfly@gmail.com
 * doc:
 */
@Service
public class UserServiceImpl<T> extends BaseServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(this.userDao);
    }
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public void test() {
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserByAccount(User user) {
        return userDao.getUserByAccount(user);
    }

    public void testTx(User user) {

    }

    public long getCount(Class className) {
        return 0;
    }


}
