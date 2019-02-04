package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.traineemanage.entity.ClassInfo;
import com.bhagava.traineemanage.entity.ClassInfoExample;
import com.bhagava.traineemanage.mapper.ClassInfoMapper;
import com.bhagava.traineemanage.service.ClassInfoService;
import com.bhagava.traineemanage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private ClassInfoMapper classInfoMapper;

    // 获得所有班级信息查询列表
    @GetMapping("/get_list")
    @ResponseBody
    public Object getList(){
        List<ClassInfo> rows = null;
        ClassInfoExample ex = new ClassInfoExample();
        ex.setOrderByClause("id desc");
        long count = classInfoMapper.countByExample(ex);
        try{
            rows = classInfoMapper.selectByExample(ex);
        }catch (Exception e){
            return ResponseEntity.error(e.toString());
        }
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(Util.getReturnMap(rows,count)));
    }

    // 添加班级信息
    @PostMapping("/add_class")
    public Object add(ClassInfo classInfo){
        int count = 0;
        try{
            count = classInfoService.insertSelective(classInfo);
        }catch (Exception e){
            return ResponseEntity.error(e.toString());
        }
        return ResponseEntity.success(count);
    }

    // 删除信息
    @GetMapping("/delete")
    public Object delete(int id){
        int count = 0;
        try{
            count = classInfoService.deleteByPrimaryKey(id);
        }catch (Exception e){
            return ResponseEntity.error(e.toString());
        }
        return ResponseEntity.success(count);
    }

    // 修改信息
    @PostMapping("/update")
    public Object update(ClassInfo classInfo){
        int count = 0;
        try{
            count = classInfoService.updateByPrimaryKey(classInfo);
        }catch (Exception e){
            return ResponseEntity.error(e.toString());
        }
        return ResponseEntity.success(count);
    }
}
