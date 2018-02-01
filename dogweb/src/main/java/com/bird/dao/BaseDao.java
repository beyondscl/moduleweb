package com.bird.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: 牛虻.
 * time:2018/1/30
 * email:pettygadfly@gmail.com
 * doc:
 */
@Repository
public interface BaseDao<T> {

    int saveObject(Object o);

    int updateObject(Object o);

    int deleteById(String id);

    int deleteObject(Object o);

    T findById(String id);

    T findByObject(Object O);

    List<T> queryByPage(Object O);
}
