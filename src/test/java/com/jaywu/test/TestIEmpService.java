package com.jaywu.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jaywu.factory.IEmpServiceFactory;
import com.jaywu.service.IEmpService;
import com.jaywu.vo.Dept;
import com.jaywu.vo.Emp;

/**
 * 测试业务层
 * 
 * @author Wujie
 *
 */
public class TestIEmpService {

	@Test
	public void testInsert() {
		// 组装数据
		Dept deptVo = new Dept();
		deptVo.setDeptno(10);
		deptVo.setDeptname("ACCOUNTING");
		deptVo.setLoc("NEW YORK");
		
		Emp vo = new Emp();
		vo.setEmpno(8888);
		vo.setEname("Jaywu");
		vo.setJob("Enginer");
		vo.setMgr(7839);
		vo.setHiredate(new Date());
		vo.setSal(1000.00);
		vo.setComm(1000.00);
		vo.setDept(deptVo);

		// 插入数据
		IEmpService service = IEmpServiceFactory.getInstance();
		try {
			System.out.println(service.insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Dept deptVo = new Dept();
		deptVo.setDeptno(20);
		deptVo.setDeptname("RESEARCH");
		deptVo.setLoc("DALLAS");
		
		Emp vo = new Emp();
		vo.setEmpno(8888);
		vo.setEname("Jaywu");
		vo.setJob("Enginer");
		vo.setMgr(7839);
		vo.setHiredate(new Date());
		vo.setSal(99999.00);
		vo.setComm(1000.00);
		vo.setDept(deptVo);

		// 修改数据
		IEmpService service = IEmpServiceFactory.getInstance();
		try {
			service.update(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		IEmpService service = IEmpServiceFactory.getInstance();
		try {
			Emp emp = service.get(8888);
			System.out.println("姓名：" + emp.getEname() + ",工资：" + emp.getSal()+",部门："+emp.getDept().getDeptname()+",工作地址："+emp.getDept().getLoc());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListAll() {
		IEmpService service = IEmpServiceFactory.getInstance();
		try {
			List<Emp> list = service.list();
			Iterator<Emp> iterator = list.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testListPage() {
		IEmpService service = IEmpServiceFactory.getInstance();
		try {
			Map<String, Object> map = service.list(1, 5, "job", "En");
			int count = (Integer) map.get("empCount");
			System.out.println("total：" + count);
			List<Emp> list = (List<Emp>) map.get("allEmps");
			Iterator<Emp> iterator = list.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		IEmpService service = IEmpServiceFactory.getInstance();
		HashSet<Integer> ids = new HashSet<Integer>();
		ids.add(8888);
		try {
			System.out.println(service.delete(ids));
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
