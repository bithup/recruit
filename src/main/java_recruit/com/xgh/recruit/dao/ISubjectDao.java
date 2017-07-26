package com.xgh.recruit.dao;

import com.xgh.recruit.entity.Subject;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/23.
 */
public interface ISubjectDao {

    /**
     * add
     */
    public int add(Subject subject);

    /**
     * addBatch
     */
    public int addBatch(List<Subject> list);

    /**
     * update
     */
    public int update(Subject subject);

    /**
     * delete
     */
    public int deleteById(long id);

    /**
     * get
     * @return
     */
    public Subject get(long id);


    /**
     * getList
     * @return
     */
    public List<Subject> getList(Map<String, Object> map);


    /**
     * getListPage
     *
     * page,pagesize,key
     * @return
     */
    public List<Subject> getListPage(Map<String, Object> map);

    /**
     * getRows
     * @param map
     * @return  id desc,name ,date asc
     */
    public long getRows(Map<String, Object> map);

    /**
     * 通过unitId获取subject Tree
     * @param map
     * @return
     */
    public List<Map<String,Object>> getSubjectTree(Map<String, Object> map);
}
