package com.xgh.recruit.service;

import com.xgh.recruit.entity.Position;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by BSX on 2017/2/25.
 */
public interface IPositionService {

    public int insert(Position position);

    public int update(Position position);

    public Map<String,Object> getGridMap(HttpServletRequest request);

    public Position get(long id);
}
