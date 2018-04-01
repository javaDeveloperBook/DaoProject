package com.jaywu.factory;

import java.sql.Connection;

import com.jaywu.dao.IEmpDAO;
import com.jaywu.dao.impl.EmpDAOImpl;

/**
 * 数据层工厂类
 * 
 * @author Wujie
 *
 */
public class IEmpDAOFactory {

	private IEmpDAOFactory() {

	}

	public static IEmpDAO getInstance(Connection connection) {
		return new EmpDAOImpl(connection);
	}
}
