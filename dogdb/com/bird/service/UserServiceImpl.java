package com.bird.service; 
import com.bird.dao.BaseDao;
import com.bird.dao.UserDao;
import com.bird.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
@Resource
private UserDao userDao ;
@Resource
public void setBaseDao(BaseDao baseDao) {
super.setBaseDao(this.userDao);
}
}
