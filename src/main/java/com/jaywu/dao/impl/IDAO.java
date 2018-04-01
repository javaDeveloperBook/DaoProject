package com.jaywu.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * 公共的接口类方法，用于别的接口继承
 * 
 * @author Wujie
 *
 */
public interface IDAO<K, V> {
	/**
	 * 插入操作
	 * 
	 * @param vo
	 *            实体VO
	 * @return 插入成功返回true，否则返回false
	 */
	public boolean doCreate(V vo) throws SQLException;

	/**
	 * 更新操作
	 * 
	 * @param vo
	 *            实体VO
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean doUpdate(V vo) throws SQLException;

	/**
	 * 批量删除操作
	 * 
	 * @param ids
	 *            实体id（多个）
	 * @return 若已全部删除，则返回ture,否则返回false
	 */
	public boolean doRomveBatch(Set<K> ids) throws SQLException;

	/**
	 * 根据id查询实体信息
	 * 
	 * @param id
	 *            实体id
	 * @return 返回实体VO
	 */
	public V findById(K id) throws SQLException;

	/**
	 * 查询所有雇员信息
	 * 
	 * @return 返回所有实体信息 List<V>
	 */
	public List<V> findAll() throws SQLException;

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
	 * @return 返回实体信息List<V>
	 */
	public List<V> findAllSplit(Integer index, Integer pageSize, String colmun, String keyWord) throws SQLException;

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
