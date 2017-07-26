package com.xgh.recruit.dao.write;

import com.xgh.recruit.entity.Subject;

import java.util.List;

/**
 * Created by CQ on 2017/2/23.
 */
public interface ISubjectDaoW {

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

}
