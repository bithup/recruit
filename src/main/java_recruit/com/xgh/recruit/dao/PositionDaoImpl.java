package com.xgh.recruit.dao;

import com.xgh.recruit.dao.read.IPositionDaoR;
import com.xgh.recruit.dao.write.IPositionDaoW;
import com.xgh.recruit.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by BSX on 2017/2/24.
 */
@Service("positionDao")
public class PositionDaoImpl implements IPositionDao {

    @Autowired
    protected IPositionDaoR positionDaoR;

    @Autowired
    protected IPositionDaoW positionDaoW;

    public int insert(Position position) {
        return positionDaoW.insert(position);
    }

    public int update(Position position) {
        return positionDaoW.update(position);
    }

    public Position get(long id) {
        return positionDaoR.get(id);
    }

    public List<Map<String, Object>> getListPage(Map<String, Object> map) {
        return positionDaoR.getListPage(map);
    }

    public int getRows(Map<String, Object> map) {
        return positionDaoR.getRows(map);
    }
}
