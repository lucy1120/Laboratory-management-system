package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import entity.Admin;
import entity.Computerroom;
import entity.Equipment;
import entity.Onduty;
import entity.User;
public class AdminDao extends BaseDao{
	
	//����Ա��¼�ж�
	public boolean Alogin(int aid, String apwd){
		Admin auser = new Admin();
		auser.setAid(aid);
		auser.setApwd(apwd);
		String sql = "select * from admininfo where aid = ? and apwd = ?";
		Object param[] = {auser.getAid(), auser.getApwd()};
		List<Map<String, Object>> list = select(sql, param);
		if(list.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	//С�鳤��¼�ж�
	public boolean Ulogin(int aid, String apwd){
		User auser = new User();
		auser.setUid(aid);
		auser.setUpwd(apwd);
		String sql = "select * from sadmininfo where said = ? and sapwd = ?";
		Object param[] = {auser.getUid(), auser.getUpwd()};
		List<Map<String, Object>> list = select(sql, param);
		if(list.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	//��Ա��¼�ж�
		public boolean Mlogin(int aid, String apwd){
			User auser = new User();
			auser.setUid(aid);
			auser.setUpwd(apwd);
			String sql = "select * from userinfo where uid = ? and upwd = ?";
			Object param[] = {auser.getUid(), auser.getUpwd()};
			List<Map<String, Object>> list = select(sql, param);
			if(list.size() > 0){
				return true;
			}else{
				return false;
			}
		}

	//����ID��ѯ����Ա
	public List<Map<String, Object>> selectAdminID(int aid){
		String sql = "SELECT * from admininfo where aid = ?";
		Object param[] = {aid};
		return select(sql, param);
	}
	//����ID��ѯС�鳤
		public List<Map<String, Object>> selectUserID(int aid){
			String sql = "SELECT * from sadmininfo where said = ?";
			Object param[] = {aid};
			return select(sql, param);
		}
	//����ID��ѯ��Ա
			public List<Map<String, Object>> selectMemberID(int aid){
			String sql = "SELECT * from userinfo where uid = ?";
			Object param[] = {aid};
			return select(sql, param);
		}
		
	//��ѯ�û�
	public List<Map<String, Object>> selectUsers(){
		String sql = "SELECT * from userinfo";
		return select(sql, null);
	}
	
	//�ж��Ƿ�������û���
	public List<Map<String, Object>> IsUser(String uid){
		String sql = "select * from userinfo where uid = ?";
		Object param[] = {uid};
		return select(sql, param);
	}

	//ɾ���û�
	public boolean  deleteUser(String uid) {
		String sql = "delete from userinfo where uid=?";
		Object param[] = {uid};
		return upadateByParams(sql, param);
	}

	//����û�
	public boolean addUser(User user) {
		String sql = "INSERT INTO userinfo (uid,uname,upwd,uage,usex,ugrade,umajor,uclass,uclassroom) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
	
	//�޸Ĺ���Աĳһ��ֵ
	public boolean modifyAname(Admin user) {
		String sql = "update admininfo set aname = ? where aid = ?";
		Object param[] = {user.getAname(), user.getAid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyApwd(Admin user) {
		String sql = "update admininfo set apwd = ? where aid = ?";
		Object param[] = {user.getApwd(), user.getAid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyAage(Admin user) {
		String sql = "update admininfo set aage = ? where aid = ?";
		Object param[] = {user.getAage(), user.getAid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyAsex(Admin user) {
		String sql = "update admininfo set asex = ? where aid = ?";
		Object param[] = {user.getAsex(), user.getAid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyAgrade(Admin user) {
		String sql = "update admininfo set agrade = ? where aid = ?";
		Object param[] = {user.getAgrade(), user.getAid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyAmajor(Admin user) {
		String sql = "update admininfo set amajor = ? where aid = ?";
		Object param[] = {user.getAmajor(), user.getAid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyAclass(Admin user) {
		String sql = "update admininfo set aclass = ? where aid = ?";
		Object param[] = {user.getAclass(), user.getAid()};
		return upadateByParams(sql, param);
	}
	
	//�޸��û�ĳһ��ֵ
	public boolean modifyUname(User user) {
		String sql = "update userinfo set uname = ? where uid = ?";
		Object param[] = {user.getUname(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUpwd(User user) {
		String sql = "update userinfo set upwd = ? where uid = ?";
		Object param[] = {user.getUpwd(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUage(User user) {
		String sql = "update userinfo set uage = ? where uid = ?";
		Object param[] = {user.getUage(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUsex(User user) {
		String sql = "update userinfo set usex = ? where uid = ?";
		Object param[] = {user.getUsex(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUgrade(User user) {
		String sql = "update userinfo set ugrade = ? where uid = ?";
		Object param[] = {user.getUgrade(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUmajor(User user) {
		String sql = "update userinfo set umajor = ? where uid = ?";
		Object param[] = {user.getUmajor(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUclass(User user) {
		String sql = "update userinfo set uclass = ? where uid = ?";
		Object param[] = {user.getUclass(), user.getUid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyUclassroom(User user) {
		String sql = "update userinfo set uclassroom = ? where uid = ?";
		Object param[] = {user.getUclassroom(), user.getUid()};
		return upadateByParams(sql, param);
	}
	//�޸�ֵ���ĳһ��ֵ
	public boolean modifyOname(Onduty onduty) {
		String sql = "update onduty set oname = ? where oid = ?";
		Object param[] = {onduty.getOname(), onduty.getOid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyOweekday(Onduty onduty) {
		String sql = "update onduty set oweekday = ? where oid = ?";
		Object param[] = {onduty.getOweekday(), onduty.getOid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyObegintime(Onduty onduty) {
		String sql = "update onduty set obegintime = ? where oid = ?";
		Object param[] = {onduty.getObegintime(), onduty.getOid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyOendtime(Onduty onduty) {
		String sql = "update onduty set oendtime = ? where oid = ?";
		Object param[] = {onduty.getOendtime(), onduty.getOid()};
		return upadateByParams(sql, param);
	}
	public boolean modifyOroom(Onduty onduty) {
		String sql = "update onduty set oroom = ? where oid = ?";
		Object param[] = {onduty.getOroom(), onduty.getOid()};
		return upadateByParams(sql, param);
	}

	//������ѯ�û�
	public List<Map<String, Object>> conditionSelectUsers(String uname, String umajor, String uclassroom) {
		StringBuffer sql = new StringBuffer("select * from userinfo where 1 = 1");
		ArrayList<String> param = new ArrayList<String>();
		//�����û��������
		if(null != uname && uname.trim().length() > 0){
			sql.append(" and uname = ?");
			param.add(uname);
		}
		//������������
		if(null != uclassroom && uclassroom.trim().length() > 0){
			sql.append(" and uclassroom = ?");
			param.add(uclassroom);
		}
		//ѡ��רҵ�����
		if(!"all".equals(umajor)){
			sql.append(" and umajor = ? ");
			param.add(umajor);
		}
		return select(sql.toString(), param.toArray());
	}

	//��ҳ������ѯ�û�
	public List<Map<String, Object>> conditionSelectUsersByPage(String uname, String umajor, int startIndex, int perPageSize) {
		StringBuffer sql = new StringBuffer("select * from userinfo where 1 = 1");
		ArrayList<Object> param = new ArrayList<Object>();
		//�����û��������
		if(null != uname && uname.trim().length() > 0){
			sql.append(" and uname = ?");
			param.add(uname);
		}
		//ѡ��רҵ�����
		if(!"all".equals(umajor)){
			sql.append(" and umajor = ? ");
			param.add(umajor);
		}
		param.add(startIndex);
		param.add(perPageSize);
		sql.append(" limit ?, ? "); 
		return select(sql.toString(), param.toArray());
	}

	//��ҳ��ѯ�����û�
	public List<Map<String, Object>> selectAllUsersByPage(int startIndex, int perPageSize) {
		String sql = "select * from userinfo limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}

	//��ѯ���л�����Ϣ
	public List<Map<String, Object>> selectComputerroom() {
		String sql = "SELECT * from computerroom";
		return select(sql, null);
	}

	//������ѯ������Ϣ
	public List<Map<String, Object>> conditionSelectComputerroom(String crname, String crtype) {
		StringBuffer sql = new StringBuffer("select * from computerroom where 1 = 1");
		ArrayList<String> param = new ArrayList<String>();
		//��������������
		if(null != crname && crname.trim().length() > 0){
			sql.append(" and crname = ?");
			param.add(crname);
		}
		//ѡ�л������͵����
		if(!"all".equals(crtype)){
			sql.append(" and crtype = ? ");
			param.add(crtype);
		}
		return select(sql.toString(), param.toArray());
	}

	//��ҳ������ѯ������Ϣ
	public List<Map<String, Object>> conditionSelectComputerroomByPage(String crname, String crtype, int startIndex,
			int perPageSize) {
		StringBuffer sql = new StringBuffer("select * from computerroom where 1 = 1");
		ArrayList<Object> param = new ArrayList<Object>();
		//��������������
		if(null != crname && crname.trim().length() > 0){
			sql.append(" and crname = ?");
			param.add(crname);
		}
		//ѡ�л������͵����
		if(!"all".equals(crtype)){
			sql.append(" and crtype = ? ");
			param.add(crtype);
		}
		param.add(startIndex);
		param.add(perPageSize);
		sql.append(" limit ?, ? "); 
		return select(sql.toString(), param.toArray());
	}

	//��ҳ��ѯ���л�����Ϣ
	public List<Map<String, Object>> selectAllComputerroomByPage(int startIndex, int perPageSize) {
		String sql = "select * from computerroom limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}

	//��ѯ����δ��������Ͽλ���
	public List<Map<String, Object>> selectComputerroomExceptOnduty() {
		String sql = "SELECT * from computerroom where crtype = '�Ͽλ���' and crname not in (SELECT saclassroom from sadmininfo)";
		return select(sql, null);
	}
	
	//��ѯ����ֵ����
	public List<Map<String, Object>> selectAllComputerroomOnlyOnduty() {
		String sql = "SELECT * from computerroom where crtype = 'ֵ����'";
		return select(sql, null);
	}
	
	//��ѯ�����Ͽλ���
	public List<Map<String, Object>> selectAllComputerroomExceptOnduty() {
		String sql = "SELECT * from computerroom where crtype = '�Ͽλ���'";
		return select(sql, null);
	}
		
	//ɾ������
	public boolean deleteComputerroom(String crname) {
		String sql = "delete from computerroom where crname = ?";
		Object param[] = {crname};
		return upadateByParams(sql, param);
	}

	//�ж��Ƿ����������
	public List<Map<String, Object>> IsComputerroom(String crname) {
		String sql = "select * from computerroom where crname = ?";
		Object param[] = {crname};
		return select(sql, param);
	}

	//���ӻ���
	public boolean addComputerroom(Computerroom computerroom) {
		String sql = "INSERT INTO computerroom (crname,craddress,crtype) VALUES (?, ?, ?)";
		Object param[] = {
				computerroom.getCrname(),
				computerroom.getCraddress(),
				computerroom.getCrtype()
		};
		return upadateByParams(sql, param);
	}

	//ĳרҵ����Ա������
	public List<Map<String, Object>> selectUserMajorPeople(String major) {
		String sql = "select count(umajor) as major from userinfo where umajor = ?";
		Object param[] = {major};
		return select(sql, param);
	}
	//ĳרҵ��С�鳤������
	public List<Map<String, Object>> selectSadminMajorPeople(String major) {
		String sql = "select count(samajor) as major from sadmininfo where samajor = ?";
		Object param[] = {major};
		return select(sql, param);
	}
	//ĳ�꼶����Ա������
	public List<Map<String, Object>> selectUserGradePeople(String grade) {
		String sql = "select count(ugrade) as grade from userinfo where ugrade = ?";
		Object param[] = {grade};
		return select(sql, param);
	}
	//ĳ�꼶��С�鳤������
	public List<Map<String, Object>> selectSadminGradePeople(String grade) {
		String sql = "select count(sagrade) as grade from sadmininfo where sagrade = ?";
		Object param[] = {grade};
		return select(sql, param);
	}
	//ĳ�Ա����Ա������
	public List<Map<String, Object>> selectUserSexPeople(String sex) {
		String sql = "select count(usex) as sex from userinfo where usex = ?";
		Object param[] = {sex};
		return select(sql, param);
	}
	//ĳ�Ա��С�鳤������
	public Collection<? extends Map<String, Object>> selectSadminSexPeople(String sex) {
		String sql = "select count(sasex) as sex from sadmininfo where sasex = ?";
		Object param[] = {sex};
		return select(sql, param);
	}
	
	//������ѯֵ����Ϣ
	public List<Map<String, Object>> conditionSelectOnduty(String oname, String oweekday) {
		StringBuffer sql = new StringBuffer("select * from onduty where 1 = 1");
		ArrayList<String> param = new ArrayList<String>();
		//��������������
		if(null != oname && oname.trim().length() > 0){
			sql.append(" and oname = ?");
			param.add(oname);
		}
		//ѡ�л������͵����
		if(!"all".equals(oweekday)){
			sql.append(" and oweekday = ? ");
			param.add(oweekday);
		}
		return select(sql.toString(), param.toArray());
	}
	
	//��ѯֵ����Ϣ
	public List<Map<String, Object>> selectOnduty() {
		String sql = "SELECT * from onduty";
		return select(sql, null);
	}
	
	//��ҳ������ѯֵ����Ϣ
	public List<Map<String, Object>> conditionSelectOndutyByPage(String oname, String oweekday, int startIndex,
			int perPageSize) {
		StringBuffer sql = new StringBuffer("select * from onduty where 1 = 1");
		ArrayList<Object> param = new ArrayList<Object>();
		//��������������
		if(null != oname && oname.trim().length() > 0){
			sql.append(" and oname = ?");
			param.add(oname);
		}
		//ѡ�л������͵����
		if(!"all".equals(oweekday)){
			sql.append(" and oweekday = ? ");
			param.add(oweekday);
		}
		param.add(startIndex);
		param.add(perPageSize);
		sql.append(" limit ?, ? "); 
		return select(sql.toString(), param.toArray());
	}
	
	//��ҳ��ѯ����ֵ����Ϣ
	public List<Map<String, Object>> selectAllOndutyByPage(int startIndex, int perPageSize) {
		String sql = "select * from onduty limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}
	
	//ɾ��ֵ����Ϣ
	public boolean deleteOnduty(String oid) {
		String sql = "delete from onduty where oid=?";
		Object param[] = {oid};
		return upadateByParams(sql, param);
	}
	
	//�ж��Ƿ������ֵ����Ա
	public List<Map<String, Object>> IsOnduty(String oid) {
		String sql = "select * from onduty where oid = ?";
		Object param[] = {oid};
		return select(sql, param);
	}
	//����ֵ����Ϣ
	public boolean addOnduty(Onduty onduty) {
		String sql = "INSERT INTO onduty (oid,oname,oweekday,obegintime,oendtime,oroom) VALUES (?, ?, ?, ?, ?, ?)";
		Object param[] = {
				onduty.getOid(),
				onduty.getOname(), 
				onduty.getOweekday(), 
				onduty.getObegintime(),
				onduty.getOendtime(),
				onduty.getOroom()
		};
		return upadateByParams(sql, param);
	}
	
	//��ѯ���л�����Ϣ
	public List<Map<String, Object>> selectAllComputerroom() {
		String sql = "SELECT * from computerroom";
		return select(sql, null);
	}
	
	//������ѯ�豸
	public List<Map<String, Object>> conditionSelectEquipments(String ename, String ecomputerroom) {
		StringBuffer sql = new StringBuffer("select * from equipment where 1 = 1");
		ArrayList<String> param = new ArrayList<String>();
		//��������������
		if(null != ename && ename.trim().length() > 0){
			sql.append(" and ename = ?");
			param.add(ename);
		}
		//ѡ�л������͵����
		if(!"all".equals(ecomputerroom)){
			sql.append(" and ecomputerroom = ? ");
			param.add(ecomputerroom);
		}
		return select(sql.toString(), param.toArray());
	}
	
	//��ѯ�豸��Ϣ
	public List<Map<String, Object>> selectEquipments() {
		String sql = "SELECT * from equipment";
		return select(sql, null);
	}
	
	//��ҳ������ѯ�豸
	public List<Map<String, Object>> conditionSelectEquipmentsByPage(String ename, String ecomputerroom, int startIndex,
			int perPageSize) {
		StringBuffer sql = new StringBuffer("select * from equipment where 1 = 1");
		ArrayList<Object> param = new ArrayList<Object>();
		//��������������
		if(null != ename && ename.trim().length() > 0){
			sql.append(" and ename = ?");
			param.add(ename);
		}
		//ѡ�л������͵����
		if(!"all".equals(ecomputerroom)){
			sql.append(" and ecomputerroom = ? ");
			param.add(ecomputerroom);
		}
		param.add(startIndex);
		param.add(perPageSize);
		sql.append(" limit ?, ? "); 
		return select(sql.toString(), param.toArray());
	}
	
	//��ҳ��ѯ�����豸��Ϣ
	public List<Map<String, Object>> selectAllEquipmentsByPage(int startIndex, int perPageSize) {
		String sql = "select * from equipment limit ?, ?";
		Object param[] = {startIndex, perPageSize};
		return select(sql, param);
	}
	
	//ɾ���豸
	public boolean deleteEquipment(String eid) {
		String sql = "delete from equipment where eid=?";
		Object param[] = {eid};
		return upadateByParams(sql, param);
	}
	
	//����豸
	public boolean addEquipment(Equipment equipment) {
		String sql = "INSERT INTO equipment (ename,emoney,ecomputerroom,enumber) VALUES (?, ?, ?, ?)";
		Object param[] = {
				equipment.getEname(), 
				equipment.getEmoney(), 
				equipment.getEcomputerroom(),
				equipment.getEnumber()
		};
		return upadateByParams(sql, param);
	}
	
	//�޸��豸
	public boolean modifyEname(Equipment equipment, String ename) {
		String sql = "update equipment set ename = ? where ename = ? and ecomputerroom = ?";
		Object param[] = {ename, equipment.getEname(), equipment.getEcomputerroom()};
		return upadateByParams(sql, param);
	}
	public boolean modifyEmoney(Equipment equipment) {
		String sql = "update equipment set emoney = ? where ename = ? and ecomputerroom = ?";
		Object param[] = {equipment.getEmoney(), equipment.getEname(), equipment.getEcomputerroom()};
		return upadateByParams(sql, param);
	}
	public boolean modifyEcomputerroom(Equipment equipment, String ecomputerroom) {
		String sql = "update equipment set ecomputerroom = ? where ename = ? and ecomputerroom = ?";
		Object param[] = {ecomputerroom, equipment.getEname(), equipment.getEcomputerroom()};
		return upadateByParams(sql, param);
	}
	public boolean modifyEnumber(Equipment equipment) {
		String sql = "update equipment set enumber = ? where ename = ? and ecomputerroom = ?";
		Object param[] = {equipment.getEnumber(), equipment.getEname(), equipment.getEcomputerroom()};
		return upadateByParams(sql, param);
	}
	
	//��ѯ���е��ʽ�
	public List<Map<String, Object>> selectAllMoneylog() {
		String sql = "SELECT * from moneylog";
		return select(sql, null);
	}
	
	//��ѯ������������ʽ�
	public List<Map<String, Object>> selectMoneylogByMtype(String mtype) {
		String sql = "SELECT * from moneylog where mtype = ?";
		Object param[] = {mtype};
		return select(sql, param);
	}
	
	//��¼�豸�ʽ�
	public boolean addMoneylog(Equipment equipment) {
		String mremarks = "����" + equipment.getEname();
		String sql = "INSERT INTO moneylog (mtime,mtype,mremarks,mnumber) VALUES (NOW(), '����', ?, ?)";
		Object param[] = {
				mremarks,
				equipment.getEnumber() * equipment.getEmoney()
		};
		return upadateByParams(sql, param);
	}
	
	//ͨ��������ѯ�û�
	public List<Map<String, Object>> selectUsersByUclassroom(String uclassroom) {
		String sql = "SELECT * from userinfo where uclassroom = ?";
		Object param[] = {uclassroom};
		return select(sql, param);
	}
	
	
}
