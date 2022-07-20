package biz;

import java.util.List;
import java.util.Map;
import dao.SadminDao;
import entity.User;

public class SadminBiz {
	SadminDao admindao = new SadminDao(); 
	
	//��ѯ�û�
	public List<Map<String, Object>> selectUsers(){
		return admindao.selectUsers();
	}
	
	//�ж��Ƿ�������û����ѹ������
	public List<Map<String, Object>> IsUser(String uid){
		return admindao.IsUser(uid);
	}
	
	//ɾ���û�
	public boolean deleteUser(String uid) {
		return admindao.deleteUser(uid);
	}
	
	//����û�
	public boolean addUser(User user) {
		return admindao.addUser(user);
	}

	//�޸��û�ĳһ��ֵ
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



	//������ѯ�û�
	public List<Map<String, Object>> conditionSelectUsers(String unum, String umajor) {
		return admindao.conditionSelectUsers(unum, umajor);
	}
	
	//��ҳ������ѯ�û�
	public List<Map<String, Object>> conditionSelectUsersByPage(String unum, String school, int startIndex, int perPageSize) {
		return admindao.conditionSelectUsersByPage(unum, school, startIndex, perPageSize);
	}
	
	//��ҳ��ѯ�����û�
	public List<Map<String, Object>> selectAllUsersByPage(int startIndex, int perPageSize) {
		return admindao.selectAllUsersByPage(startIndex, perPageSize);
	}


			
}

