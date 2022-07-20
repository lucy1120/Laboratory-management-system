package biz;

import java.util.List;
import java.util.Map;
import dao.SadminDao;
import entity.User;

public class SadminBiz {
	SadminDao admindao = new SadminDao(); 
	
	//查询用户
	public List<Map<String, Object>> selectUsers(){
		return admindao.selectUsers();
	}
	
	//判断是否有这个用户或已管理机房
	public List<Map<String, Object>> IsUser(String uid){
		return admindao.IsUser(uid);
	}
	
	//删除用户
	public boolean deleteUser(String uid) {
		return admindao.deleteUser(uid);
	}
	
	//添加用户
	public boolean addUser(User user) {
		return admindao.addUser(user);
	}

	//修改用户某一个值
	public boolean modifyUname(User user) {
		return admindao.modifyUname(user);
	}
	public boolean modifyUpwd(User user) {
		return admindao.modifyUpwd(user);
	}
	public boolean modifyUage(User user) {
		return admindao.modifyUage(user);
	}
	public boolean modifyUsex(User user) {
		return admindao.modifyUsex(user);
	}
	public boolean modifyUgrade(User user) {
		return admindao.modifyUgrade(user);
	}
	public boolean modifyUmajor(User user) {
		return admindao.modifyUmajor(user);
	}
	public boolean modifyUclass(User user) {
		return admindao.modifyUclass(user);
	}
	public boolean modifyUclassroom(User user) {
		return admindao.modifyUclassroom(user);
	}



	//条件查询用户
	public List<Map<String, Object>> conditionSelectUsers(String unum, String umajor) {
		return admindao.conditionSelectUsers(unum, umajor);
	}
	
	//分页条件查询用户
	public List<Map<String, Object>> conditionSelectUsersByPage(String unum, String school, int startIndex, int perPageSize) {
		return admindao.conditionSelectUsersByPage(unum, school, startIndex, perPageSize);
	}
	
	//分页查询所有用户
	public List<Map<String, Object>> selectAllUsersByPage(int startIndex, int perPageSize) {
		return admindao.selectAllUsersByPage(startIndex, perPageSize);
	}


			
}

