package com.xgh.recruit.service;

import com.xgh.recruit.entity.Recommend;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/23.
 */
public interface IRecommendService {


    public int add(Recommend recommend);

    public int update(Recommend recommend);

    public int save(HttpServletRequest request, Recommend recommend);

    public int delete(long id);

    public Recommend get(long id);

    public List<Recommend> getList(Map<String, Object> map);

    public Map<String, Object> getGridList(HttpServletRequest request);
}
