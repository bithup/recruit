package com.xgh.recruit.dao;

import com.xgh.recruit.entity.Industry;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/24.
 */
public interface IIndustryDao {


    /**
     * add
     */
    public int add(Industry industry);


    /**
     * update
     */
    public int update(Industry industry);



    /**
     * get
     *
     * @return
     */
    public Industry get(long id);


    /**
     * getList
     *
     * @return
     */
    public List<Industry> getList(Map<String, Object> map);

    /**
     * getListPage
     * <p/>
     * page,pagesize,key
     *
     * @return
     */
    public List<Industry> getListPage(Map<String, Object> map);

    /**
     * getRows
     *
     * @param map
     * @return id desc,name ,date asc
     */
    public long getRows(Map<String, Object> map);


}
