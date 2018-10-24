package com.demohot.mybatis2.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class JdbcUnits {
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/score";
	static String user = "root";
	static String password = "111111";
	static Vector<Connection> pools = new Vector<Connection>();

	public static Connection getDBConnection() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, password, user);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	static {
		int i = 0;
		while (i < 10) {
			pools.add(getDBConnection());
			i++;
		}
	}

	public static synchronized Connection getPool() {
		if (pools != null && pools.size() > 0) {
			int last_ind = pools.size() - 1;
			return pools.remove(last_ind);
		} else {
			return getDBConnection();
		}
	}

	public static int insert(String sql, Object[] params) {
		Connection conn = getPool();
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstm.setObject(i + 1, params[i]);
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				pools.add(conn);
			}
		}
		return 0;
	}
}
