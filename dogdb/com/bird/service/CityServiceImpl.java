package com.bird.service; 
import com.bird.dao.BaseDao;
import com.bird.dao.CityDao;
import com.bird.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class CityServiceImpl extends BaseServiceImpl implements CityService {
@Resource
private CityDao cityDao ;
@Resource
public void setBaseDao(BaseDao baseDao) {
super.setBaseDao(this.cityDao);
}
}
