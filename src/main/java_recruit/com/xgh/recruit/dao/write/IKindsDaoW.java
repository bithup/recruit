package com.xgh.recruit.dao.write;

import com.xgh.recruit.entity.Kinds;

/**
 * Created by CQ on 2017/2/24.
 */
public interface IKindsDaoW {

    /**
     * add
     */
    public int add(Kinds kinds);

    /**
     * update
     */
    public int update(Kinds kinds);

    /**
     * delete
     */
    public int deleteById(long id);

    /**
     * deleteByNid
     */
    public int deleteByNid(long nid);

}
