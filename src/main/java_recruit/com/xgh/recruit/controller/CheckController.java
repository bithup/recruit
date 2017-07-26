package com.xgh.recruit.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xgh.mng.basic.BaseController;
import com.xgh.recruit.entity.CompanyInfo;
import com.xgh.recruit.entity.Position;
import com.xgh.recruit.service.ICompanyInfoService;
import com.xgh.recruit.service.IDictionaryService;
import com.xgh.recruit.service.IPositionService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BSX on 2017/2/24.
 */
@Controller
@Scope("prototype")
@RequestMapping("recruit/check/")
public class CheckController extends BaseController{

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    protected ICompanyInfoService companyInfoService;

    @Autowired
    protected IPositionService positionService;

    @Autowired
    protected IDictionaryService dictionaryService;


    @RequestMapping(value="companyInit")
    public ModelAndView companyInit(){
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/check/companyInit");
        view.addObject("toolbar", sysButtonService.getMenuButtons(request, getCurrentSysRoleId(), getCurrentUser()));
        view.addObject("gridComluns", this.sysGridColumnsService.getGridColumsByRequest(this.request));
        return view;
    }

    @RequestMapping(value="companyCheck")
    public ModelAndView companyCheck(){
        ModelAndView view = new ModelAndView();
        String id = request.getParameter("id");
        CompanyInfo companyInfo = companyInfoService.get(Long.parseLong(id));
        Map<String,Object> map = new HashMap<String, Object>();
        int companySize = companyInfo.getCompanySize();
        map.put("item","companySize");
        map.put("code",companySize);
        view.addObject("companySize",dictionaryService.getValue(map));
        view.addObject("companyInfo",companyInfo);

        view.setViewName("recruit/check/companyCheck");
        return view;
    }

    @RequestMapping(value="save")
    public void save(){
        Map<String,Object> resultMap = new HashMap<String,Object>();
        String id = request.getParameter("id");
        int isCheck = Integer.parseInt(request.getParameter("isCheck"));
        int type = Integer.parseInt(request.getParameter("type"));
        Date date = new Date();
        int flag = 0;
        if(type == 1){//企业审核
            CompanyInfo companyInfo = companyInfoService.get(Long.parseLong(id));
            companyInfo.setIsCheck(isCheck);
            companyInfo.setUpdateDate(date);
            flag = companyInfoService.update(companyInfo);
        }else if(type == 2){
            Position position = positionService.get(Long.parseLong(id));
            position.setIsCheck(isCheck);
            position.setUpdateDate(date);
            flag = positionService.update(position);

        }
        if(flag>0){
            resultMap = getResultMap("1","操作成功！");
        }else{
            resultMap = getResultMap("0","操作失败，请重试！");
        }
        outJson(resultMap);
    }

    @RequestMapping(value="positionInit")
    public ModelAndView positionInit(){
        ModelAndView view = new ModelAndView();
        view.setViewName("recruit/check/positionInit");
        view.addObject("toolbar",sysButtonService.getMenuButtons(request,getCurrentSysRoleId(),getCurrentUser()));
        view.addObject("gridComluns",sysGridColumnsService.getGridColumsByRequest(this.request));
        return view;
    }


    @RequestMapping(value="positionCheck")
    public ModelAndView positionCheck(){
        ModelAndView view = new ModelAndView();
        String id = request.getParameter("id");
        Position position = positionService.get(Long.parseLong(id));
        String positionLabel = position.getPositionLabel();
        if (positionLabel!=null&&!"".equals(positionLabel)){
            String positionLabelName = "";
            String[] positionLabel1 = positionLabel.split(",");
            for (String positionLabel2:positionLabel1){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("item","joblabel");
                map.put("code",positionLabel2);
                String positionLabelName_ = dictionaryService.getValue(map);
                if ("".equals(positionLabelName)){
                    positionLabelName = positionLabelName_;
                }else {
                    positionLabelName = positionLabelName+","+positionLabelName_;
                }
            }
            view.addObject("positionLabelName",positionLabelName);
        }else {
            view.addObject("positionLabelName","");
        }
        CompanyInfo companyInfo = companyInfoService.get(position.getCompanyId());
        view.addObject("position",position);
        view.addObject("company",companyInfo);
        view.setViewName("recruit/check/positionCheck");
        return view;
    }

}
