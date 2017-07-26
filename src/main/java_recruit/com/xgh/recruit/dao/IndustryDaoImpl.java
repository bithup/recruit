package com.xgh.recruit.dao;

import com.xgh.recruit.dao.read.IIndustryDaoR;
import com.xgh.recruit.dao.write.IIndustryDaoW;
import com.xgh.recruit.entity.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/24.
 */
@Service("industryDao")
public class IndustryDaoImpl implements IIndustryDao {


    @Autowired
    protected IIndustryDaoR industryDaoR;

    @Autowired
    protected IIndustryDaoW industryDaoW;


    public int add(Industry industry) {
        return industryDaoW.add(industry);
    }

    public int update(Industry industry) {
        return industryDaoW.update(industry);
    }


    public Industry get(long id) {
        return industryDaoR.get(id);
    }

    public List<Industry> getList(Map<String, Object> map) {
        return industryDaoR.getList(map);
    }

    public List<Industry> getListPage(Map<String, Object> map) {
        return industryDaoR.getListPage(map);
    }

    public long getRows(Map<String, Object> map) {
        return industryDaoR.getRows(map);
    }
}
