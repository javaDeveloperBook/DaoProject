package com.jaywu.factory;

import com.jaywu.service.IDeptService;
import com.jaywu.service.impl.DeptServiceImpl;

/**
 * 部门表业务层工厂类
 * 
 * @author Wujie
 *
 */
public class IDeptServiceFactory {

	private IDeptServiceFactory() {

	}

	public static IDeptService getInstance() {
		return new DeptServiceImpl();
	}

}
