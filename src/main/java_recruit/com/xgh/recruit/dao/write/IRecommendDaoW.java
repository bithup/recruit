package com.xgh.recruit.dao.write;

import com.xgh.recruit.entity.Recommend;

/**
 * Created by CQ on 2017/2/23.
 */
public interface IRecommendDaoW {

    /**
     * 添加反馈
     * @param recommend
     * @return
     */
    public Integer add(Recommend recommend);


    /**
     * update
     */
    public int update(Recommend recommend);

}
