package com.bhagava.traineemanage.util;


import com.bhagava.common.utils.Constants;
import com.bhagava.common.utils.FileIOUtil;
import com.bhagava.traineemanage.entity.Professor;
import com.bhagava.traineemanage.entity.User;
import com.bhagava.traineemanage.mapper.ProfessorMapper;
import com.bhagava.traineemanage.service.ProfessorService;
import com.bhagava.traineemanage.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * created by FeiJunhao on ${date}
 */
public class DataProductTool {

    /**
     * 批量生成用户信息并返回存库影响行数的方法
     * @param count 本次要生存的用户数量
     * @param classId
     * @param role
     * @return
     */
    public static int productUserInfo(int count, int classId, int role, UserService userService){
        String jingang = FileIOUtil.cleanSymbol(FileIOUtil.readFileByAll(Constants.JINGANGJING));
        List<User> users = new ArrayList<>();
        while (count > 0){
            User user = new User();
            int r2 = new Random().nextInt(jingang.length());
            user.setName("妙" + "" + jingang.charAt(r2));
            user.setPhone(getTel());
            user.setAccount("wx" + classId + "" + getNum(0,15));
            user.setGroup(getNum(0,15));
            user.setClassId(classId);
            user.setRole(role);
            users.add(user);
            count--;
        }
        int res = userService.insertList(users);
        return res;
    }

    public static int productProfessor(int count, ProfessorService professorService){
        System.out.println();
        List<Professor> pros = new ArrayList<>();
        for(int i=0;i < count;i++){
            Professor p = new Professor();
            String beifen = FileIOUtil.cleanSymbol(FileIOUtil.readFileByAll(Constants.BEIFEN));
            String str1 = beifen.charAt(getNum(0,beifen.length() - 1)) + "";
            String pumen = FileIOUtil.cleanSymbol(FileIOUtil.readFileByAll(Constants.PUMENPIN));
            String str2 = pumen.charAt(getNum(0,pumen.length() - 1)) + "";
            System.out.println(str1 + str2);
            p.setName(str1 + str2);
            pros.add(p);
        }
        int res = professorService.insertList(pros);
        return res;
    }

    /**
     * 返回手机号码
     */
    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    private static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }

    /**
     * 根据区间返回随机数
     * @param start
     * @param end
     * @return
     */
    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    public static void main(String[] args) {

    }
}
