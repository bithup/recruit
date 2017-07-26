package com.xgh.recruit.service;

import com.xgh.mng.basic.BaseService;
import com.xgh.mng.entity.SysUnits;
import com.xgh.recruit.dao.IDictionaryDao;
import com.xgh.recruit.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by CQ on 2017/2/28.
 */
@Service("dictionaryService")
public class DictionaryServiceImpl extends BaseService implements IDictionaryService {


    @Autowired
    protected IDictionaryDao dictionaryDao;


    public Dictionary get(long id) {
        return dictionaryDao.get(id);
    }

    public List<Dictionary> getList(Dictionary dictionary) {
        return dictionaryDao.getList(dictionary);
    }

    public Map<String, Object> getGridList(HttpServletRequest request) {
        String page = request.getParameter("page");
        String pagesize = request.getParameter("pagesize");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("instId", getCurrentInstId(request));
        map.put("unitId", getCurrentUnitId(request));
        map.put("type", request.getParameter("type"));
        map.put("page", Integer.parseInt(page));
        map.put("pagesize", Integer.parseInt(pagesize));

        Map<String, Object> gridMap = new HashMap<String, Object>();

        List<Dictionary> dataList = dictionaryDao.getListPage(map);
        if (dataList == null) {
            dataList = new ArrayList<Dictionary>();
        }
        gridMap.put("Rows", dataList);
        gridMap.put("Total", dictionaryDao.getRows(map));
        return gridMap;

    }

    public int add(Dictionary dictionary) {
        return dictionaryDao.add(dictionary);
    }

    public int save(HttpServletRequest request, Dictionary dictionary) {

        if (dictionary.getId() > 1) {

            Dictionary dictionary1 = dictionaryDao.get(dictionary.getId());
            dictionary1.setUpdateDate(new Date());
            dictionary1.setItem(dictionary.getItem());
            dictionary1.setCode(dictionary.getCode());
            dictionary1.setValue(dictionary.getValue());
            return dictionaryDao.update(dictionary1);

        } else {

            long instId = getCurrentInstId(request);
            long unitId = getCurrentUnitId(request);
            SysUnits units = getCurrentUnits(request);
            dictionary.setUnitId(unitId);
            dictionary.setInstId(instId);
            dictionary.setInstCode(units.getInstCode());
            dictionary.setCreateDate(new Date());
            dictionary.setUpdateDate(new Date());
            dictionary.setStatus(1);
            return dictionaryDao.add(dictionary);
        }


    }

    public int update(Dictionary dictionary) {
        return dictionaryDao.update(dictionary);
    }

    public String getValue(Map<String, Object> map) {
        return dictionaryDao.getValue(map);
    }
}
