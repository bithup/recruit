package com.xgh.recruit.dao.read;

import com.xgh.recruit.entity.Recommend;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/23.
 */
public interface IRecommendDaoR {



    /**
     * get
     * @return
     */
    public Recommend get(long id);

    /**
     * getList
     * @return
     */
    public List<Recommend> getList(Map<String, Object> map);

    /**
     * getListPage
     * <p/>
     * page,pagesize,key
     *
     * @return
     */
    public List<Recommend> getListPage(Map<String, Object> map);

    /**
     * getRows
     *
     * @param map
     * @return id desc,name ,date asc
     */
    public long getRows(Map<String, Object> map);


}
