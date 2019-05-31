package com.demo.listener.test;

import java.util.Vector;
/**
 * 这个类采用了一种单例模式的构造方式，方便全局使用,在JVM中，
 * UserInfoList实例仍然只有一个
 * @author Administrator
 *
 */
public class UserInfoList {

	private static UserInfoList user = new UserInfoList();

	private Vector vector = null;
    
	
	/**
	 * 构造器私有，防止被外界调用生成新的instance实例
	 */
	private UserInfoList() {
		this.vector = new Vector();
	}

	/**
	 * 外界使用的instacnce对象
	 * 
	 * @return
	 */
	public static  UserInfoList getInstance() {

		return user;

	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUserinfo(String user) {
		if (user != null) {
			this.vector.add(user);
			return true;
		}
		return false;

	}

	/**
	 * 移除用户
	 * 
	 * @param user
	 */
	public void removeUserInfo(String user) {
		if (user != null) {
			vector.removeElement(user);
		}
	}

	public Vector getList() {
		return vector;
	}

	public static void main(String[] args) {
		UserInfoList UserInfoList = getInstance();
		System.out.println("finish");
	}
}
