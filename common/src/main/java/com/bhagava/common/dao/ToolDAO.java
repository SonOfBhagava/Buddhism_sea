package com.bhagava.common.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description: 封装了数据库连接及增、改、查的基础代码，用于开发人员在不启动项目时做单独的数据库操作的工具类，需要开发人员自己配置数据库连接
 */
public class ToolDAO {
	//要连接的数据库的url
	public static final String URL = "jdbc:mysql://192.168.2.130:3306/usurpor";
	//要连接的数据库的用户名
	private static final String UNAME = "root";
	//要连接的数据库的密码
	private static final String UPASS = "act10000";
	static{
		//加载数据库连接驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 连接到数据库，返回活动连接对象
	 * @return
	 */
	public Connection initConnection(){
		try {
			Connection conn = DriverManager.getConnection(URL, UNAME, UPASS);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;//如果连接出现异常，则返回空
		}
	}


	/**
	 * 执行更新语句
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object...params){
		Connection conn = initConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			for(int i = 0; i < params.length; i++){
				pstmt.setObject(i + 1, params[i]);
			}
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			closeAll(rs, null, pstmt, conn);
		}
	}

	/**
	 * 执行sql语句，返回查询到的对象数组
	 * @param sql
	 * @param t 实体类的类型
	 * @param params
	 * @return
	 */
	public <T> List<T> executeSql(String sql, Class<T> t, Object...params){
		List<T> list = new ArrayList<T>();
		Connection conn = initConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				//调用这个对象的set方法
				Object obj = mapping(rs, t);
				list.add((T)obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, null, pstmt, conn);
		}
		return list;
	}


	//以下部分为工具代码*****************************************************************************


	/**
	 * 将传入的结果集数据和实体类进行映射（调用set方法赋值）
	 * @param rs
	 * @param entityClass
	 * @return
	 */
	private Object mapping(ResultSet rs, Class entityClass) {
		//1.实例化实体类对象
		Object obj = null;
		try {
			obj = entityClass.newInstance();
			//获得实体类中定义的所有方法
			Method[] methodArray = entityClass.getDeclaredMethods();
			for (int i = 0; i < methodArray.length; i++) {
				//循环调用set方法
				//methodArray[i].getName().startsWith("set")
				if("set".equals(methodArray[i].getName().substring(0, 3))){
					String methodName = methodArray[i].getName().substring(3);
					if(haveUpperCase(methodName.substring(1)))
						methodName = HumpToUnderline(methodName);
					methodArray[i].invoke(obj, rs.getObject(methodName));

				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}



	/**
	 * 关闭所有的资源
	 */
	public void closeAll(ResultSet rs, Statement stmt, PreparedStatement pstmt, Connection conn){
		try {
			if(null != rs){
				rs.close();
				rs = null;
			}
			if(null != stmt){
				stmt.close();
				stmt = null;
			}
			if(null != pstmt){
				pstmt.close();
				pstmt = null;
			}
			if(null != conn){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/***
	 * 驼峰命名转为下划线命名
	 *
	 * @param para
	 *        驼峰命名的字符串
	 */

	public static String HumpToUnderline(String para){
		StringBuilder sb=new StringBuilder(para);
		int temp=0;//定位
		if (!para.contains("_")) {
			for(int i=0;i<para.length();i++){
				if(Character.isUpperCase(para.charAt(i)) && i != 0){
					sb.insert(i+temp, "_");
					temp+=1;
				}
			}
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 是否是大写
	 */
	public boolean isUpperCase(char c) {
		return c >=65 && c <= 90;
	}

	/**
	 * 判断字符串中是否有大写字符
	 */
	public boolean haveUpperCase(String str){
		for(int i = 0;i < str.length();i++){
			if(isUpperCase(str.charAt(i))){
				return true;
			}
		}
		return false;
	}
}
 










