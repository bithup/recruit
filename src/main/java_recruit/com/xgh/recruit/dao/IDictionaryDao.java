package com.xgh.recruit.dao;

import com.xgh.recruit.entity.Dictionary;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/28.
 */
public interface IDictionaryDao {


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

    public String getValue(Map<String, Object> map);


}
