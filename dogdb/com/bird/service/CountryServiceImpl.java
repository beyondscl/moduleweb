package com.bird.service; 
import com.bird.dao.BaseDao;
import com.bird.dao.CountryDao;
import com.bird.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class CountryServiceImpl extends BaseServiceImpl implements CountryService {
@Resource
private CountryDao countryDao ;
@Resource
public void setBaseDao(BaseDao baseDao) {
super.setBaseDao(this.countryDao);
}
}
