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
	
	//某专业的人数
	public int selectMajorPeople(String major){
		List<Map<String, Object>> list = null;
		list=admindao.selectUserMajorPeople(major);
		list.addAll(admindao.selectSadminMajorPeople(major));
		int user = Integer.parseInt(list.get(0).get("major").toString());
		int sadmin = Integer.parseInt(list.get(1).get("major").toString());
		return user+sadmin;
	}
	//某年级的人数
	public int selectGradePeople(String grade) {
		List<Map<String, Object>> list = null;
		list=admindao.selectUserGradePeople(grade);
		list.addAll(admindao.selectSadminGradePeople(grade));
		int user = Integer.parseInt(list.get(0).get("grade").toString());
		int sadmin = Integer.parseInt(list.get(1).get("grade").toString());
		return user+sadmin;
	}
	//某性别的人数
	public int selectSexPeople(String sex) {
		List<Map<String, Object>> list = null;
		list=admindao.selectUserSexPeople(sex);
		list.addAll(admindao.selectSadminSexPeople(sex));
		int user = Integer.parseInt(list.get(0).get("sex").toString());
		int sadmin = Integer.parseInt(list.get(1).get("sex").toString());
		return user+sadmin;
	}
	
	//管理员登录判断
	public boolean Alogin(int uname, String upwd){
		return admindao.Alogin(uname, upwd);
	}
	//小组长登录判断
	public boolean Ulogin(int uname, String upwd){
		return admindao.Ulogin(uname, upwd);
	}
	//组员登录判断
	public boolean Mlogin(int uname, String upwd){
		return admindao.Mlogin(uname, upwd);
	}
	//根据ID查询管理员
	public List<Map<String, Object>> selectAdminID(int aid){
		return admindao.selectAdminID(aid);
	}
	//根据ID查询小组长
		public List<Map<String, Object>> selectUserID(int aid){
			return admindao.selectUserID(aid);
		}
	//根据ID查询组员
		public List<Map<String, Object>> selectMemberID(int aid){
			return admindao.selectMemberID(aid);
		}
	//查询用户
	public List<Map<String, Object>> selectUsers(){
		return admindao.selectUsers();
	}
	
	//判断是否有这个用户
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
	
	//修改管理员某一个值
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
	
	//修改值班的某一个值
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



	//条件查询用户
	public List<Map<String, Object>> conditionSelectUsers(String unum, String umajor, String uclassroom) {
		return admindao.conditionSelectUsers(unum, umajor, uclassroom);
	}
	
	//分页条件查询用户
	public List<Map<String, Object>> conditionSelectUsersByPage(String unum, String umajor, int startIndex, int perPageSize) {
		return admindao.conditionSelectUsersByPage(unum, umajor, startIndex, perPageSize);
	}
	
	//分页查询所有用户
	public List<Map<String, Object>> selectAllUsersByPage(int startIndex, int perPageSize) {
		return admindao.selectAllUsersByPage(startIndex, perPageSize);
	}
	
	//查询所有机房信息
	public List<Map<String, Object>> selectComputerroom(){
		return admindao.selectComputerroom();
	}
	
	//查询所有未被管理的上课机房
	public List<Map<String, Object>> selectComputerroomExceptOnduty(){
		return admindao.selectComputerroomExceptOnduty();
	}
	//查询所有值班室
	public List<Map<String, Object>> selectAllComputerroomOnlyOnduty() {
		return admindao.selectAllComputerroomOnlyOnduty();
	}
	
	//查询所有上课机房
	public List<Map<String, Object>> selectAllComputerroomExceptOnduty() {
		return admindao.selectAllComputerroomExceptOnduty();
	}
	
	//条件查询机房信息
	public List<Map<String, Object>> conditionSelectComputerroom(String crname, String crtype) {
		return admindao.conditionSelectComputerroom(crname, crtype);
	}
	
	//分页条件查询机房信息
	public List<Map<String, Object>> conditionSelectComputerroomByPage(String crname, String crtype, int startIndex, int perPageSize) {
		return admindao.conditionSelectComputerroomByPage(crname, crtype, startIndex, perPageSize);
	}
	
	//分页查询所有机房信息
	public List<Map<String, Object>> selectAllComputerroomByPage(int startIndex, int perPageSize) {
		return admindao.selectAllComputerroomByPage(startIndex, perPageSize);
	}

	//删除机房
	public boolean deleteComputerroom(String crname) {
		return admindao.deleteComputerroom(crname);
	}

	//判断是否有这个机房
		public List<Map<String, Object>> IsComputerroom(String crname) {
			return admindao.IsComputerroom(crname);
		}
	
	//增加机房
	public boolean addComputerroom(Computerroom computerroom) {
		return admindao.addComputerroom(computerroom);
	}
	
	//条件查询值班信息
	public List<Map<String, Object>> conditionSelectOnduty(String oname, String oweekday) {
		return admindao.conditionSelectOnduty(oname, oweekday);
	}
	
	//查询值班信息
	public List<Map<String, Object>> selectOnduty() {
		return admindao.selectOnduty();
	}
	
	//分页条件查询值班信息
	public List<Map<String, Object>> conditionSelectOndutyByPage(String oname, String oweekday, int startIndex,
			int perPageSize) {
		return admindao.conditionSelectOndutyByPage(oname, oweekday, startIndex, perPageSize);
	}
	
	//分页查询所有值班信息
	public List<Map<String, Object>> selectAllOndutyByPage(int startIndex, int perPageSize) {
		return admindao.selectAllOndutyByPage(startIndex, perPageSize);
	}
	
	//删除值班信息
	public boolean deleteOnduty(String oid) {
		return admindao.deleteOnduty(oid);
	}
	
	//判断是否有这个值班人员
	public List<Map<String, Object>> IsOnduty(String oid) {
		return admindao.IsOnduty(oid);
	}
	
	//增加值班信息
	public boolean addOnduty(Onduty onduty) {
		return admindao.addOnduty(onduty);
	}
	
	//查询所有机房信息
	public List<Map<String, Object>> selectAllComputerroom() {
		return admindao.selectAllComputerroom();
	}
	
	//条件查询设备
	public List<Map<String, Object>> conditionSelectEquipments(String ename, String ecomputerroom) {
		return admindao.conditionSelectEquipments(ename, ecomputerroom);
	}
	
	//查询设备信息
	public List<Map<String, Object>> selectEquipments() {
		return admindao.selectEquipments();
	}
	
	//分页条件查询设备
	public List<Map<String, Object>> conditionSelectEquipmentsByPage(String ename, String ecomputerroom, int startIndex,
			int perPageSize) {
		return admindao.conditionSelectEquipmentsByPage(ename, ecomputerroom, startIndex, perPageSize);
	}
	
	//分页查询所有设备信息
	public List<Map<String, Object>> selectAllEquipmentsByPage(int startIndex, int perPageSize) {
		return admindao.selectAllEquipmentsByPage(startIndex, perPageSize);
	}
	
	//删除设备
	public boolean deleteEquipment(String eid) {
		return admindao.deleteEquipment(eid);
	}
	
	//添加设备
	public boolean addEquipment(Equipment equipment) {
		return admindao.addEquipment(equipment);
	}
	
	//修改设备
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
	
	//查询所有的资金
	public List<Map<String, Object>> selectAllMoneylog() {
		return admindao.selectAllMoneylog();
	}
	
	//查询流入或流出的资金
	public List<Map<String, Object>> selectMoneylogByMtype(String mtype) {
		return admindao.selectMoneylogByMtype(mtype);
	}
	
	//记录设备资金
	public boolean addMoneylog(Equipment equipment) {
		return admindao.addMoneylog(equipment);
	}
	
	//通过机房查询用户
	public List<Map<String, Object>> selectUsersByUclassroom(String uclassroom) {
		return admindao.selectUsersByUclassroom(uclassroom);
	}


}
