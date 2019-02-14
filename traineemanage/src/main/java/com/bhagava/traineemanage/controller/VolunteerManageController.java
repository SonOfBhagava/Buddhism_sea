package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.traineemanage.entity.Volunteer;
import com.bhagava.traineemanage.mapper.VolunteerMapper;
import com.bhagava.traineemanage.service.UserService;
import com.bhagava.traineemanage.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by FeiJunhao on ${date}
 */
@Controller
@RequestMapping("/volunteer")
public class VolunteerManageController {
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private UserService userService;
    
    @PostMapping("/get_list")
    @ResponseBody
    public Object getList(int limit, long offset, String sort, String order, String classId, String group, String status,String search){

        return null;
    }

    @PostMapping("/add")
    @ResponseBody
    public Object add(Volunteer volunteer){
        int count = 0;
        try{
            count = volunteerService.insertSelective(volunteer);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(count));
    }

    // 删除信息
    @GetMapping("/delete")
    @ResponseBody
    public Object delete(int id){
        int count = 0;
        try{
            count = volunteerService.deleteByPrimaryKey(id);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(count));
    }

    // 修改信息
    @PostMapping("/update")
    @ResponseBody
    public Object update(Volunteer volunteer){
        int count = 0;
        try{
            count = volunteerService.updateByPrimaryKeySelective(volunteer);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(count));
    }
}
