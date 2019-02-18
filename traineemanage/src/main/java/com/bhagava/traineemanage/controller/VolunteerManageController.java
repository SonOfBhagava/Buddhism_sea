package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.common.utils.StrUtil;
import com.bhagava.traineemanage.entity.*;
import com.bhagava.traineemanage.mapper.VolunteerMapper;
import com.bhagava.traineemanage.service.ClassInfoService;
import com.bhagava.traineemanage.service.UserService;
import com.bhagava.traineemanage.service.VolunteerService;
import com.bhagava.traineemanage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ClassInfoService classInfoService;
    
    @PostMapping("/get_list")
    @ResponseBody
    public Object getList(int limit, long offset, String sort, String order, String classId, String group, String status,String search){
        List<User> list = null;
        Map<String,Object> map = null;
        // 获取班级信息集合
        ClassInfoExample classEx = new ClassInfoExample();
        ClassInfoExample.Criteria classCri1 = classEx.createCriteria();
        ClassInfoExample.Criteria classCri2 = classEx.createCriteria();
        classCri1.andStatusEqualTo(1);
        classCri2.andStatusEqualTo(2);
        List<ClassInfo> classList = classInfoService.selectByExample(classEx);
        // 查询条件
        UserExample ex = new UserExample();
        UserExample.Criteria cri = ex.createCriteria();
        // 只显示状态为在读的学员
        cri.andStatusEqualTo(1);
        // 判断班级筛选
        if(!StrUtil.isNull(classId)){
            cri.andClassIdEqualTo(Integer.parseInt(classId));
        }else {// 默认选取最后录入的处于开班状态中的班级
            classId = String.valueOf(classList.get(classList.size() - 1).getId());
            cri.andClassIdEqualTo(Integer.parseInt(classId));
        }
        // 小组筛选
        if(!StrUtil.isNull(group)){
            cri.andGroupEqualTo(Integer.parseInt(group));
        }
        // 获取组集合
        List<Integer> groupList = userService.selectGrroup(Integer.parseInt(classId));
        // 获取总数
        long count = userService.countByExample(ex);
        // 分页
        ex.setLimit(limit);
        ex.setOffset(offset);
        // 排序
        if(!StrUtil.isNull(sort) && !StrUtil.isNull(order)){
            ex.setOrderByClause(sort + " " + order);
        }
        try{
            list = userService.selectByExample(ex);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        map = Util.getReturnMap(list,count);
        map.put("classList",classList);
        map.put("groupList",groupList);
        map.put("classId",Integer.parseInt(classId));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(map));
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
