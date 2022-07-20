package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BaseDao {
	// 存放Connection对象的数组，数组被看成连接池
	static ArrayList<Connection> list = new ArrayList<Connection>();

	public synchronized static Connection getConnection() {
		Connection con = null;
		// 如果连接池中有连接对象
		if (list.size() > 0) {
			return list.remove(0);
		}
		// 连接池没有连接对象创建连接放到连接池中
		else {
			for (int i = 0; i < 5; i++) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 创建连接

				try {
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/sysstudent?characterEncoding=utf-8","root","root123456");
					list.add(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return list.remove(0);
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized static void close(Connection con) {
		if (con != null)
			list.add(con);
	}

	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		close(rs);
		close(ps);
		close(con);
	}

	public boolean upadateByParams(String sql, Object param[]) {

		boolean flag = false;
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			if(param != null){
				for(int i = 1; i <= param.length; i++){
					ps.setObject(i, param[i-1]);
				}
			}
			int n = ps.executeUpdate();
			
			if(n > 0)
				flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null, ps, con);
		}		
		return flag;
	}
	

	public boolean BatchUpadateByParams(String sql, Object param[][]){
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			if(param != null){
				for(int i = 0; i < param.length; i++){//多条记录
					for(int j = 1; j <= param[i].length; j++){//每条记录里的参数替换
						ps.setObject(j, param[i][j-1]);
					}
					ps.addBatch();
				}
				ps.executeBatch();
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			close(null, ps, con);
		}	
	}

	public static List<Map<String, Object>> select(String sql,Object[] param){
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			ps = con.prepareStatement(sql);
			if(param != null){
				for(int i = 1; i <= param.length; i++){
					ps.setObject(i, param[i-1]);
				}
			}
			rs = ps.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			//列数
			int count = rm.getColumnCount();
			while(rs.next()){
				Map<String,Object> map = new HashMap<String, Object>();
				for(int i = 1; i <= count; i++){
					//key为列名，value为列值
					map.put(rm.getColumnName(i).toLowerCase(), rs.getObject(rm.getColumnName(i)));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, ps, con);
		}
		return list;
	}
	/**
	 * 获得最后一个id
	 */
	public int getLastId(String sql, String sql1, Object[] param) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		int id = 0;
		try {
			ps = con.prepareStatement(sql);
			if(param != null){
				for(int i = 1; i <= param.length; i++){
					ps.setObject(i, param[i-1]);
				}
			}
			ps.executeUpdate();
			ps1 = con.prepareStatement(sql1);
			rs = ps1.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			close(ps1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs, ps, con);
		}
		return id;
	}

	public static String getStringID(){
		String id=null;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		id=sdf.format(date);
		return id;
	}	
}
