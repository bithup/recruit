package com.xgh.recruit.dao.read;

import com.xgh.recruit.entity.Position;

import java.util.List;
import java.util.Map;

/**
 * Created by BSX on 2017/2/24.
 */
public interface IPositionDaoR {

    public Position get(long id);

    public List<Map<String,Object>> getListPage(Map<String,Object> map);

    public int getRows(Map<String,Object> map);
}
