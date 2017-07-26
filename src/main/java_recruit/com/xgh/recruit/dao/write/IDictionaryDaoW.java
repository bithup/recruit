package com.xgh.recruit.dao.write;

import com.xgh.recruit.entity.Dictionary;

/**
 * Created by CQ on 2017/2/28.
 */
public interface IDictionaryDaoW {

    /**
     * 添加数据
     *
     * @param dictionary
     * @return
     */
    public int add(Dictionary dictionary);

    /**
     * 更新数据
     *
     * @param dictionary
     * @return
     */
    public int update(Dictionary dictionary);


}
