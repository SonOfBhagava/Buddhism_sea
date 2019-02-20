package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.traineemanage.entity.*;
import com.bhagava.traineemanage.service.ClassInfoService;
import com.bhagava.traineemanage.service.ClassScheduleService;
import com.bhagava.traineemanage.service.ProfessorService;
import com.bhagava.traineemanage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bhagava.common.utils.StrUtil;

import java.util.List;
import java.util.Map;

/**
 * created by FeiJunhao on ${date}
 */
@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseManageController {
    @Autowired
    private ClassScheduleService classScheduleService;
    @Autowired
    private ClassInfoService classInfoService;
    @Autowired
    private ProfessorService professorService;

    @PostMapping("/get_list")
    @ResponseBody
    public Object getList(int limit, long offset, String sort, String order, String classId){
        System.out.println("classID：" + classId);
        List<ClassInfo> classList = classInfoService.selectByExample(new ClassInfoExample());
        Map<String,Object> map = null;
        List<ClassSchedule> list = null;
        ClassScheduleExample ex = new ClassScheduleExample();
        ClassScheduleExample.Criteria cri = ex.createCriteria();
        if(StrUtil.isNull(classId)){
            cri.andClassIdEqualTo(classList.get(classList.size()-1).getId());
        }else {
            cri.andClassIdEqualTo(Integer.parseInt(classId));
        }
        long count = classScheduleService.countByExample(ex);
        ex.setLimit(limit);
        ex.setOffset(offset);
        if(!StrUtil.isNull(sort) && !StrUtil.isNull(order)){
            ex.setOrderByClause(sort + " " + order);
        }
        try{
            list = classScheduleService.selectByExample(ex);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        map = Util.getReturnMap(list,count);
        map.put("classList",classList);
        List<Professor> professors = professorService.selectByExample(new ProfessorExample());
        map.put("professors",professors);
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(map));
    }

    @PostMapping("/add")
    @ResponseBody
    public Object add(ClassSchedule classSchedule){
        int count = 0;
        try{
            count = classScheduleService.insertSelective(classSchedule);
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
            count = classScheduleService.deleteByPrimaryKey(id);
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
    public Object update(ClassSchedule classSchedule){
        System.out.println(classSchedule.getId() + "--------------" + classSchedule.getStartDate());
        int count = 0;
        try{
            count = classScheduleService.updateByPrimaryKeySelective(classSchedule);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(count));
    }
    
}
