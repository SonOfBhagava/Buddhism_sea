package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.traineemanage.entity.ClassInfo;
import com.bhagava.traineemanage.entity.ClassInfoExample;
import com.bhagava.traineemanage.service.ClassInfoService;
import com.bhagava.traineemanage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
@RestController
@CrossOrigin
@RequestMapping("/class")
public class ClassManageController {

    @Autowired
    private ClassInfoService classInfoService;

    // 获得所有班级信息查询列表
    @GetMapping("/get_list")
    @ResponseBody
    public Object getList(int limit,long offset){
        List<ClassInfo> rows = null;
        ClassInfoExample ex = new ClassInfoExample();
        if(limit != 0 && offset != 0L){
            ex.setLimit(limit);
            ex.setOffset(offset);
        }
        ex.setOrderByClause("id desc");
        long count = classInfoService.countByExample(ex);
        try{
            rows = classInfoService.selectByExample(ex);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(Util.getReturnMap(rows,count)));
    }

    // 添加班级信息
    @PostMapping("/add_class")
    @ResponseBody
    public Object add(ClassInfo classInfo){
        int count = 0;
        try{
            count = classInfoService.insert(classInfo);
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
        System.out.println("参数"+id);
        int count = 0;
        try{
            count = classInfoService.deleteByPrimaryKey(id);
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
    public Object update(ClassInfo classInfo){
        int count = 0;
        try{
            count = classInfoService.updateByPrimaryKey(classInfo);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(count));
    }

}
