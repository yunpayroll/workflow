package com.fengcheyun.workflow.service;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.identity.NativeGroupQuery;
import org.activiti.engine.identity.NativeUserQuery;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;

public class IdentityServiceRdImpl implements IdentityService {
	
   /** 
    * Checks if the password is valid for the given user. Arguments userId 
    * and password are nullsafe. 
    */ 
	@Override
	public boolean checkPassword(String userId, String password) {
		// TODO Auto-generated method stub
		if(userId.equals("zhouhf")||userId.equals("xxk"))return true;
		return false;
	}

	@Override
	public GroupQuery createGroupQuery() {
		// TODO Auto-generated method stub
		return this.createGroupQuery();
	}

	@Override
	public void createMembership(String arg0, String arg1) {
		// TODO Auto-generated method stub
		this.createMembership(arg0, arg1);

	}

	@Override
	public NativeGroupQuery createNativeGroupQuery() {
		// TODO Auto-generated method stub
		return this.createNativeGroupQuery();
	}

	@Override
	public NativeUserQuery createNativeUserQuery() {
		// TODO Auto-generated method stub
		return this.createNativeUserQuery();
	}

	@Override
	public UserQuery createUserQuery() {
		// TODO Auto-generated method stub
		return this.createUserQuery();
	}

	@Override
	public void deleteGroup(String arg0) {
		this.deleteGroup(arg0);

	}

	@Override
	public void deleteMembership(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserInfo(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getUserInfo(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUserInfoKeys(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Picture getUserPicture(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group newGroup(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User newUser(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveGroup(Group arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveUser(User arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAuthenticatedUserId(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserInfo(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserPicture(String arg0, Picture arg1) {
		// TODO Auto-generated method stub

	}

}
