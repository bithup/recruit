
package com.xgh.recruit.service;
import com.xgh.mng.basic.BaseService;
import com.xgh.recruit.dao.ISubjectDao;
import com.xgh.recruit.entity.Subject;
import com.xgh.mng.entity.SysIndustry;
import com.xgh.mng.entity.SysUnits;
import com.xgh.recruit.service.ISubjectService;
import com.xgh.security.Base64Util;
import com.xgh.util.ConstantUtil;
import com.xgh.util.JSONUtil;
import com.xgh.util.JSONValidator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * SubjectService Impl
 *
 * @author h2y
 * @time:2016-01-26 20:35:10
 * @Email:
 */
@Service("subjectService")
public class SubjectServiceImpl extends BaseService implements ISubjectService {


    @Autowired
    protected ISubjectDao subjectDao;




    /**
     * Add data, pay attention to the path of the gain of algorithm
     *
     * @param subject
     */
    public int add(Subject subject) {
        // TODO Auto-generated method stub

        return subjectDao.add(subject);
    }

    public int update(Subject subject) {
        // TODO Auto-generated method stub
        return subjectDao.update(subject);
    }

    /**
     * 保存主题
     *
     * @param request
     * @param subject
     * @return
     */
    public int save(HttpServletRequest request, Subject subject) {

        //此处认为不为空，进行操作，是否为空的判断在controller中进行
        if (subject != null && subject.getId() < 1) {
            //该处认为是添加操作
            Date date = new Date();

            subject = setSubjectImg(request, subject);
            SysUnits sysUnits = getCurrentUnits(request);
            SysIndustry sysIndustry = getCurrentIndustry(request);

            subject.setUnitId(sysUnits.getId());
            subject.setUnitCode(sysUnits.getUnitCode());

            subject.setInstId(sysIndustry.getId());
            subject.setInstCode(sysIndustry.getCode());

            subject.setUserId(getCurrentUserId(request));

            subject.setCreateDate(date);
            subject.setUpdateDate(date);
            subject.setStatus(1);

            return add(subject);
        } else {
            Subject subject2 = get(subject.getId());

            //
/*            if (subject.getSubjectType() > 1) {
                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put("unitId", subject2.getUnitId());
                paramMap.put("dataType", 2);
                paramMap.put("dataId", subject.getId());

                int goodsCount = aosGoodsRtService.getGoodsCount(paramMap);

                if (subject.getSubjectType() == 2 && goodsCount > 1) {
                    //subujectType 2 单个商品类型
                    return -1;
                } else {
                    if (goodsCount > 0) {
                        //subjectType 3,4 不能关联商品
                        return -2;
                    }
                }
            }*/

            subject2.setSubjectName(subject.getSubjectName());
            subject2.setSubjectType(subject.getSubjectType());
            subject2.setRemark(subject.getRemark());
            subject2.setSubjectContent(subject.getSubjectContent());
            subject2 = setSubjectImg(request, subject2);
            subject2.setUpdateDate(new Date());
            subject2.setOrd(subject.getOrd());
            return update(subject2);
        }
    }

    public int delete(long id) {
        // TODO Auto-generated method stub
        return subjectDao.deleteById(id);
    }

    public Subject get(long id) {
        // TODO Auto-generated method stub
        return subjectDao.get(id);
    }

    public List<Subject> getList(Map<String, Object> map) {

        return subjectDao.getList(map);
    }

    public Map<String, Object> getGridList(HttpServletRequest request) {

        String page = request.getParameter("page");
        String pagesize = request.getParameter("pagesize");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("instId", getCurrentInstId(request));
        map.put("unitId", getCurrentUnitId(request));
        map.put("type", request.getParameter("type"));
        map.put("page", Integer.parseInt(page));
        map.put("pagesize", Integer.parseInt(pagesize));

        Map<String, Object> gridMap = new HashMap<String, Object>();

        List<Subject> dataList = subjectDao.getListPage(map);
        if (dataList == null) {
            dataList = new ArrayList<Subject>();
        }
        gridMap.put("Rows", dataList);
        gridMap.put("Total", subjectDao.getRows(map));
        return gridMap;
    }

    /**
     * 通过unitId获取subject Tree
     *
     * @param map
     * @return
     */
    public List<Map<String, Object>> getSubjectTree(Map<String, Object> map) {
        return subjectDao.getSubjectTree(map);
    }

    private Subject setSubjectImg(HttpServletRequest request, Subject subject) {
        String _mobileImgData = request.getParameter("mobileImgData");
        String _androidImgData = request.getParameter("androidImgData");
        String _iosImgData = request.getParameter("iosImgData");
        String _pcImgData = request.getParameter("pcImgData");

        if (subject.getId() < 1) {
            //添加操作
            //存储位置
            String saveToPath = ConstantUtil.SAVE_PATH;
            subject.setPath(saveToPath);
        }

        if (JSONValidator.validate(_mobileImgData)) {
            Map<String, Object> mobileImgData = JSONUtil.getMap(_mobileImgData);
            if (mobileImgData.size() > 1) {
                subject.setMobileFilePath(copyFile(mobileImgData));
            }
        }

        if (JSONValidator.validate(_androidImgData)) {
            Map<String, Object> androidImgData = JSONUtil.getMap(_androidImgData);
            if (androidImgData.size() > 1) {
                subject.setAndroidFilePath(copyFile(androidImgData));
            }
        }

        if (JSONValidator.validate(_iosImgData)) {
            Map<String, Object> iosImgData = JSONUtil.getMap(_iosImgData);
            if (iosImgData.size() > 1) {
                subject.setIosFilePath(copyFile(iosImgData));
            }
        }

        if (JSONValidator.validate(_pcImgData)) {
            Map<String, Object> pcImgData = JSONUtil.getMap(_pcImgData);
            if (pcImgData.size() > 1) {
                subject.setPcFilePath(copyFile(pcImgData));
            }
        }

        return subject;
    }

    private String copyFile(Map<String, Object> map) {

        String srcPath = null;
        try {
            srcPath = Base64Util.decodeToString(map.get("savePath") + "");
            String fileName = map.get("fileName") + "";

            //存储位置
            String saveToPath = ConstantUtil.SAVE_PATH;
            //日期作为相对路径
            SimpleDateFormat formatdate = new SimpleDateFormat("yyyy/MM/dd/");
            String _relative_path = formatdate.format(new Date());

            String relative_path = "/" + ConstantUtil.FileUploadCode.Subject.value() + "/" + _relative_path + fileName;

            String destPath = saveToPath + relative_path;

            FileUtils.copyFile(new File(srcPath), new File(destPath));

            return relative_path;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}