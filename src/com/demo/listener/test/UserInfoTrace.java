package com.demo.listener.test;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserInfoTrace implements HttpSessionBindingListener{
	
	private  String user;
	private UserInfoList container=UserInfoList.getInstance();
	
	public UserInfoTrace() {
		user="";
	}
	
    public void  setUser(String user) {
    	this.user = user;
    }
    
    public String getUser() {
    	return this.user;
    }
    
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
