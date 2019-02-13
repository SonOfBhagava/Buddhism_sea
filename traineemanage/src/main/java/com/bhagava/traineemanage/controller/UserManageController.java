package com.bhagava.traineemanage.controller;

import com.bhagava.common.entity.ResponseEntity;
import com.bhagava.common.utils.EntitySwitchUtil;
import com.bhagava.common.utils.StrUtil;
import com.bhagava.traineemanage.entity.*;
import com.bhagava.traineemanage.service.ClassInfoService;
import com.bhagava.traineemanage.service.RoleService;
import com.bhagava.traineemanage.service.UserService;
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
@RequestMapping("/user")
public class UserManageController {
    @Autowired
    UserService userService;
    @Autowired
    ClassInfoService classInfoService;
    @Autowired
    RoleService roleService;


    @PostMapping("/get_list")
    @ResponseBody
    public Object getList(int limit, long offset, String sort, String order, String classId, String group, String status,String search){
        Map<String,Object> map = null;
        List<User> list = null;
        // 获取班级信息集合
        List<ClassInfo> classList = classInfoService.selectByExample(new ClassInfoExample());
        // 获取权限集合
        List<Role> roleList = roleService.selectByExample(new RoleExample());


        UserExample ex = new UserExample();
        // 查询条件
        if(!StrUtil.isNull(classId)){
            ex.createCriteria().andClassIdEqualTo(Integer.parseInt(classId));
        }else {
            classId = String.valueOf(classList.get(classList.size() - 1).getId());
        }

        if(!StrUtil.isNull(group))
            ex.createCriteria().andGroupEqualTo(Integer.parseInt(group));

        if(!StrUtil.isNull(status))
            ex.createCriteria().andStatusEqualTo(Integer.parseInt(status));

        if(!StrUtil.isNull(search))
            ex.createCriteria().andNameLike(search);
        long count = userService.countByExample(ex);
        // 获取组集合
        List<Integer> groupList = userService.selectGrroup(Integer.parseInt(classId));
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
        map.put("roleList",roleList);
        map.put("groupList",groupList);
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(map));
    }

    @PostMapping("/add")
    @ResponseBody
    public Object add(User user){
        int count = 0;
        try{
            count = userService.insertSelective(user);
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
            count = userService.deleteByPrimaryKey(id);
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
    public Object update(User User){
        int count = 0;
        try{
            count = userService.updateByPrimaryKeySelective(User);
        }catch (Exception e){
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error(e.toString()));
        }
        if(count == 0)
            return EntitySwitchUtil.getMapByEntity(ResponseEntity.error("操作失败！"));
        return EntitySwitchUtil.getMapByEntity(ResponseEntity.success(count));
    }
}
