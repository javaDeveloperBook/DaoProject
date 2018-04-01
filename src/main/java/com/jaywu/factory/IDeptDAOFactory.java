package com.jaywu.factory;

import java.sql.Connection;

import com.jaywu.dao.IDeptDAO;
import com.jaywu.dao.impl.DeptDAO;

/**
 * 部门表数据层接口工程类
 * 
 * @author Wujie
 *
 */
public class IDeptDAOFactory {

	private IDeptDAOFactory() {

	}

	public static IDeptDAO getInstance(Connection connection) {
		return new DeptDAO(connection);
	}
}
