package com.xgh.recruit.service;

import com.xgh.mng.basic.BaseService;
import com.xgh.recruit.dao.IIndustryDao;
import com.xgh.recruit.entity.Industry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by CQ on 2017/2/24.
 */
@Service("industryService")
public class IndustryServiceImpl extends BaseService implements IIndustryService {

    @Autowired
    protected IIndustryDao industryDao;


    public int add(Industry industry) {
        return industryDao.add(industry);
    }

    public int update(Industry industry) {
        return industryDao.update(industry);
    }

    public int save(HttpServletRequest request, Industry industry) {

        String op = request.getParameter("op");
        if ("modify".equals(op)) {
            Industry industry_ = industryDao.get(industry.getId());

            industry_.setStatus(1);
            industry_.setUpdateDate(new Date());
            industry_.setName(industry.getName());
            industry_.setData6(industry.getData6());
            return industryDao.update(industry_);

        } else {
            industry.setStatus(1);
            industry.setCreateDate(new Date());
            industry.setUpdateDate(new Date());
            int unitId = (int) getCurrentUnitId(request);
            industry.setData7(unitId);
            int instId = (int) getCurrentInstId(request);
            industry.setData5(String.valueOf(instId));
            return industryDao.add(industry);
        }


    }


    public Industry get(long id) {
        return industryDao.get(id);
    }

    public List<Industry> getList(Map<String, Object> map) {
        return industryDao.getList(map);
    }

    public Map<String, Object> getGridList(HttpServletRequest request) {
        String page = request.getParameter("page");
        String pagesize = request.getParameter("pagesize");

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("page", Integer.parseInt(page));
        map.put("pageSize", Integer.parseInt(pagesize));
        map.put("data7", getCurrentUnitId(request));
        map.put("data5", getCurrentInstId(request));

        Map<String, Object> gridMap = new HashMap<String, Object>();
        List<Industry> dataList = industryDao.getListPage(map);
        if (dataList == null) {
            dataList = new ArrayList<Industry>();
        }
        gridMap.put("Rows", dataList);
        gridMap.put("Total", industryDao.getRows(map));
        return gridMap;
    }
}
