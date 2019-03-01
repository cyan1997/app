package com.feipin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.feipin.db.DB_Conn;
import com.feipin.vo.Infor;

public class InforDao {
	DB_Conn db_conn = new DB_Conn();

	// 添加新用户函数
	public int add(Infor infor) {
		db_conn.ConnectDB();

		ResultSet rs = null;
		Infor tmp = null;
		db_conn.ConnectDB();
		try {
			String sql = "select * from infor limit 1";
			rs = db_conn.sm.executeQuery(sql);
			while (rs.next()) {
				tmp = new Infor();
				tmp.setId(rs.getInt(1));
				tmp.setContent(rs.getString(2));
			}

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null == tmp) {
			try {
				String sql = "insert into infor(content)" + " values('"
						+ infor.getContent() + "')";
				System.out.println(sql);
				int i = db_conn.sm.executeUpdate(sql);
				return 1;
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
				return 0;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				db_conn.CloseDB();
			}
		} else {

			try {
				String sql = "update infor set content = '" + infor.getContent()
						+ "' where id=" + tmp.getId();

				return db_conn.sm.executeUpdate(sql);

			} catch (SQLException sqlE) {
				sqlE.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				db_conn.CloseDB();
			}
		}
		return 0;
	}
	
	
	public String selectInfor() {
		db_conn.ConnectDB();
		ResultSet rs = null;
		Infor tmp = null;
		db_conn.ConnectDB();
		String json = "" ;
		try {
			String sql = "select * from infor limit 1";
			rs = db_conn.sm.executeQuery(sql);
			while (rs.next()) {
				tmp = new Infor();
				tmp.setId(rs.getInt(1));
				tmp.setContent(rs.getString(2));
			}
			json = tmp.getContent() ;

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return json ;
	}

}
