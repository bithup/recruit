package com.xgh.recruit.dao;

import com.xgh.recruit.dao.read.IRecommendDaoR;
import com.xgh.recruit.dao.write.IRecommendDaoW;
import com.xgh.recruit.entity.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/23.
 */
@Service("recommendDao")
public class RecommendDaoImpl implements IRecommendDao {


    @Autowired
    protected IRecommendDaoR recommendDaoR;

    @Autowired
    protected IRecommendDaoW recommendDaoW;

    /**
     * add
     */
    public int add(Recommend recommend) {
        return recommendDaoW.add(recommend);
    }


    /**
     * update
     */
    public int update(Recommend recommend) {
        return recommendDaoW.update(recommend);
    }

    public int addBatch(List<Recommend> list) {
        return 0;
    }

    public int deleteById(long id) {
        return 0;
    }

    /**
     * get
     *
     * @return
     */
    public Recommend get(long id) {
        return recommendDaoR.get(id);
    }


    /**
     * getList
     *
     * @return
     */
    public List<Recommend> getList(Map<String, Object> map) {
        return recommendDaoR.getList(map);
    }

    /**
     * getListPage
     * <p/>
     * page,pagesize,key
     *
     * @return
     */
    public List<Recommend> getListPage(Map<String, Object> map) {
        return recommendDaoR.getListPage(map);
    }

    /**
     * getRows
     *
     * @param map
     * @return id desc,name ,date asc
     */
    public long getRows(Map<String, Object> map) {
        return recommendDaoR.getRows(map);
    }
}
