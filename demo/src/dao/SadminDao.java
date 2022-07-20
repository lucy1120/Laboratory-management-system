package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import entity.User;
public class SadminDao extends BaseDao{
	
	//��ѯ�û�
	public List<Map<String, Object>> selectUsers(){
		String sql = "SELECT * from sadmininfo";
		return select(sql, null);
	}
	
	//�ж��Ƿ�������û���
	public List<Map<String, Object>> IsUser(String uid){
		String sql = "select * from sadmininfo where said = ?";
		Object param[] = {uid};
		return select(sql, param);
	}

	public List<Map<String, Object>> IsUserId(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> IsUserClassroom(String uclassroom) {
		// TODO Auto-generated method stub
		return null;
	}
	//ɾ���û�
	public boolean  deleteUser(String uid) {
		String sql = "delete from sadmininfo where said=?";
		Object param[] = {uid};
		return upadateByParams(sql, param);
	}

	//����û�
	public boolean addUser(User user) {
		String sql = "INSERT INTO sadmininfo (said,saname,sapwd,saage,sasex,sagrade,samajor,saclass,saclassroom) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object param[] = {
				user.getUid(),
				user.getUname(), 
				user.getUpwd(), 
				user.getUage(),
				user.getUsex(),
				user.getUgrade(), 
				user.getUmajor(), 
				user.getUclass(),
				user.getUclassroom()
		};
		return upadateByParams(sql, param);
	}
	
	//�޸��û�ĳһ��ֵ
	public boolean modifyUname(User user) {
		String sql = "update sadmininfo set saname = ? where said = ?";
		Object param[] = {user.getUname(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUpwd(User user) {
		String sql = "update sadmininfo set sapwd = ? where said = ?";
		Object param[] = {user.getUpwd(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUage(User user) {
		String sql = "update sadmininfo set saage = ? where said = ?";
		Object param[] = {user.getUage(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUsex(User user) {
		String sql = "update sadmininfo set sasex = ? where said = ?";
		Object param[] = {user.getUsex(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUgrade(User user) {
		String sql = "update sadmininfo set sagrade = ? where said = ?";
		Object param[] = {user.getUgrade(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUmajor(User user) {
		String sql = "update sadmininfo set samajor = ? where said = ?";
		Object param[] = {user.getUmajor(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUclass(User user) {
		String sql = "update sadmininfo set saclass = ? where said = ?";
		Object param[] = {user.getUclass(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUclassroom(User user) {
		String sql = "update sadmininfo set saclassroom = ? where said = ?";
		Object param[] = {user.getUclassroom(), user.getUid()};
		return upadateByParams(sql, param);
	}


	//������ѯ�û�
	public List<Map<String, Object>> conditionSelectUsers(String uname, String umajor) {
		StringBuffer sql = new StringBuffer("select * from sadmininfo where 1 = 1");
		ArrayList<String> param = new ArrayList<String>();
		//�����û��������
		if(null != uname && uname.trim().length() > 0){
			sql.append(" and saname = ?");
			param.add(uname);
		}
		//ѡ��רҵ�����
		if(!"all".equals(umajor)){
			sql.append(" and samajor = ? ");
			param.add(umajor);
		}
		return select(sql.toString(), param.toArray());
	}

	//��ҳ������ѯ�û�
	public List<Map<String, Object>> conditionSelectUsersByPage(String uname, String umajor, int startIndex, int perPageSize) {
		StringBuffer sql = new StringBuffer("select * from sadmininfo where 1 = 1");
		ArrayList<Object> param = new ArrayList<Object>();
		//�����û��������
		if(null != uname && uname.trim().length() > 0){
			sql.append(" and saname = ?");
			param.add(uname);
		}
		//ѡ��ѧУ�����
		if(!"all".equals(umajor)){
			sql.append(" and samajor = ? ");
			param.add(umajor);
		}
		param.add(startIndex);
		param.add(perPageSize);
		sql.append(" limit ?, ? "); 
		return select(sql.toString(), param.toArray());
	}

	//��ҳ��ѯ�����û�
	public List<Map<String, Object>> selectAllUsersByPage(int startIndex, int perPageSize) {
		String sql = "select * from sadmininfo limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}


}
