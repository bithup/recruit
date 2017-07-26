package com.xgh.recruit.controller;

import com.xgh.mng.basic.BaseController;
import com.xgh.mng.entity.SysUnits;
import com.xgh.recruit.entity.Subject;
import com.xgh.recruit.service.ISubjectService;
import com.xgh.util.ConstantUtil;
import com.xgh.util.JSONUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by CQ on 2017/2/23.
 */

@Controller
@Scope("prototype")
@RequestMapping(value = "/recruit/subject/")
public class SubjectController extends BaseController {

    private Logger logger = Logger.getLogger(SubjectController.class);

    @Autowired
    protected ISubjectService subjectService;


    @RequestMapping(value = "/init")
    public ModelAndView init() {
        logger.info("init");
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/subject/init");

        //获取当前登录的公司
        SysUnits sysUnits = getCurrentUnits();

        List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();

        Map<String, Object> map0 = new HashMap<String, Object>();
        map0.put("id", 0);
        map0.put("text", sysUnits.getUnitName());
        treeList.add(map0);

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", 1);
        map1.put("pid", 0);
        map1.put("text", "头部主题");
        treeList.add(map1);

/*      Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", 2);
        map2.put("pid", 0);
        map2.put("text", "主页主题");
        treeList.add(map2);*/


        view.addObject("treedata", JSONUtil.getJson(treeList));
        view.addObject("toolbar", sysButtonService.getMenuButtons(request, getCurrentSysRoleId(), getCurrentUser()));
        view.addObject("gridComluns", sysGridColumnsService.getGridColumsByRequest(request));

        return view;
    }

    @RequestMapping(value = "/getList")
    public void getList() {
        logger.info("getList");

        outJson(subjectService.getGridList(request));
    }


    @RequestMapping(value = "/add")
    public ModelAndView add(@ModelAttribute Subject subject) {
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/subject/add");
        if (subject != null && subject.getId() > 0) {
            //id>0 认为是修改操作
            subject = subjectService.get(subject.getId());
            String serverUrl = ConstantUtil.SERVER_URL;

            if (subject.getMobileFilePath() != null) {
                Map<String, Object> mobileImgData = new HashMap<String, Object>();
                mobileImgData.put("url", serverUrl + subject.getMobileFilePath());
                view.addObject("mobileImgData", JSONUtil.getJson(mobileImgData));
            }

            if (subject.getAndroidFilePath() != null) {
                Map<String, Object> androidImgData = new HashMap<String, Object>();
                androidImgData.put("url", serverUrl + subject.getAndroidFilePath());
                view.addObject("androidImgData", JSONUtil.getJson(androidImgData));
            }

            if (subject.getIosFilePath() != null) {
                Map<String, Object> iosImgData = new HashMap<String, Object>();
                iosImgData.put("url", serverUrl + subject.getMobileFilePath());
                view.addObject("iosImgData", JSONUtil.getJson(iosImgData));
            }

            if (subject.getPcFilePath() != null) {
                Map<String, Object> pcImgData = new HashMap<String, Object>();
                pcImgData.put("url", serverUrl + subject.getMobileFilePath());
                view.addObject("pcImgData", JSONUtil.getJson(pcImgData));
            }
            view.addObject("op", "modify");
        }
        //获取验证
        view.addObject("validationRules", sysValidationService.getValidationByCode("mngsubject_validate"));
        view.addObject("subject", subject);
        return view;
    }

    @RequestMapping(value = "/save")
    public void save(@ModelAttribute Subject subject) {
        logger.info("save");
        Map<String, Object> resultMap = new HashMap<String, Object>();

        if (subject != null) {
            //判断添加修改,aom, 0 添加,1 修改
            Long a = subject.getId();

            System.out.println("......" + a);

            int aom = subject.getId() > 1 ? 1 : 0;
            int flg = subjectService.save(request, subject);

            if (aom == 1) {
                if (flg == 1) {
                    resultMap = getResultMap("1", "修改成功!");
                } else if (aom == -1) {
                    resultMap = getResultMap("-1", "请移除主题下多余商品!");
                } else if (aom == -2) {
                    resultMap = getResultMap("-1", "请移除主题下商品!");
                } else
                    resultMap = getResultMap("1", "修改失败!");
            } else {
                if (flg == 1) {
                    resultMap = getResultMap("1", "添加成功!");
                } else
                    resultMap = getResultMap("0", "添加失败!");
            }
        } else
            resultMap = getResultMap("0", "数据初始化失败!");

        outJson(resultMap);
    }

    @RequestMapping(value = "/delete")
    public void delete(@ModelAttribute Subject subject) {
        logger.info("delete");
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Subject subject2 = subjectService.get(subject.getId());
        subject2.setUpdateDate(new Date());
        subject2.setStatus(-1);

        int flg = subjectService.update(subject2);
        if (flg == 1) {
            resultMap = getResultMap("1", "删除成功!");
        } else
            resultMap = getResultMap("0", "删除失败!");

        outJson(resultMap);
    }
}
