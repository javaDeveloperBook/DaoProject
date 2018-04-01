package com.jaywu.factory;

import com.jaywu.service.IEmpService;
import com.jaywu.service.impl.EmpServiceImpl;

/**
 * 业务层的工厂类
 * 
 * @author Wujie
 *
 */
public class IEmpServiceFactory {

	/**
	 * 私有化工厂类构造方法
	 */
	private IEmpServiceFactory() {

	}

	/**
	 * 取得业务层实例对象
	 * 
	 * @return
	 */
	public static IEmpService getInstance() {
		return new EmpServiceImpl();
	}
}
