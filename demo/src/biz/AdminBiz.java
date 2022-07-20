package biz;

import java.util.List;
import java.util.Map;
import dao.AdminDao;
import entity.Admin;
import entity.Computerroom;
import entity.Equipment;
import entity.Onduty;
import entity.User;

public class AdminBiz {
	AdminDao admindao = new AdminDao(); 
	
	//ĳרҵ������
	public int selectMajorPeople(String major){
		List<Map<String, Object>> list = null;
		list=admindao.selectUserMajorPeople(major);
		list.addAll(admindao.selectSadminMajorPeople(major));
		int user = Integer.parseInt(list.get(0).get("major").toString());
		int sadmin = Integer.parseInt(list.get(1).get("major").toString());
		return user+sadmin;
	}
	//ĳ�꼶������
	public int selectGradePeople(String grade) {
		List<Map<String, Object>> list = null;
		list=admindao.selectUserGradePeople(grade);
		list.addAll(admindao.selectSadminGradePeople(grade));
		int user = Integer.parseInt(list.get(0).get("grade").toString());
		int sadmin = Integer.parseInt(list.get(1).get("grade").toString());
		return user+sadmin;
	}
	//ĳ�Ա������
	public int selectSexPeople(String sex) {
		List<Map<String, Object>> list = null;
		list=admindao.selectUserSexPeople(sex);
		list.addAll(admindao.selectSadminSexPeople(sex));
		int user = Integer.parseInt(list.get(0).get("sex").toString());
		int sadmin = Integer.parseInt(list.get(1).get("sex").toString());
		return user+sadmin;
	}
	
	//����Ա��¼�ж�
	public boolean Alogin(int uname, String upwd){
		return admindao.Alogin(uname, upwd);
	}
	//С�鳤��¼�ж�
	public boolean Ulogin(int uname, String upwd){
		return admindao.Ulogin(uname, upwd);
	}
	//��Ա��¼�ж�
	public boolean Mlogin(int uname, String upwd){
		return admindao.Mlogin(uname, upwd);
	}
	//����ID��ѯ����Ա
	public List<Map<String, Object>> selectAdminID(int aid){
		return admindao.selectAdminID(aid);
	}
	//����ID��ѯС�鳤
		public List<Map<String, Object>> selectUserID(int aid){
			return admindao.selectUserID(aid);
		}
	//����ID��ѯ��Ա
		public List<Map<String, Object>> selectMemberID(int aid){
			return admindao.selectMemberID(aid);
		}
	//��ѯ�û�
	public List<Map<String, Object>> selectUsers(){
		return admindao.selectUsers();
	}
	
	//�ж��Ƿ�������û�
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
	
