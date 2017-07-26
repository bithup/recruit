package com.xgh.recruit.controller;

import com.xgh.mng.basic.BaseController;
import com.xgh.recruit.entity.Industry;
import com.xgh.recruit.entity.Kinds;
import com.xgh.recruit.service.IIndustryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CQ on 2017/2/24.
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/recruit/industry/")
public class IndustryController extends BaseController {

    Logger logger = Logger.getLogger(IndustryController.class);

    @Autowired
    protected IIndustryService industryService;

    /**
     * @return
     */
    @RequestMapping(value = "init")
    public ModelAndView init() {
        System.out.println("1...........");
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/industry/init");
        view.addObject("toolbar", sysButtonService.getMenuButtons(request, getCurrentSysRoleId(), getCurrentUser()));
        view.addObject("gridComluns", sysGridColumnsService.getGridColumsByRequest(request));
        return view;

    }

    @RequestMapping(value = "/add")
    public ModelAndView add(@ModelAttribute Industry industry, @RequestParam String op) {
        ModelAndView view = new ModelAndView();
        logger.info("add");
        if ("modify".equals(op)) {
            industry = industryService.get(industry.getId());
        }
        System.out.println("1..........");
        view.addObject("op", op);
        view.setViewName("recruit/industry/add");
        view.addObject("recruit", industry);
        return view;
    }

    @RequestMapping(value = "/getList")
    public void getList() {
        logger.info("getList");
        outJson(industryService.getGridList(request));

    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete")
    public void delete(@ModelAttribute Industry industry) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        long id = industry.getId();
        industry = industryService.get(id);
        if (industry != null) {

            industry.setStatus(-1);
            industry.setUpdateDate(new Date());
            int flag = industryService.update(industry);
            if (flag > 0) {
                resultMap = getResultMap("1", "删除成功!");
            } else {
                resultMap = getResultMap("-1", "删除失败!");
            }

            outJson(resultMap);
        }

    }

    /**
     * 保存
     */
    @RequestMapping(value = "save")
    public void save(@ModelAttribute Industry industry) {
        logger.info("save");
        Map<String, Object> resultMap = new HashMap<String, Object>();

        if (industry != null) {
            //判断添加修改,aom, 0 添加,1 修改
            int aom = industry.getId() > 1 ? 1 : 0;
            int flg = industryService.save(request, industry);
            logger.info("hangye........");
            if (flg == 1) {
                if (aom == 0) {
                    logger.info(".....");
                    resultMap = getResultMap("1", "添加成功!");
                } else
                    resultMap = getResultMap("1", "修改成功!");
            } else {
                if (aom == 0) {
                    resultMap = getResultMap("0", "添加失败!");
                } else
                    resultMap = getResultMap("0", "修改失败!");
            }
        } else
            resultMap = getResultMap("0", "数据初始化失败!");

        outJson(resultMap);
    }


}
