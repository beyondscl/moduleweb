package com.bird.service; 
import com.bird.dao.BaseDao;
import com.bird.dao.CountrylanguageDao;
import com.bird.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class CountrylanguageServiceImpl extends BaseServiceImpl implements CountrylanguageService {
@Resource
private CountrylanguageDao countrylanguageDao ;
@Resource
public void setBaseDao(BaseDao baseDao) {
super.setBaseDao(this.countrylanguageDao);
}
}