	//�޸Ĺ���Աĳһ��ֵ
	public boolean modifyAname(Admin user) {
		return admindao.modifyAname(user);
	}
	public boolean modifyApwd(Admin user) {
		return admindao.modifyApwd(user);
	}
	public boolean modifyAage(Admin user) {
		return admindao.modifyAage(user);
	}
	public boolean modifyAsex(Admin user) {
		return admindao.modifyAsex(user);
	}
	public boolean modifyAgrade(Admin user) {
		return admindao.modifyAgrade(user);
	}
	public boolean modifyAmajor(Admin user) {
		return admindao.modifyAmajor(user);
	}
	public boolean modifyAclass(Admin user) {
		return admindao.modifyAclass(user);
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
	
	//�޸�ֵ���ĳһ��ֵ
	public boolean modifyOname(Onduty onduty) {
		return admindao.modifyOname(onduty);
	}
	public boolean modifyOweekday(Onduty onduty) {
		return admindao.modifyOweekday(onduty);
	}
	public boolean modifyObegintime(Onduty onduty) {
		return admindao.modifyObegintime(onduty);
	}
	public boolean modifyOendtime(Onduty onduty) {
		return admindao.modifyOendtime(onduty);
	}
	public boolean modifyOroom(Onduty onduty) {
		return admindao.modifyOroom(onduty);
	}



	//������ѯ�û�
	public List<Map<String, Object>> conditionSelectUsers(String unum, String umajor, String uclassroom) {
		return admindao.conditionSelectUsers(unum, umajor, uclassroom);
	}
	
	//��ҳ������ѯ�û�
	public List<Map<String, Object>> conditionSelectUsersByPage(String unum, String umajor, int startIndex, int perPageSize) {
		return admindao.conditionSelectUsersByPage(unum, umajor, startIndex, perPageSize);
	}
	
	//��ҳ��ѯ�����û�
	public List<Map<String, Object>> selectAllUsersByPage(int startIndex, int perPageSize) {
		return admindao.selectAllUsersByPage(startIndex, perPageSize);
	}
	
	//��ѯ���л�����Ϣ
	public List<Map<String, Object>> selectComputerroom(){
		return admindao.selectComputerroom();
	}
	
	//��ѯ����δ��������Ͽλ���
	public List<Map<String, Object>> selectComputerroomExceptOnduty(){
		return admindao.selectComputerroomExceptOnduty();
	}
	//��ѯ����ֵ����
	public List<Map<String, Object>> selectAllComputerroomOnlyOnduty() {
		return admindao.selectAllComputerroomOnlyOnduty();
	}
	
	//��ѯ�����Ͽλ���
	public List<Map<String, Object>> selectAllComputerroomExceptOnduty() {
		return admindao.selectAllComputerroomExceptOnduty();
	}
	
	//������ѯ������Ϣ
	public List<Map<String, Object>> conditionSelectComputerroom(String crname, String crtype) {
		return admindao.conditionSelectComputerroom(crname, crtype);
	}
	
	//��ҳ������ѯ������Ϣ
	public List<Map<String, Object>> conditionSelectComputerroomByPage(String crname, String crtype, int startIndex, int perPageSize) {
		return admindao.conditionSelectComputerroomByPage(crname, crtype, startIndex, perPageSize);
	}
	
	//��ҳ��ѯ���л�����Ϣ
	public List<Map<String, Object>> selectAllComputerroomByPage(int startIndex, int perPageSize) {
		return admindao.selectAllComputerroomByPage(startIndex, perPageSize);
	}

	//ɾ������
	public boolean deleteComputerroom(String crname) {
		return admindao.deleteComputerroom(crname);
	}

	//�ж��Ƿ����������
		public List<Map<String, Object>> IsComputerroom(String crname) {
			return admindao.IsComputerroom(crname);
		}
	
	//���ӻ���
	public boolean addComputerroom(Computerroom computerroom) {
		return admindao.addComputerroom(computerroom);
	}
	
	//������ѯֵ����Ϣ
	public List<Map<String, Object>> conditionSelectOnduty(String oname, String oweekday) {
		return admindao.conditionSelectOnduty(oname, oweekday);
	}
	
	//��ѯֵ����Ϣ
	public List<Map<String, Object>> selectOnduty() {
		return admindao.selectOnduty();
	}
	
	//��ҳ������ѯֵ����Ϣ
	public List<Map<String, Object>> conditionSelectOndutyByPage(String oname, String oweekday, int startIndex,
			int perPageSize) {
		return admindao.conditionSelectOndutyByPage(oname, oweekday, startIndex, perPageSize);
	}
	
	//��ҳ��ѯ����ֵ����Ϣ
	public List<Map<String, Object>> selectAllOndutyByPage(int startIndex, int perPageSize) {
		return admindao.selectAllOndutyByPage(startIndex, perPageSize);
	}
	
	//ɾ��ֵ����Ϣ
	public boolean deleteOnduty(String oid) {
		return admindao.deleteOnduty(oid);
	}
	
	//�ж��Ƿ������ֵ����Ա
	public List<Map<String, Object>> IsOnduty(String oid) {
		return admindao.IsOnduty(oid);
	}
	
	//����ֵ����Ϣ
	public boolean addOnduty(Onduty onduty) {
		return admindao.addOnduty(onduty);
	}
	
	//��ѯ���л�����Ϣ
	public List<Map<String, Object>> selectAllComputerroom() {
		return admindao.selectAllComputerroom();
	}
	
	//������ѯ�豸
	public List<Map<String, Object>> conditionSelectEquipments(String ename, String ecomputerroom) {
		return admindao.conditionSelectEquipments(ename, ecomputerroom);
	}
	
	//��ѯ�豸��Ϣ
	public List<Map<String, Object>> selectEquipments() {
		return admindao.selectEquipments();
	}
	
	//��ҳ������ѯ�豸
	public List<Map<String, Object>> conditionSelectEquipmentsByPage(String ename, String ecomputerroom, int startIndex,
			int perPageSize) {
		return admindao.conditionSelectEquipmentsByPage(ename, ecomputerroom, startIndex, perPageSize);
	}
	
	//��ҳ��ѯ�����豸��Ϣ
	public List<Map<String, Object>> selectAllEquipmentsByPage(int startIndex, int perPageSize) {
		return admindao.selectAllEquipmentsByPage(startIndex, perPageSize);
	}
	
	//ɾ���豸
	public boolean deleteEquipment(String eid) {
		return admindao.deleteEquipment(eid);
	}
	
	//����豸
	public boolean addEquipment(Equipment equipment) {
		return admindao.addEquipment(equipment);
	}
	
	//�޸��豸
	public boolean modifyEname(Equipment equipment, String ename) {
		return admindao.modifyEname(equipment,ename);
	}
	public boolean modifyEmoney(Equipment equipment) {
		return admindao.modifyEmoney(equipment);
	}
	public boolean modifyEcomputerroom(Equipment equipment, String ecomputerroom) {
		return admindao.modifyEcomputerroom(equipment, ecomputerroom);
	}
	public boolean modifyEnumber(Equipment equipment) {
		return admindao.modifyEnumber(equipment);
	}
	
	//��ѯ���е��ʽ�
	public List<Map<String, Object>> selectAllMoneylog() {
		return admindao.selectAllMoneylog();
	}
	
	//��ѯ������������ʽ�
	public List<Map<String, Object>> selectMoneylogByMtype(String mtype) {
		return admindao.selectMoneylogByMtype(mtype);
	}
	
	//��¼�豸�ʽ�
	public boolean addMoneylog(Equipment equipment) {
		return admindao.addMoneylog(equipment);
	}
	
	//ͨ��������ѯ�û�
	public List<Map<String, Object>> selectUsersByUclassroom(String uclassroom) {
		return admindao.selectUsersByUclassroom(uclassroom);
	}


}
