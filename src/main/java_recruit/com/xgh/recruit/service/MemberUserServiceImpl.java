package com.xgh.recruit.service;

import com.xgh.recruit.dao.IMemberUserDao;
import com.xgh.recruit.entity.MemberUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service("memberUserService")
public class MemberUserServiceImpl implements IMemberUserService {

    @Autowired
    protected IMemberUserDao memberUserDao;

    public MemberUser get(long id) {
        return memberUserDao.get(id);
    }

    public Map<String, Object> getGridList(HttpServletRequest request) {
        Map<String,Object> gridMap = new HashMap<String, Object>();
        Map<String,Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String page = request.getParameter("page");
        String pagesize = request.getParameter("pagesize");
        map.put("account",account);
        map.put("page",Integer.parseInt(page));
        map.put("pagesize",Integer.parseInt(pagesize));
        List<MemberUser> list = memberUserDao.getListPage(map);
        gridMap.put("Rows",list);
        gridMap.put("Total",memberUserDao.getRows(map));
        return gridMap;
    }

    public int insert(MemberUser memberUser) {
        return memberUserDao.insert(memberUser);
    }

    public int update(MemberUser memberUser) {
        return memberUserDao.update(memberUser);
    }
}
