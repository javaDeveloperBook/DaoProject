package com.jaywu.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jaywu.vo.Emp;

/**
 * 业务层接口
 * 
 * @author Wujie
 *
 */
public interface IEmpService {
	/**
	 * 插入操作<br>
	 * <li>需要调用IEmpDAO.findById()方法，判断要增加的id是否存在
	 * <li>如果要增加的数据的编码不存在则调用IEmpDAO.doCreate()方法，返回操作结果
	 * 
	 * @param vo
	 *            雇员信息
	 * @return 插入成功返回true，否则返回false
	 */
	public boolean insert(Emp vo) throws Exception;

	/**
	 * 更新操作，调用IEmpDAO.doUpdate()方法
	 * 
	 * @param vo
	 *            雇员信息
	 * @return 如果更新成功则返回ture，否则返回false
	 * @throws Exception
	 */
	public boolean update(Emp vo) throws Exception;

	/**
	 * 批量删除操作，调用IEmpDAO.doRomveBatch()方法
	 * 
	 * @param ids
	 *            批量山删除的id
	 * @return 如果批量删除成功返回ture，否则返回false
	 * @throws Exception
	 */
	public boolean delete(Set<Integer> ids) throws Exception;

	/**
	 * 根据雇员编号查找雇员信息，调用IEmpDAO.findById() 方法
	 * 
	 * @param id
	 *            雇员编号
	 * @return 返回雇员信息VO
	 */
	public Emp get(int id) throws Exception;

	/**
	 * 查询所有记录，调用IEmpDAO.findAll()方法
	 * 
	 * @return 所有雇员信息
	 */
	public List<Emp> list() throws Exception;

	/**
	 * 模糊查询并分页操作，调用IEmpDAO.findBySplit()和IEmpDAO.findAllCount()<br>
	 * <li>key = allEmps , value = IEmpDAO.findBySplit();
	 * <li>key = empCount , value = IEmpDAO.findAllCount();
	 * 
	 * @param index
	 *            当前页
	 * @param pageSize
	 *            每页条数
	 * @param colmun
	 *            模糊查询字段
	 * @param keWord
	 *            关键字
	 * @return 模糊、分页查询雇员信息记录，以及统计模糊查询总数
	 */
	public Map<String, Object> list(int index, int pageSize, String colmun, String keyWord) throws Exception;
}
