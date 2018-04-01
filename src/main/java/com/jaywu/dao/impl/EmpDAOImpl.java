package com.jaywu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.jaywu.dao.IEmpDAO;
import com.jaywu.vo.Emp;

public class EmpDAOImpl implements IEmpDAO {

	/**
	 * 数据库连接
	 */
	private Connection connection;
	private PreparedStatement pStatement;

	public EmpDAOImpl(Connection connection) {
		this.connection = connection;
	}

	public boolean doCreate(Emp vo) throws SQLException {
		String sql = "INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) " + " VALUES (?,?,?,?,?,?,?,?)";
		this.pStatement = this.connection.prepareStatement(sql);
		this.pStatement.setInt(1, vo.getEmpno());
		this.pStatement.setString(2, vo.getEname());
		this.pStatement.setString(3, vo.getJob());
		this.pStatement.setInt(4, vo.getMgr());
		this.pStatement.setDate(5, new java.sql.Date(vo.getHiredate().getTime()));
		this.pStatement.setDouble(6, vo.getSal());
		this.pStatement.setDouble(7, vo.getComm());
		this.pStatement.setInt(8, vo.getDeptno());
		return this.pStatement.executeUpdate() > 0;
	}

	public boolean doUpdate(Emp vo) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE emp ");
		sql.append(" SET ename = ? ,job = ? ,mgr = ?,hiredate = ?,sal = ?,comm = ?,deptno = ? ");
		sql.append(" WHERE empno = ? ");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		this.pStatement.setString(1, vo.getEname());
		this.pStatement.setString(2, vo.getJob());
		this.pStatement.setInt(3, vo.getMgr());
		this.pStatement.setDate(4, new java.sql.Date(vo.getHiredate().getTime()));
		this.pStatement.setDouble(5, vo.getSal());
		this.pStatement.setDouble(6, vo.getComm());
		this.pStatement.setInt(7, vo.getDeptno());
		this.pStatement.setInt(8, vo.getEmpno());
		return this.pStatement.executeUpdate() > 0;
	}

	public boolean doRomveBatch(Set<Integer> ids) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM emp where empno IN ( ");
		Iterator<Integer> iterator = ids.iterator();
		while (iterator.hasNext()) {
			sql.append(iterator.next() + ",");
		}
		sql.delete(sql.length() - 1, sql.length()).append(" )");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		return this.pStatement.executeUpdate() == ids.size();
	}

	public Emp findById(Integer id) throws SQLException {
		Emp vo = null;
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno FROM emp WHERE empno = ? ");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		this.pStatement.setInt(1, id);
		ResultSet resultSet = this.pStatement.executeQuery();
		if (resultSet.next()) {
			vo = new Emp();
			vo.setEmpno(resultSet.getInt(1));
			vo.setEname(resultSet.getString(2));
			vo.setJob(resultSet.getString(3));
			vo.setMgr(resultSet.getInt(4));
			vo.setHiredate(resultSet.getDate(5));
			vo.setSal(resultSet.getDouble(6));
			vo.setComm(resultSet.getDouble(7));
			vo.setDeptno(resultSet.getInt(8));
		}
		return vo;
	}

	public List<Emp> findAll() throws SQLException {
		List<Emp> list = new ArrayList<Emp>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno FROM emp ");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		ResultSet resultSet = this.pStatement.executeQuery();
		while (resultSet.next()) {
			Emp vo = new Emp();
			vo.setEmpno(resultSet.getInt(1));
			vo.setEname(resultSet.getString(2));
			vo.setJob(resultSet.getString(3));
			vo.setMgr(resultSet.getInt(4));
			vo.setHiredate(resultSet.getDate(5));
			vo.setSal(resultSet.getDouble(6));
			vo.setComm(resultSet.getDouble(7));
			vo.setDeptno(resultSet.getInt(8));
			list.add(vo);
		}
		return list;
	}

	public List<Emp> findAllSplit(Integer index, Integer pageSize, String colmun, String keyWord) throws SQLException {
		List<Emp> list = new ArrayList<Emp>();
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM ");
		sql.append(" ( SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno,ROWNUM rn ");
		sql.append(" FROM emp WHERE " + colmun + " LIKE  ? AND ROWNUM <= ? ) temp ");
		sql.append(" WHERE temp.rn > ? ");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		this.pStatement.setString(1, "%" + keyWord + "%");
		this.pStatement.setInt(2, (index * pageSize));
		this.pStatement.setInt(3, (index - 1) * pageSize);
		ResultSet resultSet = this.pStatement.executeQuery();
		while (resultSet.next()) {
			Emp vo = new Emp();
			vo.setEmpno(resultSet.getInt(1));
			vo.setEname(resultSet.getString(2));
			vo.setJob(resultSet.getString(3));
			vo.setMgr(resultSet.getInt(4));
			vo.setHiredate(resultSet.getDate(5));
			vo.setSal(resultSet.getDouble(6));
			vo.setComm(resultSet.getDouble(7));
			vo.setDeptno(resultSet.getInt(8));
			list.add(vo);
		}
		return list;
	}

	public Integer getAllCount(String colmun, String keyWord) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT COUNT(*) FROM emp WHERE " + colmun + " LIKE ? ");
		this.pStatement = this.connection.prepareStatement(sql.toString());
		this.pStatement.setString(1, "%" + keyWord + "%");
		ResultSet resultSet = this.pStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt(1);
		}
		return null;
	}

}
