package com.jaywu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jaywu.dbc.IDatabaseConnection;
import com.jaywu.factory.DatabaseConnectionFactory;
import com.jaywu.factory.IEmpDAOFactory;
import com.jaywu.service.IEmpService;
import com.jaywu.vo.Emp;

public class EmpServiceImpl implements IEmpService {

	/**
	 * 数据库连接<br>
	 * 使用接口和工厂为了封装连接多种数据库，如Oracle,MySQL...
	 */
	private IDatabaseConnection dbc = DatabaseConnectionFactory.getInstance();

	public boolean insert(Emp vo) throws Exception {
		try {
			if (null == IEmpDAOFactory.getInstance(this.dbc.getConnection()).findById(vo.getEmpno())) {
				return IEmpDAOFactory.getInstance(this.dbc.getConnection()).doCreate(vo);
			} else {
				return false;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public boolean update(Emp vo) throws Exception {
		try {
			return IEmpDAOFactory.getInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			return IEmpDAOFactory.getInstance(this.dbc.getConnection()).doRomveBatch(ids);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public Emp get(int id) throws Exception {
		try {
			return IEmpDAOFactory.getInstance(this.dbc.getConnection()).findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public List<Emp> list() throws Exception {
		try {
			return IEmpDAOFactory.getInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public Map<String, Object> list(int index, int pageSize, String colmun, String keyWord) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("allEmps", IEmpDAOFactory.getInstance(this.dbc.getConnection()).findAllSplit(index, pageSize,
					colmun, keyWord));
			map.put("empCount", IEmpDAOFactory.getInstance(this.dbc.getConnection()).getAllCount(colmun, keyWord));
			return map;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

}
