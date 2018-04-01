package com.jaywu.vo;

import java.io.Serializable;

/**
 * 部门实体类
 * @author Wujie
 *
 */
@SuppressWarnings("serial")
public class Dept implements Serializable {

	/**
	 * 部门编号
	 */
	private Integer deptno;
	
	/**
	 * 部门名称
	 */
	private String deptname;
	
	/**
	 * 部门地址
	 */
	private String loc;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", deptname=" + deptname + ", loc=" + loc + "]";
	}
	
}
