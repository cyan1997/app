package com.feipin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.feipin.db.DB_Conn;
import com.feipin.vo.ShiWuXinXi;

public class ShiWuXinXiDao {
	DB_Conn db_conn = new DB_Conn();

	// 添加新失物函数
	public int add(ShiWuXinXi shiwuxinxi) {
		db_conn.ConnectDB();
		try {
			String sql = "insert into shiwuxinxi(content, date, status, username, type)"
					+ " values('"
					+ shiwuxinxi.getContent()
					+ "','"
					+ shiwuxinxi.getDate()
					+ "','"
					+ shiwuxinxi.getStatus()
					+ "','"
					+ shiwuxinxi.getUsername()
					+ "','"
					+ shiwuxinxi.getType() + "')";

			System.out.println(sql);
			int i = db_conn.sm.executeUpdate(sql);
			// System.out.println("Sucess");
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
	}

	public void delete_by_id(int shiwuxinxi_id) {

		int rs;
		db_conn.ConnectDB();
		try {

			String sql;
			sql = "delete from shiwuxinxi where id=" + shiwuxinxi_id;

			rs = db_conn.sm.executeUpdate(sql);

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db_conn.CloseDB();
		}
	}

	public void update_by_id(ShiWuXinXi shiwuxinxi) {

		int rs;
		db_conn.ConnectDB();
		try {

			String sql = "update shiwuxinxi set content="
					+ shiwuxinxi.getContent() + ",date = " + "'"
					+ shiwuxinxi.getDate() + "'" + ",status = " + "'"
					+ shiwuxinxi.getStatus() + "'" + ",username = " + "'"
					+ shiwuxinxi.getUsername() + ",type = " + "'"
					+ shiwuxinxi.getType() + "'" + " where id='"
					+ shiwuxinxi.getId() + "'";

			rs = db_conn.sm.executeUpdate(sql);

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db_conn.CloseDB();
		}
	}

	public ShiWuXinXi find_shiwuxinxi_byid(Integer id) {

		ResultSet rs = null;
		db_conn.ConnectDB();
		ShiWuXinXi tmp = null;
		try {
			String sql = "select * from shiwuxinxi where id = " + id;
			rs = db_conn.sm.executeQuery(sql);
			while (rs.next()) {
				tmp = new ShiWuXinXi();
				tmp.setId(rs.getInt(1));
				tmp.setContent(rs.getString(2));
				tmp.setDate(rs.getString(3));
				tmp.setStatus(rs.getString(4));
				tmp.setUsername(rs.getString(5));
				tmp.setType(rs.getString(6));
			}

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db_conn.CloseDB();
		}
		return tmp;
	}

	public List<ShiWuXinXi> find_all_shiwuxinxi() {

		ResultSet rs = null;
		List<ShiWuXinXi> shiwuxinxi_list = new ArrayList<ShiWuXinXi>();
		db_conn.ConnectDB();
		try {
			String sql = "select A.id, content, status, username,B.phone,A.type,A.date from shiwuxinxi as A ,user as B WHERE A.username = B.user_name";
			rs = db_conn.sm.executeQuery(sql);
			while (rs.next()) {
				ShiWuXinXi tmp = new ShiWuXinXi();
				tmp.setId(rs.getInt(1));
				tmp.setContent(rs.getString(2));
				tmp.setStatus(rs.getString(3));
				tmp.setUsername(rs.getString(4));
				tmp.setPhone(rs.getString(5));
				tmp.setType(rs.getString(6));
				tmp.setDate(rs.getString(7));				
				shiwuxinxi_list.add(tmp);
			}

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db_conn.CloseDB();
		}
		return shiwuxinxi_list;
	}

	public List<ShiWuXinXi> search_all_shiwuxinxi(String key) {

		ResultSet rs = null;
		List<ShiWuXinXi> shiwuxinxi_list = new ArrayList<ShiWuXinXi>();
		db_conn.ConnectDB();
		try {
			String sql = "select A.id, content, status, username,B.phone,A.type,A.date from shiwuxinxi as A ,user as B WHERE A.username = B.user_name and content like '%" + key +"%'";
			rs = db_conn.sm.executeQuery(sql);
			while (rs.next()) {
				ShiWuXinXi tmp = new ShiWuXinXi();
				tmp.setId(rs.getInt(1));
				tmp.setContent(rs.getString(2));
				tmp.setStatus(rs.getString(3));
				tmp.setUsername(rs.getString(4));
				tmp.setPhone(rs.getString(5));
				tmp.setType(rs.getString(6));
				tmp.setDate(rs.getString(7));				
				shiwuxinxi_list.add(tmp);
			}

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db_conn.CloseDB();
		}
		return shiwuxinxi_list;
	}

	
}
