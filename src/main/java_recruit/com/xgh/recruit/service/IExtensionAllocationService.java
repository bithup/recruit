package com.xgh.recruit.service;

import com.xgh.recruit.entity.ExtensionAllocation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: lcp
 * @Description:
 * @Date: 2017/6/19 0019
 */
public interface IExtensionAllocationService {

    public int update(ExtensionAllocation extensionAllocation);

    public ExtensionAllocation get(long id);

    public List<Map<String, Object>> getList(Map<String, Object> map);

    public Map<String,Object> getGridList(HttpServletRequest request);

    public int save(HttpServletRequest request, ExtensionAllocation extensionAllocation);
}
