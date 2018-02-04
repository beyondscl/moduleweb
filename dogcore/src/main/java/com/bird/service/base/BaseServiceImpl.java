package com.bird.service.base;

import com.bird.dao.BaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: 牛虻.
 * time:2018/1/30
 * email:pettygadfly@gmail.com
 * doc:
 */
@Service
public class BaseServiceImpl<T> implements BaseService {

    @Resource
    private BaseDao baseDao;

    public int saveObject(Object o) {
        return baseDao.saveObject(o);
    }

    public int updateObject(Object o) {

        return baseDao.updateObject(o);
    }

    public int deleteByIds(String[] ids) {
        return baseDao.deleteByIds(ids);
    }

    public int deleteById(String id) {
        return baseDao.deleteById(id);
    }

    public int deleteObject(Object o) {
        return baseDao.deleteObject(o);
    }

    public List<T> findByIds(String[] ids) {
        return baseDao.findByIds(ids);
    }

    public Object findById(String id) {
        return baseDao.findById(id);
    }

    public Object findByObject(Object O) {
        return baseDao.findByObject(O);
    }

    public List queryByPage(Object O) {
        return baseDao.findByPage(O);
    }

    /**
     * 用户必须重写该接口
     */
    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
