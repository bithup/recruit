package com.xgh.recruit.dao.read;

import com.xgh.recruit.entity.Kinds;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/24.
 */
public interface IKindsDaoR {

    /**
     * get
     * @return
     */
    public Kinds get(long id);

    /**
     * getList
     * @return
     */
    public List<Kinds> getList(Kinds kinds);


    /**
     * getListPage
     *
     * page,pagesize,key
     * @return
     */
    public List<Kinds> getListPage(Map<String, Object> map);

    /**
     * getRows
     * @param map
     * @return  id desc,name ,date asc
     */
    public long getRows(Map<String, Object> map);


    public List<Map<String,Object>> getChildTreeData(Map<String, Object> map);

    public long isHasChild(long parentId);

    public Kinds getByParentId(long parentId);

    /**
     *
     * @param map
     * @return
     */
    public List<Kinds> getChildData(Map<String, Object> map);

}
