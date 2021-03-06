package com.jaywu.factory;

import com.jaywu.dbc.IDatabaseConnection;
import com.jaywu.dbc.impl.DatabaseConnectionImpl;

/**
 * 获取数据库连接的工厂类
 * 
 * @author Wujie
 *
 */
public class DatabaseConnectionFactory {

	/**
	 * 私有化构造方法
	 */
	private DatabaseConnectionFactory() {

	}

	/**
	 * 获取数据库连接类实例对象
	 * 
	 * @return
	 */
	public static IDatabaseConnection getInstance() {
		return new DatabaseConnectionImpl();
	}
}
