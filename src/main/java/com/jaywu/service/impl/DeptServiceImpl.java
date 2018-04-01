package com.jaywu.service.impl;

import java.util.List;
import java.util.Set;

import com.jaywu.dbc.IDatabaseConnection;
import com.jaywu.factory.DatabaseConnectionFactory;
import com.jaywu.factory.IDeptDAOFactory;
import com.jaywu.service.IDeptService;
import com.jaywu.vo.Dept;

public class DeptServiceImpl implements IDeptService {

	private IDatabaseConnection dbc;

	public DeptServiceImpl() {
		this.dbc = DatabaseConnectionFactory.getInstance();
	}

	public boolean insert(Dept vo) throws Exception {
		if (null == IDeptDAOFactory.getInstance(this.dbc.getConnection()).findById(vo.getDeptno())) {
			return IDeptDAOFactory.getInstance(this.dbc.getConnection()).doCreate(vo);
		}
		return false;
	}

	public boolean update(Dept vo) throws Exception {
		return IDeptDAOFactory.getInstance(this.dbc.getConnection()).doUpdate(vo);
	}

	public boolean delete(Set<Integer> ids) throws Exception {
		return IDeptDAOFactory.getInstance(this.dbc.getConnection()).doRomveBatch(ids);
	}

	public Dept get(Integer id) throws Exception {
		return IDeptDAOFactory.getInstance(this.dbc.getConnection()).findById(id);
	}

	public List<Dept> list() throws Exception {
		return IDeptDAOFactory.getInstance(this.dbc.getConnection()).findAll();
	}

}
