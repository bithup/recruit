package com.xgh.recruit.controller;

import com.xgh.mng.basic.BaseController;
import com.xgh.recruit.dao.ICompanyInfoDao;
import com.xgh.recruit.service.ICompanyInfoService;
import com.xgh.recruit.service.IMemberUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by BSX on 2017/2/24.
 */
@Controller
@Scope("prototype")
@RequestMapping("recruit/company/")
public class CompanyInfoController extends BaseController {

    @Autowired
    protected ICompanyInfoService companyInfoService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @InitBinder({"companyInfo"})
    public void initBinder2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("companyInfo.");
    }

    @RequestMapping(value="init")
    public ModelAndView init(){
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/company/init");
        view.addObject("toolbar", sysButtonService.getMenuButtons(request, getCurrentSysRoleId(), getCurrentUser()));
        view.addObject("gridComluns", this.sysGridColumnsService.getGridColumsByRequest(this.request));
        return view;
    }

    @RequestMapping(value="getListPage")
    public void getListPage(){
        outJson(companyInfoService.getGridPage(request));
    }

}
