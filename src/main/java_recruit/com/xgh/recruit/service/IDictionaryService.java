package com.xgh.recruit.service;

import com.xgh.recruit.entity.Dictionary;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/28.
 */
public interface IDictionaryService {


    public Dictionary get(long id);

    public List<Dictionary> getList(Dictionary dictionary);

    public Map<String, Object> getGridList(HttpServletRequest request);

    public int add(Dictionary dictionary);

    public int save(HttpServletRequest request, Dictionary dictionary);

    public int update(Dictionary dictionary);

    /**
     * 根据code,item查询value值
     * @param map
     * @return
     */
    public String getValue(Map<String, Object> map);
}
