package com.jaywu.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Oracle数据库scott用户emp表的实体类
 * 
 * @author Wujie
 *
 */
@SuppressWarnings("serial")
public class Emp implements Serializable {

	/**
	 * 雇员编号
	 */
	private Integer empno;

	/**
	 * 雇员名
	 */
	private String ename;

	/**
	 * 职位
	 */
	private String job;

	/**
	 * 雇员管理者
	 */
	private Integer mgr;

	/**
	 * 雇佣日期
	 */
	private Date hiredate;

	/**
	 * 工资
	 */
	private Double sal;

	/**
	 * 佣金
	 */
	private Double comm;

	/**
	 * 部门编号
	 */
	private Dept dept;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", dept=" + dept + "]";
	}

}
