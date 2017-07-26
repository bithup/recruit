package com.xgh.recruit.controller;

import com.xgh.mng.basic.BaseController;
import com.xgh.recruit.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BSX on 2017/2/25.
 */
@Controller
@Scope("prototype")
@RequestMapping("recruit/position/")
public class PositionController extends BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @InitBinder({"position"})
    public void initBinder2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("position.");
    }

    @Autowired
    protected IPositionService positionService;

    @RequestMapping(value="init")
    public ModelAndView init(){
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/position/init");
        view.addObject("toolbar", sysButtonService.getMenuButtons(request, getCurrentSysRoleId(), getCurrentUser()));
        view.addObject("gridComluns", this.sysGridColumnsService.getGridColumsByRequest(this.request));
        return view;
    }

    @RequestMapping(value="getListPage")
    public void getListPage(){
        outJson(positionService.getGridMap(request));
    }
}
