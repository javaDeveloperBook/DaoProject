package com.jaywu.dbc;

import java.sql.Connection;

/**
 * 连接数据接口
 * 
 * @author Wujie
 *
 */
public interface IDatabaseConnection {

	/**
	 * 取得数据库连接
	 * 
	 * @return 数据连接
	 */
	public Connection getConnection();

	/**
	 * 关闭数据库连接
	 */
	public void close();

}
