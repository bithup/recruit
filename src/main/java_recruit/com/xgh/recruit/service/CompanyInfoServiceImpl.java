package com.xgh.recruit.service;

import com.xgh.recruit.dao.ICompanyInfoDao;
import com.xgh.recruit.entity.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BSX on 2017/2/24.
 */
@Service("companyInfoService")
public class CompanyInfoServiceImpl implements ICompanyInfoService {

    @Autowired
    protected ICompanyInfoDao companyInfoDao;

    @Autowired
    protected IDictionaryService dictionaryService;

    public CompanyInfo get(long id) {
        return companyInfoDao.get(id);
    }

    public int insert(CompanyInfo companyInfo) {
        return companyInfoDao.insert(companyInfo);
    }

    public int update(CompanyInfo companyInfo) {
        return companyInfoDao.update(companyInfo);
    }

    public Map<String, Object> getGridPage(HttpServletRequest request) {
        Map<String,Object> gridMap = new HashMap<String, Object>();
        Map<String,Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String isCheck = request.getParameter("isCheck");
        String page = request.getParameter("page");
        String pagesize = request.getParameter("pagesize");
        map.put("account",account);
        map.put("isCheck",isCheck);
        map.put("page",Integer.parseInt(page));
        map.put("pagesize",Integer.parseInt(pagesize));
        List<Map<String,Object>> list = companyInfoDao.getListPage(map);
        for (Map<String,Object> list_:list){
            Map<String,Object> map1 = new HashMap<String, Object>();
            String companySize = String.valueOf(list_.get("companySize"));
            map1.put("item","companySize");
            map1.put("code",companySize);
            list_.put("companySize",dictionaryService.getValue(map1));
        }
        gridMap.put("Rows",list);
        gridMap.put("Total",companyInfoDao.getRows(map));
        return gridMap;
    }
}
