package com.xgh.recruit.service;

import com.xgh.recruit.entity.Subject;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/23.
 */
public interface ISubjectService {
    public int add(Subject subject);

    public int update(Subject subject);

    public int save(HttpServletRequest request, Subject subject);

    public int delete(long id);

    public Subject get(long id);

    public List<Subject> getList(Map<String, Object> map);

    public Map<String, Object> getGridList(HttpServletRequest request);

    /**
     * 通过unitId获取subject Tree
     *
     * @param map
     * @return
     */
    public List<Map<String, Object>> getSubjectTree(Map<String, Object> map);
}
