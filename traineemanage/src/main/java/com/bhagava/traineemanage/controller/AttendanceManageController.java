package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.common.utils.StrUtil;
import com.bhagava.traineemanage.entity.*;
import com.bhagava.traineemanage.service.AttendanceRecordService;
import com.bhagava.traineemanage.service.ClassInfoService;
import com.bhagava.traineemanage.service.ClassScheduleService;
import com.bhagava.traineemanage.service.UserService;
import com.bhagava.traineemanage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by FeiJunhao on ${date}
 */
@RequestMapping("/attendance")
@Controller
@CrossOrigin
public class AttendanceManageController {
    @Autowired
    private UserService userService;
    @Autowired
    private ClassScheduleService classScheduleService;
    @Autowired
    private AttendanceRecordService attendanceRecordService;
    @Autowired
    private ClassInfoService classInfoService;

    @PostMapping("/get_list")
    @ResponseBody
    public Object getList(int limit, long offset, String sort, String order, String classId, String group, String search){
        List<User> list = null;
        Map<String,Object> map = null;
        // 获得可以进行管理的考勤课程列表
        ClassScheduleExample courseEx = new ClassScheduleExample();
        courseEx.createCriteria().andStartDateLessThanOrEqualTo(new Date());
        // 获取班级信息集合
        ClassInfoExample classEx = new ClassInfoExample();
        ClassInfoExample.Criteria classCri1 = classEx.createCriteria();
        ClassInfoExample.Criteria classCri2 = classEx.createCriteria();
        classCri1.andStatusEqualTo(1);
        classCri2.andStatusEqualTo(2);
        classEx.or(classCri2);
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
        // 课程筛选
        courseEx.createCriteria().andClassIdEqualTo(Integer.parseInt(classId));
        List<ClassSchedule> courseList = classScheduleService.selectByExample(courseEx);
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
        map.put("courseList",courseList);
        map.put("groupList",groupList);
        map.put("courseId",courseList.get(courseList.size() - 1).getId());
        map.put("classId",Integer.parseInt(classId));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(map));
    }

    @PostMapping("/add")
    @ResponseBody
    public Object add(AttendanceRecord attendanceRecord){
        int count = 0;
        try{
            count = attendanceRecordService.insertSelective(attendanceRecord);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return ResponseEntity.success(count);
    }

    // 删除信息
    @GetMapping("/delete")
    @ResponseBody
    public Object delete(int id){
        int count = 0;
        try{
            count = attendanceRecordService.deleteByPrimaryKey(id);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return ResponseEntity.success(count);
    }

    // 修改信息
    @PostMapping("/update")
    @ResponseBody
    public Object update(AttendanceRecord attendanceRecord){
        int count = 0;
        try{
            count = attendanceRecordService.updateByPrimaryKeySelective(attendanceRecord);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return ResponseEntity.success(count);
    }

    // 修改信息
    @PostMapping("/getCourses")
    @ResponseBody
    public Object getCourses(int limit, long offset, String classId, String group){
        String semester = "";
        // 用户
        UserExample userEx = new UserExample();
        UserExample.Criteria userCri = userEx.createCriteria();
        userCri.andStatusEqualTo(1);
        // 班级
        ClassInfoExample classEx = new ClassInfoExample();
        ClassInfoExample.Criteria classCri1 = classEx.createCriteria();
        ClassInfoExample.Criteria classCri2 = classEx.createCriteria();
        classCri1.andStatusEqualTo(1);
        classCri2.andStatusEqualTo(2);
        classEx.or(classCri2);
        List<ClassInfo> classList = classInfoService.selectByExample(classEx);
        // 课程
        ClassScheduleExample courseEx = new ClassScheduleExample();
        ClassScheduleExample.Criteria courseCri = courseEx.createCriteria();
        if(StrUtil.isNull(classId)){
            classId = String.valueOf(classList.get(classList.size() - 1).getId());
        }
        if(!StrUtil.isNull(group)){
            userCri.andGroupEqualTo(Integer.parseInt(group));
        }
        userCri.andClassIdEqualTo(Integer.parseInt(classId));
        courseCri.andClassIdEqualTo(Integer.parseInt(classId));
        semester = classInfoService.selectByPrimaryKey(Integer.parseInt(classId)).getStatus() == 1 ? "up" : "down";
        courseCri.andSemesterEqualTo(semester);
        // 获取总数
        long count = userService.countByExample(userEx);
        // 分页
        userEx.setLimit(limit);
        userEx.setOffset(offset);
        List<User> userList = userService.selectByExample(userEx);
        // 获取组集合
        List<Integer> groupList = userService.selectGrroup(Integer.parseInt(classId));
        List<ClassSchedule> courseList = classScheduleService.selectByExample(courseEx);
        Map<String,Object> map = null;
        map = Util.getReturnMap(userList,count);
        map.put("classList",classList);
        map.put("courseList",courseList);
        map.put("semester",semester);
        map.put("classId",classId);
        map.put("groupList",groupList);
        return ResponseEntity.success(map);
    }
}
