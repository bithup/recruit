package com.xgh.recruit.dao.write;

import com.xgh.recruit.entity.Industry;


/**
 * Created by CQ on 2017/2/24.
 */
public interface IIndustryDaoW {


    /**
     * 行业种类
     *
     * @param industry
     * @return
     */
    public Integer add(Industry industry);


    /**
     * update
     */
    public int update(Industry industry);


}
