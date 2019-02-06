package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.traineemanage.entity.ClassInfo;
import com.bhagava.traineemanage.entity.ClassInfoExample;
import com.bhagava.traineemanage.entity.ClassSchedule;
import com.bhagava.traineemanage.entity.ClassScheduleExample;
import com.bhagava.traineemanage.service.ClassInfoService;
import com.bhagava.traineemanage.service.ClassScheduleService;
import com.bhagava.traineemanage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get_list")
    @ResponseBody
    public Object getList(int limit, long offset, String sort, String order){
        Map<String,Object> map = null;
        List<ClassSchedule> list = null;
        ClassScheduleExample ex = new ClassScheduleExample();
        long count = classScheduleService.countByExample(ex);
        ex.setLimit(limit);
        ex.setOffset(offset);
        try{
            list = classScheduleService.selectByExample(ex);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(list.size() == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("返回行数0"));
        map = Util.getReturnMap(list,count);
        List<ClassInfo> classList = classInfoService.selectByExample(new ClassInfoExample());
        map.put("classList",classList);
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(map));
    }
}
