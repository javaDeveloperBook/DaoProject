package com.jaywu.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.jaywu.vo.Emp;

/**
 * 数据层操作接口
 * 
 * @author Wujie
 *
 */
public interface IEmpDAO {

	/**
	 * 插入操作
	 * 
	 * @param vo
	 *            雇员VO
	 * @return 插入成功返回true，否则返回false
	 */
	public boolean doCreate(Emp vo) throws SQLException;

	/**
	 * 更新操作
	 * 
	 * @param vo
	 *            雇员VO
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean doUpdate(Emp vo) throws SQLException;

	/**
	 * 批量删除操作
	 * 
	 * @param ids
	 *            雇员id（多个）
	 * @return 若已全部删除，则返回ture,否则返回false
	 */
	public boolean doRomveBatch(Set<Integer> ids) throws SQLException;

	/**
	 * 根据id查询雇员信息
	 * 
	 * @param id
	 *            雇员id
	 * @return 返回雇员信息VO
	 */
	public Emp findById(Integer id) throws SQLException;

	/**
	 * 查询所有雇员信息
	 * 
	 * @return 返回所有雇员信息 List<Emp>
	 */
	public List<Emp> findAll() throws SQLException;

	/**
	 * 分页查询，并且可以进行关键字查询
	 * 
	 * @param index
	 *            当前页
	 * @param pageSize
	 *            每页条数
	 * @param colmun
	 *            进行模糊查询列
	 * @param keyWord
	 *            关键字
	 * @return 返回雇员信息List<Emp>
	 */
	public List<Emp> findAllSplit(Integer index, Integer pageSize, String colmun, String keyWord) throws SQLException;

	/**
	 * 根据模糊查询进行数量统计
	 * 
	 * @param colmun
	 *            进行模糊查询列
	 * @param keyWord
	 *            关键字
	 * @return 返回统计条数
	 */
	public Integer getAllCount(String colmun, String keyWord) throws SQLException;
}
