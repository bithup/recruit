package com.xgh.recruit.dao;

import com.xgh.recruit.dao.read.IDictionaryDaoR;
import com.xgh.recruit.dao.write.IDictionaryDaoW;
import com.xgh.recruit.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/28.
 */
@Service("dictionaryDao")
public class DictionaryDaoImpl implements IDictionaryDao {

    @Autowired
    protected IDictionaryDaoR dictionaryDaoR;

    @Autowired
    protected IDictionaryDaoW dictionaryDaoW;


    public Dictionary get(long id) {
        return dictionaryDaoR.get(id);
    }

    public List<Dictionary> getList(Dictionary dictionary) {
        return dictionaryDaoR.getList(dictionary);
    }

    public List<Dictionary> getListPage(Map<String, Object> map) {
        return dictionaryDaoR.getListPage(map);
    }

    public long getRows(Map<String, Object> map) {
        return dictionaryDaoR.getRows(map);
    }

    public int add(Dictionary dictionary) {
        return dictionaryDaoW.add(dictionary);
    }

    public int update(Dictionary dictionary) {
        return dictionaryDaoW.update(dictionary);
    }

    public String getValue(Map<String, Object> map) {
        return dictionaryDaoR.getValue(map);
    }
}
