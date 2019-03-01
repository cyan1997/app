package com.feipin.dao;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.feipin.db.DB_Conn;
import com.feipin.vo.User;







public class UserDao {
	DB_Conn db_conn=new DB_Conn();
	//添加新用户函数
	public int add(User user){
		db_conn.ConnectDB();
		try{
			String sql="insert into user(user_name,user_password, user_type)"
				+" values('" + user.getName() +"','"+user.getPassword()+ "'," + user.getUsertype()+") ";
				
				
			//sql=new String(sql.getBytes("ISO-8859-1"),"GB2312");
			System.out.println(sql);
			int i=db_conn.sm.executeUpdate(sql);
			//System.out.println("Sucess");
			return 1;
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
			return 0;
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		finally{
			db_conn.CloseDB();
		}
	}
	public int getUserType(String user_name){
		boolean isLogin = false;
		ResultSet rs = null;
		int type = 0;
		db_conn.ConnectDB();
		try{
			
			String sql= "select * from user where user_name='"+user_name+"'";		
			rs = db_conn.sm.executeQuery(sql);
			if (rs.next())
			{
				isLogin = true;
				
				type = rs.getInt(3);
			}
			return type;
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
			return type;
		}
		catch(Exception e){
			e.printStackTrace();
			return type;
		}
		finally{
			db_conn.CloseDB();
		}
	}
	public boolean login(String login_name, String login_password){
		boolean isLogin = false;
		ResultSet rs = null;
		db_conn.ConnectDB();
		try{
			/*String sql= "select * from user where user_name='"+login_name+
				"' and user_password ='" + login_password + "' and user_type =" + type
				+ " and user_state = " + 1;*/
			String sql= "select * from user where user_name='"+login_name+
				"' and user_password ='" + login_password+"'";
			
			System.out.println(sql);
			rs = db_conn.sm.executeQuery(sql);
			
			if (rs.next())
			{
				isLogin = true;
				System.out.println("find");
			}
			return isLogin;
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
			return isLogin;
		}
		catch(Exception e){
			e.printStackTrace();
			return isLogin;
		}
		finally{
			db_conn.CloseDB();
		}
	}
	public int update_user_type(String user_name){

		
		db_conn.ConnectDB();
		try{
			String sql="update user set user_type="+2+" where user_name='"+user_name+"'";
				
			
			//sql=new String(sql.getBytes("ISO8859-1"),"GB2312");
			System.out.println(sql);
			int i=db_conn.sm.executeUpdate(sql);
			return i;
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
			return -1;
		}
		catch(Exception e){
			e.printStackTrace();
			return -2;
		}
		finally{
			db_conn.CloseDB();
		}
	}
	/**
	 * 设置用户信息
	 * @param user_name
	 * @param phone
	 * @param weixin
	 * @param qq
	 * @return
	 */
	public int update_user_infor(String user_name, String phone, String weixin, String qq){

		
		db_conn.ConnectDB();
		try{
			String sql="update user set user_type="+2+ ",phone = " + "'" + phone + "'"+ ",weixin = " + "'" + weixin + "'"+ ",qq = " + "'" + qq + "'" + " where user_name='"+user_name+"'";
				
			//sql=new String(sql.getBytes("ISO8859-1"),"GB2312");
			System.out.println(sql);
			int i=db_conn.sm.executeUpdate(sql);
			return i;
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
			return -1;
		}
		catch(Exception e){
			e.printStackTrace();
			return -2;
		}
		finally{
			db_conn.CloseDB();
		}
	}
	
	public void delete(String name){
		
		int rs;
		db_conn.ConnectDB();
		try{
			String sql="delete from user where user_name='"+name+"'";
				
			rs = db_conn.sm.executeUpdate(sql);
		
		
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			db_conn.CloseDB();
		}
	}
	public List<User> find_all_user(){

		ResultSet rs = null;
		List<User> user_list = new ArrayList<User>();
		db_conn.ConnectDB();
		try{
			String sql= "select * from user where user_type!="+0;
			rs = db_conn.sm.executeQuery(sql);
			while (rs.next())
			{
				User user = new User();
				
				user.setName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setUsertype(rs.getInt(3));
				
				user_list.add(user);
			}
			
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			db_conn.CloseDB();
		}
		return user_list;
	}
	
	public static void main(String []args){
		UserDao  userDao = new UserDao();
		
		//userDao.find_all_restaurant();
		//userDao.login("du", "323");
		
	}

}
