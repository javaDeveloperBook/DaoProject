package com.jaywu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据专用类
 * @author Wujie
 *
 */
public class DatabaseConnection {
	/**
	 * 连接数据库信息
	 */
	private static final String DRIVERCLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "root";
	private Connection connection;
	
	/**
	 * 构造方法中获取数据库连接
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DRIVERCLASS);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 取得数据库连接
	 * @return 数据连接
	 */
	public Connection getConnection() {
		return this.connection;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void close() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DatabaseConnection data = new DatabaseConnection();
		System.out.println(data.getConnection());
	}
}
