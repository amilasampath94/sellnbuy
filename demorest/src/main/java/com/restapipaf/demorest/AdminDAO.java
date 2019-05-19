package com.restapipaf.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

	Connection con = null;

	public AdminDAO() {
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Admin> getAdmins() {
		List<Admin> admins = new ArrayList<>();
		String sql = "select* from alien";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Admin a = new Admin();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setEmail(rs.getString(3));
				a.setPassword(rs.getString(4));
				a.setP_num(rs.getInt(5));

				admins.add(a);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return admins;
	}

	public Admin getAdmin(int id) {
		String sql = "select* from alien where id=" + id;
		Admin a = new Admin();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setEmail(rs.getString(3));
				a.setPassword(rs.getString(4));
				a.setP_num(rs.getInt(5));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return a;

	}

	public void create(Admin a1) {
		String sql = "insert into alien values (?,?,?,?,?)";
		try {
			java.sql.PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setString(3, a1.getEmail());
			st.setString(4, a1.getPassword());
			st.setInt(5, a1.getP_num());
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(Admin a1) {
		String sql = "update alien set name=?, email=?, password=?, p_num=? where id=?";
		try {
			java.sql.PreparedStatement st = con.prepareStatement(sql);

			st.setInt(5, a1.getId());
			st.setString(1, a1.getName());
			st.setString(2, a1.getEmail());
			st.setString(3, a1.getPassword());
			st.setInt(4, a1.getP_num());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from alien where id=?";
		try {
			java.sql.PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
