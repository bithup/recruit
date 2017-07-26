package com.xgh.recruit.dao;

import com.xgh.recruit.dao.read.ICompanyInfoDaoR;
import com.xgh.recruit.dao.read.IMemberUserDaoR;
import com.xgh.recruit.dao.write.ICompanyInfoDaoW;
import com.xgh.recruit.entity.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by BSX on 2017/2/24.
 */
@Service("companyInfoDao")
public class CompanyInfoDaoImpl implements ICompanyInfoDao {

    @Autowired
    protected ICompanyInfoDaoR companyInfoDaoR;

    @Autowired
    protected ICompanyInfoDaoW companyInfoDaoW;

    public CompanyInfo get(long id) {
        return companyInfoDaoR.get(id);
    }

    public List<Map<String,Object>> getListPage(Map<String, Object> map) {
        return companyInfoDaoR.getListPage(map);
    }

    public int getRows(Map<String, Object> map) {
        return companyInfoDaoR.getRows(map);
    }

    public int insert(CompanyInfo companyInfo) {
        return companyInfoDaoW.insert(companyInfo);
    }

    public int update(CompanyInfo companyInfo) {
        return companyInfoDaoW.update(companyInfo);
    }
}
