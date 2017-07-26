package com.xgh.recruit.service;

import com.xgh.recruit.entity.MemberUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
public interface IMemberUserService {

    public MemberUser get(long id);

    public Map<String, Object> getGridList(HttpServletRequest request);

    public int insert(MemberUser memberUser);

    public int update(MemberUser memberUser);
}
