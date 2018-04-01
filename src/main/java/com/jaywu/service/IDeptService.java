package com.jaywu.service;

import java.util.List;
import java.util.Set;

import com.jaywu.vo.Dept;

/**
 * 部门表业务层
 * 
 * @author Wujie
 *
 */
public interface IDeptService {

	/**
	 * 插入操作
	 * 
	 * @param vo
	 *            实体VO
	 * @return 插入成功返回ture，否则返回false
	 * @throws Exception
	 *             抛出异常
	 */
	public boolean insert(Dept vo) throws Exception;

	/**
	 * 更新操作
	 * 
	 * @param vo
	 *            实体VO
	 * @return 更新成功返回ture，否则返回false
	 * @throws Exception
	 *             抛出异常
	 */
	public boolean update(Dept vo) throws Exception;

	/**
	 * 批量删除
	 * 
	 * @param ids
	 *            删除id编号
	 * @return 删除成功返回true，否则返回false
	 * @throws Exception
	 *             抛出异常
	 */
	public boolean delete(Set<Integer> ids) throws Exception;

	/**
	 * 查询操作
	 * 
	 * @param id
	 *            编号
	 * @return 返回实体信息
	 * @throws Exception
	 *             抛出异常
	 */
	public Dept get(Integer id) throws Exception;

	/**
	 * 查询所有信息
	 * 
	 * @return 返回所有记录信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Dept> list() throws Exception;
}
