package com.xgh.recruit.service;

import com.xgh.recruit.dao.IPositionDao;
import com.xgh.recruit.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BSX on 2017/2/25.
 */
@Service("positionService")
public class PositionServiceImpl implements IPositionService {

    @Autowired
    protected IPositionDao positionDao;

    public int insert(Position position) {
        return positionDao.insert(position);
    }

    public int update(Position position) {
        return positionDao.update(position);
    }

    public Map<String, Object> getGridMap(HttpServletRequest request) {
        Map<String,Object> gridMap = new HashMap<String, Object>();
        Map<String,Object> map = new HashMap<String, Object>();
        String page = request.getParameter("page");
        String pagesize = request.getParameter("pagesize");
        String isCheck = request.getParameter("isCheck");
        String jobName = request.getParameter("jobName");
        map.put("page",Integer.parseInt(page));
        map.put("pagesize",Integer.parseInt(pagesize));
        map.put("isCheck",isCheck);
        map.put("jobName",jobName);
        List<Map<String,Object>> list = positionDao.getListPage(map);
        gridMap.put("Rows",list);
        gridMap.put("Total",positionDao.getRows(map));
        return gridMap;
    }

    public Position get(long id) {
        return positionDao.get(id);
    }
}
