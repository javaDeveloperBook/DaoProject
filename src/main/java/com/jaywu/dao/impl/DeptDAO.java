package com.jaywu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.jaywu.dao.IDeptDAO;
import com.jaywu.vo.Dept;

public class DeptDAO implements IDeptDAO {

	/**
	 * 数据库连接
	 */
	private Connection connection;

	private PreparedStatement pStatement;

	public DeptDAO(Connection connection) {
		this.connection = connection;
	}

	public boolean doCreate(Dept vo) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO dept(deptno,dname,loc) VALUES(?,?,?)");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		this.pStatement.setInt(1, vo.getDeptno());
		this.pStatement.setString(2, vo.getDeptname());
		this.pStatement.setString(3, vo.getLoc());
		return this.pStatement.executeUpdate() > 0;
	}

	public boolean doUpdate(Dept vo) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE dept SET dname = ? ,loc = ? WHERE deptno = ? ");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		this.pStatement.setString(1, vo.getDeptname());
		this.pStatement.setString(2, vo.getLoc());
		this.pStatement.setInt(3, vo.getDeptno());
		return this.pStatement.executeUpdate() > 0;
	}

	public boolean doRomveBatch(Set<Integer> ids) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM dept WHERE deptno IN ( ");
		Iterator<Integer> iterator = ids.iterator();
		while (iterator.hasNext()) {
			sql.append(iterator.next() + ",");
		}
		sql.delete(sql.length() - 1, sql.length()).append(")");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		return this.pStatement.executeUpdate() == ids.size();
	}

	public Dept findById(Integer id) throws SQLException {
		Dept vo = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT deptno,dname,loc FROM dept WHERE deptno = ? ");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		this.pStatement.setInt(1, id);
		ResultSet resultSet = this.pStatement.executeQuery();
		if (resultSet.next()) {
			vo = new Dept();
			vo.setDeptno(resultSet.getInt(1));
			vo.setDeptname(resultSet.getString(2));
			vo.setLoc(resultSet.getString(3));
		}
		return vo;
	}

	public List<Dept> findAll() throws SQLException {
		List<Dept> list = new ArrayList<Dept>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT deptno,dname,loc FROM dept ");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		ResultSet resultSet = this.pStatement.executeQuery();
		while (resultSet.next()) {
			Dept vo = new Dept();
			vo.setDeptno(resultSet.getInt(1));
			vo.setDeptname(resultSet.getString(2));
			vo.setLoc(resultSet.getString(3));
			list.add(vo);
		}
		return list;
	}

	public List<Dept> findAllSplit(Integer index, Integer pageSize, String colmun, String keyWord) throws SQLException {
		return null;
	}

	public Integer getAllCount(String colmun, String keyWord) throws SQLException {
		return null;
	}

}
