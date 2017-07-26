package com.xgh.recruit.service;

import com.xgh.recruit.entity.Industry;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/24.
 */
public interface IIndustryService {


    public int add(Industry industry);

    public int update(Industry industry);

    public int save(HttpServletRequest request, Industry industry);

    public Industry get(long id);

    public List<Industry> getList(Map<String, Object> map);

    public Map<String, Object> getGridList(HttpServletRequest request);



}
