package com.feipin.db;


import java.io.PrintWriter;
import java.sql.*;
public class DB_Conn {
	private String driverName="com.mysql.jdbc.Driver"; //驱动程序名
	private String userName="root";	//数据库用户名
	private String userPassword="root";	//数据库用户密码
	private String dbName="android_feipin";//数据库名
	private String url="jdbc:mysql://localhost/"+dbName+"?useUnicode=true&characterEncoding=GB2312"  ; //数据库连接字符串
	private Connection  conn=null;  //数据库连接对象
	private PrintWriter out=null;
	
	public  Statement sm=null;	//数据库语句对象
	
	
	//建立数据库连接函数
	public void ConnectDB(){
		try{
			Class.forName(driverName).newInstance();//实例化
			conn=DriverManager.getConnection(url,userName,userPassword);//获得数据库连接 
			sm=conn.createStatement();
			System.out.println("connect success");
		}
		catch(Exception e){
			e.printStackTrace();
			out.print("数据库连接失败!");
		}
	}
	
	//释放数据库连接函数
	public void CloseDB(){
		try{
			if(sm!=null){
				sm.close();
			}
			conn.close();	
		}
		catch(SQLException e){
			e.printStackTrace();
			out.print("数据库关闭失败!");
		}
	
	}
	public static void main(String []args){
		DB_Conn dbconn=new DB_Conn();
		dbconn.ConnectDB();
	}
	
		//DB_Conn dbconn=new DB_Conn();
		//dbconn.ConnectDB();
		
	/*	String str="d杜延康";
		String sql="insert into test(name,password) values('张三','fdfdfddd')";
		
		try{
			
			//sql=new String(sql.getBytes("ISO8859-1"),"GB2312");
			dbconn.sm.executeUpdate(sql);
			sql = "select * from test";
			ResultSet rst = dbconn.sm.executeQuery(sql);
		      while (rst.next()) {
		          System.out.println(rst.getString("name"));
		          
		      }
			

		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally{
			dbconn.CloseDB();
		}
	}*/
	
}

