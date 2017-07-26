package com.xgh.recruit.dao;

import com.xgh.recruit.dao.read.ISubjectDaoR;
import com.xgh.recruit.dao.write.ISubjectDaoW;
import com.xgh.recruit.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CQ on 2017/2/23.
 */
@Service("subjectDao")
public class SubjectDaoImpl implements ISubjectDao {


    @Autowired
    protected ISubjectDaoR subjectDaoR;

    @Autowired
    protected ISubjectDaoW subjectDaoW;


    public int add(Subject subject) {
        return subjectDaoW.add(subject);
    }

    public int addBatch(List<Subject> list) {
        return subjectDaoW.addBatch(list);
    }

    public int update(Subject subject) {
        return subjectDaoW.update(subject);
    }

    public int deleteById(long id) {
        return subjectDaoW.deleteById(id);
    }

    public Subject get(long id) {
        return subjectDaoR.get(id);
    }

    public List<Subject> getList(Map<String, Object> map) {
        return subjectDaoR.getList(map);
    }

    public List<Subject> getListPage(Map<String, Object> map) {
        return subjectDaoR.getListPage(map);
    }

    public long getRows(Map<String, Object> map) {
        return subjectDaoR.getRows(map);
    }

    public List<Map<String, Object>> getSubjectTree(Map<String, Object> map) {
        return subjectDaoR.getSubjectTree(map);
    }
}
