package com.feipin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.feipin.db.DB_Conn;
import com.feipin.vo.Liuyan;
import com.feipin.vo.Qiandao;

public class QiandaoDao {
	DB_Conn db_conn = new DB_Conn();

	// Ìí¼ÓÐÂÁôÑÔº¯Êý
	public int add(Qiandao liuyan) {
		db_conn.ConnectDB();
		try {
			String sql = "insert into qiandao(content,username, status)"
					+ " values('"
					+ liuyan.getContent()
					+ "','"
					+ liuyan.getUsername()
					+ "','"
					+ liuyan.getStatus() + "')";

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

	public void delete_by_id(int liuyan_id) {

		int rs;
		db_conn.ConnectDB();
		try {

			String sql;
			sql = "delete from qiandao where id=" + liuyan_id;

			rs = db_conn.sm.executeUpdate(sql);

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db_conn.CloseDB();
		}
	}

	public void update_by_id(Liuyan liuyan) {

		int rs;
		db_conn.ConnectDB();
		try {

			String sql = "update qiandao set content="
					+ liuyan.getContent() + "'" + ",status = " + "'"
					+ liuyan.getStatus() + "'" + ",username = " + "'"
					+ liuyan.getUsername() + "'" + " where id='"
					+ liuyan.getId() + "'";

			rs = db_conn.sm.executeUpdate(sql);

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db_conn.CloseDB();
		}
	}

	public Liuyan find_liuyan_byid(Integer id) {

		ResultSet rs = null;
		db_conn.ConnectDB();
		Liuyan tmp = null;
		try {
			String sql = "select * from qiandao where id = " + id;
			rs = db_conn.sm.executeQuery(sql);
			while (rs.next()) {
				tmp = new Liuyan();
				tmp.setId(rs.getInt(1));
				tmp.setContent(rs.getString(2));
				tmp.setUsername(rs.getString(3));
				tmp.setStatus(rs.getString(4));
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

	public List<Qiandao> find_all_liuyan() {

		ResultSet rs = null;
		List<Qiandao> liuyan_list = new ArrayList<Qiandao>();
		db_conn.ConnectDB();
		try {
			String sql = "select * from qiandao";
			rs = db_conn.sm.executeQuery(sql);
			while (rs.next()) {
				Qiandao tmp = new Qiandao();
				tmp.setId(rs.getInt(1));
				tmp.setContent(rs.getString(2));
				tmp.setUsername(rs.getString(3));
				tmp.setStatus(rs.getString(4));
				liuyan_list.add(tmp);
			}

		} catch (SQLException sqlE) {
			sqlE.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db_conn.CloseDB();
		}
		return liuyan_list;
	}

}
