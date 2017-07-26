package com.xgh.recruit.service;

import com.xgh.recruit.entity.CompanyInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by BSX on 2017/2/24.
 */
public interface ICompanyInfoService {

    public CompanyInfo get(long id);

    public int insert(CompanyInfo companyInfo);

    public int update(CompanyInfo companyInfo);

    public Map<String,Object> getGridPage(HttpServletRequest request);
}
