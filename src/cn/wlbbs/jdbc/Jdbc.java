package cn.wlbbs.jdbc;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import java.util.Date;
import cn.wlbbs.bean.*;
import static java.sql.DriverManager.getConnection;

/**
 * Created by Y on 2017/11/3.
 */

public class Jdbc {
	/**
	 * 
	 * 登录接口
	 * 
	 * @param stuid
	 *            用户名
	 * @/param pass
	 *            密码
	 * @return Int 类型 >0 为id 表示登录成功 -1 密码错误 -2 用户不存在  -3未接收到学号或密码 -5数据库连接错误，
	 */
	//登录
	public int login(String stuid, String pass) {
		try {
			if(stuid==null||pass==null)
			{
				return -3;//未接收到学号或密码
			}
			Connection con = getConnection();
			PreparedStatement preparedStatement = null;
			String sql ="select * from db_user where stuid=?";
			preparedStatement= con.prepareStatement(sql);
			preparedStatement.setString(1, stuid);	
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {			
				if (set.getString(4).equals(pass)) {
					System.out.println("登陆成功");
					return set.getInt("id");
				} else {
					return -1;
				}
			} else {
				return -2;
			}
		} catch (Exception e) {
			return -5;
		}
	}
	//发评论
	public void addPinglun(Integer uid,Integer fid ,String data){
		Connection con = getConnection();
		PreparedStatement pstmt =null;
		
	String sql = "INSERT INTO db_floorson(	fid,uid,data,starteddate) VALUES(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,fid);
			pstmt.setInt(2,uid);
			pstmt.setString(3,data);
			Date date=new Date();
			Timestamp ttime1=new Timestamp(date.getTime());
			pstmt.setTimestamp(4,ttime1);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch (SQLException e) {	
				e.printStackTrace();
			}
		}
	}
	//获取用户信息
			public UserBean getMessage(Integer id){
				String stuid=null;
				String name=null;
				String birthday=null;
				String school=null;
				String major=null;
				String note=null;
				String email=null;
				String res = null;
				String sql = "select * from db_user where stuid = ?";
				Connection con =getConnection();
				PreparedStatement pstmt =null;
				ResultSet rs = null;
				try { //String stuid,String name,String birthday,String school,String major,String note,String email
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, id);
					rs = pstmt.executeQuery();
					while(rs.next()){
						//System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"    ");
						stuid=rs.getString(2);
						 name=rs.getString(3);
						birthday=rs.getString(6);
						 school=rs.getString(7);
					major=rs.getString(8);
						note=rs.getString(10);
						 email=rs.getString(11);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(pstmt!=null)pstmt.close();
						if(con!=null)con.close();
					} catch (SQLException e) {		
						e.printStackTrace();
					}
				}
				UserBean ub=new UserBean(stuid,name,birthday,school,major,note,email);
			 return  ub;
			}

	//单例修改
		public static void update(String where,String what,Integer id) throws SQLException
	    {  
	        Connection conn=null;  
	        Statement st=null;  
	        ResultSet resultset=null;  

	        try {  
	            conn=Jdbc.getConnection(); 
	            st=(Statement) conn.createStatement();  
	            String sql="update db_user set";  
	           // update testupdate set where=what where id=id
	            //update 表名 set 列名=? where id =?
	            sql=sql+" "+where+"="+"'"+what+"'"+" where id="+id;
	            int i=st.executeUpdate(sql);  
	             System.out.println("i="+i);  
	        } finally  
	        {  
	        }  
	    }  

	//修改个人信息
	
		//发帖
		public void addTie(String name,int uid,String data,String zone){
			Connection con = getConnection();
			PreparedStatement pstmt =null;
			
		String sql = "INSERT INTO db_floor(	name,uid,data,zone,starteddate) VALUES(?,?,?,?,?)";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setInt(2,uid);
				pstmt.setString(3,data);
				pstmt.setString(4,zone);
				Date date=new Date();
				Timestamp ttime1=new Timestamp(date.getTime());
				pstmt.setTimestamp(5,ttime1);
				pstmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}catch (SQLException e) {	
					e.printStackTrace();
				}
			}
		}
	//模糊搜索
	public String findComment(String comment){
		String res = null;
		String sql = "select * from db_floor where DATA like ?";
		Connection con =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+comment+"%");
			rs = pstmt.executeQuery();
			Integer i=0;
			while(rs.next()){
				//FtBean Ft[]=new FtBean[];
				System.out.println(rs.getString(2)+"^^^^^"+rs.getString(5)+"   end");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public int stuidCheck(String stuid){//登录学号检查
		try {
			if(stuid==null)
			{
				return -3;
			}		
			Connection con = getConnection();
			PreparedStatement preparedStatement = null;
					String sql=	"select * from db_user where stuid=? ";	
					preparedStatement= con.prepareStatement(sql);
			preparedStatement.setString(1, stuid);			
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {
				return -1;
			} else {
				return 1;
			}
		} catch (Exception e) {
			return -5;
		}		
	}
	public int check(String stuid, String pass) {
		try {
			if(stuid==null||pass==null)
			{
				return -3;
			}
			Connection con = getConnection();
			PreparedStatement preparedStatement = null;
			String sql=	"select * from user where stuid=? ";	
			preparedStatement= con.prepareStatement(sql);
			preparedStatement.setString(1, stuid);			
			ResultSet set = preparedStatement.executeQuery();
			if (set.next()) {			
				if (set.getString(3).equals(pass)) {
					return set.getInt("id");
				} else {
					return -1;
				}
			} else {

				return -2;
			}
		} catch (Exception e) {
			return -9;
		}
	}
	//注册
	public int register(String stuid,String pass) {
		try {
			if(stuid==null||pass==null)
			{
				return -3;//学号或密码为空
			}else{
				Connection con = getConnection();
				PreparedStatement preparedStatement = null;
						String sql=	 "insert into db_user (stuid,pass,starteddate) values(?,?,?)";
						preparedStatement= con.prepareStatement(sql);
						preparedStatement.setString(1, stuid);
						preparedStatement.setString(2, pass);
						Date date=new Date();
						Timestamp rtime1=new Timestamp(date.getTime());
						preparedStatement.setTimestamp(3,rtime1);
						preparedStatement.executeUpdate();
						System.out.println("ok");
						return 1;//注册成功
			}
		} catch (Exception e) {
			return -5;//数据库连接错误
		}
	}
	public static Connection getConnection(){//获得连接
		String driver ="com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/mybbs";
		//	
		String user ="root";
		String password ="1234";
		Connection connection =null;
		try {
			Class.forName(driver);
			connection =DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
		//JDBC
		}

}
