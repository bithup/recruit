package com.xgh.recruit.controller;

import com.xgh.mng.basic.BaseController;
import com.xgh.recruit.entity.Dictionary;
import com.xgh.recruit.service.IDictionaryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CQ on 2017/2/28.
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/recruit/dictionary/")
public class DictionaryController extends BaseController {

    private Logger logger = Logger.getLogger(DictionaryController.class);

    @Autowired
    protected IDictionaryService dictionaryService;


    @RequestMapping(value = "init")
    public ModelAndView init() {
        logger.info("...............");
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/dictionary/init");
        view.addObject("toolbar", sysButtonService.getMenuButtons(request, getCurrentSysRoleId(), getCurrentUser()));
        view.addObject("gridComluns", sysGridColumnsService.getGridColumsByRequest(request));
        return view;
    }

    @RequestMapping(value = "add")
    public ModelAndView add(@ModelAttribute Dictionary dictionary, @RequestParam String op) {

        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/dictionary/add");
        if ("modify".equals(op)) {

            long id = dictionary.getId();
            dictionary = dictionaryService.get(id);
        }
        view.addObject("op", op);
        view.addObject("dictionary", dictionary);
        return view;
    }


    @RequestMapping(value = "getList")
    public void getList() {
        outJson(dictionaryService.getGridList(request));
    }

    /**
     * @param dictionary
     */
    @RequestMapping(value = "save")
    public void save(@ModelAttribute Dictionary dictionary) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (dictionary != null) {
            int atom = dictionary.getId() > 0 ? 1 : 0;
            int flag = dictionaryService.save(request, dictionary);

            if (flag > 0) {
                if (atom == 1) {
                    resultMap = getResultMap("1", "修改成功!");
                } else {
                    resultMap = getResultMap("1", "添加成功!");
                }
            } else {
                if (atom == 0) {
                    resultMap = getResultMap("0", "添加失败!");
                } else {
                    resultMap = getResultMap("0", "修改失败!");
                }
            }
        } else {
            resultMap = getResultMap("0", "数据初始化失败!");
        }
        outJson(resultMap);
    }

    @RequestMapping(value = "delete")
    public void delete(@ModelAttribute Dictionary dictionary) {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        long id = dictionary.getId();
        dictionary = dictionaryService.get(id);
        if (dictionary != null) {
            dictionary.setUpdateDate(new Date());
            dictionary.setStatus(-1);
            int flag = dictionaryService.update(dictionary);
            if (flag > 0) {
                resultMap = getResultMap("1", "删除成功!");
            } else {
                resultMap = getResultMap("-1", "删除失败!");
            }
        }
        outJson(resultMap);
    }


}
