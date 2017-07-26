package com.xgh.recruit.dao.read;

import com.xgh.recruit.entity.MemberUser;

import java.util.List;
import java.util.Map;

/**
 * Created by BSX on 2017/2/23.
 */
public interface IMemberUserDaoR {

    public MemberUser get(long id);

    public List<MemberUser> getListPage(Map<String,Object> map);

    public int getRows(Map<String,Object> map);
}
