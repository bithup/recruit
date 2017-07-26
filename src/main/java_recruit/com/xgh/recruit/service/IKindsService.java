package com.xgh.recruit.service;

import com.xgh.recruit.entity.Kinds;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/24.
 */
public interface IKindsService {


    public int add(Kinds kinds);

    public int delete(long id);

    public int update(Kinds kinds);

    public Kinds get(long id);

    public List<Kinds> getList(Kinds kinds);

    /**
     * getListPage
     *
     * @return
     */
    public List<Kinds> getListPage(Map<String, Object> map);

    /**
     * getRows
     *
     * @param map
     * @return
     */
    public long getRows(Map<String, Object> map);

    /**
     * 获取列表数据
     *
     * @param request
     * @return
     */
    public Map<String, Object> getGrid(HttpServletRequest request);

    /**
     * 通过 parenId 获取子级的分类
     *
     * @param parenId
     * @return
     */
    public List<Map<String, Object>> getChildTreeData(HttpServletRequest request, long parenId);

    /**
     * 通过parentId获取
     *
     * @param request
     * @param paretId
     * @return
     */
    public List<Kinds> getChildData(HttpServletRequest request, long paretId);

    public int save(HttpServletRequest request, Kinds kinds, String op);

    /**
     * 获取表格数据
     *
     * @param request
     * @param parentId
     * @return
     */
    public Map<String, Object> getGridData(HttpServletRequest request, long parentId);

    public boolean isHasChild(Kinds parentId);


}
