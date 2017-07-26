package com.xgh.recruit.dao.write;

import com.xgh.recruit.entity.MemberUser;

/**
 * Created by BSX on 2017/2/23.
 */
public interface IMemberUserDaoW {

    public int insert(MemberUser memberUser);

    public int update(MemberUser memberUser);
}
