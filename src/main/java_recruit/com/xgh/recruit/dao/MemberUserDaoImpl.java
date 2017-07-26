package com.xgh.recruit.dao;

import com.xgh.recruit.dao.read.IMemberUserDaoR;
import com.xgh.recruit.dao.write.IMemberUserDaoW;
import com.xgh.recruit.entity.MemberUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by BSX on 2017/2/23.
 */
@Service("memberUserDao")
public class MemberUserDaoImpl implements IMemberUserDao {

    @Autowired
    protected IMemberUserDaoR memberUserDaoR;

    @Autowired
    protected IMemberUserDaoW memberUserDaoW;


    public MemberUser get(long id) {
        return memberUserDaoR.get(id);
    }

    public List<MemberUser> getListPage(Map<String, Object> map) {
        return memberUserDaoR.getListPage(map);
    }

    public int getRows(Map<String, Object> map) {
        return memberUserDaoR.getRows(map);
    }

    public int insert(MemberUser memberUser) {
        return memberUserDaoW.insert(memberUser);
    }

    public int update(MemberUser memberUser) {
        return memberUserDaoW.update(memberUser);
    }
}
