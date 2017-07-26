package com.xgh.recruit.controller;

import com.xgh.mng.basic.BaseController;
import com.xgh.recruit.entity.Recommend;
import com.xgh.recruit.service.IRecommendService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 挑毛病
 */

@Controller
@Scope("prototype")
@RequestMapping(value = "/recruit/findillness/")
public class FindillnessController extends BaseController {
    /**
     * @Fields serialVersionUID :
     */
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(FindillnessController.class);

    @Autowired
    protected IRecommendService recommendService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }

    @InitBinder("recommend")
    public void initBinder2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("recommend.");
    }

    @RequestMapping(value = "add")
    public ModelAndView add(@ModelAttribute Recommend recommend, @RequestParam String op) {

        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/findillness/add");
        if (recommend != null && recommend.getId() > 0) {
            //id>0 认为是修改操作
            recommend = recommendService.get(recommend.getId());
            view.addObject("op", "modify");
        } else {
            view.addObject("op", "add");
        }
        view.addObject("recommend", recommend);
        return view;
    }

    @RequestMapping(value = "init")
    public ModelAndView init() {
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/findillness/init");
        view.addObject("toolbar", sysButtonService.getMenuButtons(request, getCurrentSysRoleId(), getCurrentUser()));
        view.addObject("gridComluns", sysGridColumnsService.getGridColumsByRequest(request));
        return view;
    }

    @RequestMapping(value = "save")
    public void save(@ModelAttribute Recommend recommend) {
        logger.info("save");
        Map<String, Object> resultMap = new HashMap<String, Object>();

        if (recommend != null) {
            //判断添加修改,aom, 0 添加,1 修改
            int aom = recommend.getId() > 1 ? 1 : 0;
            int flg = recommendService.save(request, recommend);

            if (flg == 1) {
                if (aom == 0) {
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

    @RequestMapping(value = "delete")
    public void delete(@ModelAttribute Recommend recommend) {
        logger.info("delete");
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Recommend recommend2 = recommendService.get(recommend.getId());
        recommend2.setUpdateDate(new Date());
        recommend2.setStatus(-1);

        int flg = recommendService.update(recommend2);
        if (flg == 1) {
            resultMap = getResultMap("1", "删除成功!");
        } else
            resultMap = getResultMap("0", "删除失败!");

        outJson(resultMap);
    }

    /**
     * 展示商品列
     */

    @RequestMapping(value = "getList")
    public void getList() {
        logger.info("getList");
        outJson(recommendService.getGridList(request));
    }

}
