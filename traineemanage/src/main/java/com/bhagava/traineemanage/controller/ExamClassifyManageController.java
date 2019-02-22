package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.traineemanage.entity.ExamClassify;
import com.bhagava.traineemanage.entity.ExamClassifyExample;
import com.bhagava.traineemanage.service.ExamClassifyService;
import com.bhagava.traineemanage.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/2/21 14:49
 * @Description:
 */
@Controller
@CrossOrigin
@RequestMapping("/examClassify")
public class ExamClassifyManageController {

    @Autowired
    private ExamClassifyService examClassifyService;

    // 获得所有班级信息查询列表
    @PostMapping("/get_list")
    @ResponseBody
    public Object getList(int limit,long offset){
        List<ExamClassify> rows = null;
        ExamClassifyExample ex = new ExamClassifyExample();
        if(limit != 0 && offset != 0L){
            ex.setLimit(limit);
            ex.setOffset(offset);
        }
        long count = examClassifyService.countByExample(ex);
        try{
            rows = examClassifyService.selectByExampleWithBLOBs(ex);
        }catch (Exception e){
            return ResponseEntity.error(e.toString());
        }
        if(count == 0)
            return ResponseEntity.error("操作失败！");
        return ResponseEntity.success(Util.getReturnMap(rows,count));
    }

    // 添加班级信息
    @PostMapping("/add")
    @ResponseBody
    public Object add(ExamClassify examClassify){
        int count = 0;
        try{
            count = examClassifyService.insert(examClassify);
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
            count = examClassifyService.deleteByPrimaryKey(id);
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
    public Object update(ExamClassify examClassify){
        int count = 0;
        try{
            count = examClassifyService.updateByPrimaryKey(examClassify);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return ResponseEntity.success(count);
    }
}
