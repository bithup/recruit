package com.xgh.recruit.dao;

import com.xgh.recruit.entity.Recommend;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/23.
 */
public interface IRecommendDao {


    /**
     * add
     */
    public int add(Recommend recommend);

    /**
     * addBatch
     */
    public int addBatch(List<Recommend> list);

    /**
     * update
     */
    public int update(Recommend recommend);

    /**
     * delete
     */
    public int deleteById(long id);

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
     *
     * page,pagesize,key
     * @return
     */
    public List<Recommend> getListPage(Map<String, Object> map);

    /**
     * getRows
     * @param map
     * @return  id desc,name ,date asc
     */
    public long getRows(Map<String, Object> map);


}
