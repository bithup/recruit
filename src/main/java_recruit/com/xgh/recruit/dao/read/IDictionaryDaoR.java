package com.xgh.recruit.dao.read;

import com.xgh.recruit.entity.Dictionary;

import java.util.List;
import java.util.Map;


/**
 * Created by CQ on 2017/2/28.
 */
public interface IDictionaryDaoR {

    /**
     * 根据主键id查询
     *
     * @param id
     * @return
     */
    public Dictionary get(long id);

    /**
     * @return
     * @2param
     */
    public List<Dictionary> getList(Dictionary dictionary);


    /**
     *
     */
    public List<Dictionary> getListPage(Map<String, Object> map);

    /**
     * 查询行
     *
     * @param map
     * @return
     */
    public long getRows(Map<String, Object> map);

    public String getValue(Map<String, Object> map);


}
