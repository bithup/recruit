package com.xgh.recruit.dao;

import com.xgh.recruit.entity.MemberUser;

import java.util.List;
import java.util.Map;

/**
 * Created by BSX on 2017/2/23.
 */
public interface IMemberUserDao {

    public MemberUser get(long id);

    public List<MemberUser> getListPage(Map<String,Object> map);

    public int getRows(Map<String,Object> map);

    public int insert(MemberUser memberUser);

    public int update(MemberUser memberUser);
}
