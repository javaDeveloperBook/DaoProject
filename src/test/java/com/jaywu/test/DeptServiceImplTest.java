package com.jaywu.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.jaywu.factory.IDeptServiceFactory;
import com.jaywu.vo.Dept;

import junit.framework.TestCase;

public class DeptServiceImplTest {

	@Test
	public void testInsert() {
		Dept vo = new Dept();
		vo.setDeptno(50);
		vo.setDeptname("BOSS");
		vo.setLoc("ChongQIN");
		try {
			TestCase.assertTrue(IDeptServiceFactory.getInstance().insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Dept vo = new Dept();
		vo.setDeptno(50);
		vo.setDeptname("BOSSAA");
		vo.setLoc("ChongQIN");
		try {
			TestCase.assertTrue(IDeptServiceFactory.getInstance().update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(50);
		try {
			TestCase.assertTrue(IDeptServiceFactory.getInstance().delete(ids));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			Dept dept = IDeptServiceFactory.getInstance().get(50);
			System.out.println(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			List<Dept> list = IDeptServiceFactory.getInstance().list();
			Iterator<Dept> iterator = list.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
