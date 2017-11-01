package cn.zj.mydbshiro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.zj.mydbshiro.service.back.IDeptServiceBack;
import cn.zj.mydbshiro.vo.Dept;
@Service
public class DeptServiceBackImpl implements IDeptServiceBack {
	
	@Override
	public boolean add(Dept vo) {
		System.out.println("增加新部门");
		return false;
	}

	@Override
	public List<Dept> list() {
		System.out.println("查询部门");
		List<Dept> all=new ArrayList<>();
		for(int x=0;x<10;x++) {
			Dept vo=new Dept();
			vo.setDeptno((long)x);
			vo.setDname("mldn"+x);
			vo.setLoc("北京-"+x);
			all.add(vo);
		}
		return all;
	}

	@Override
	public boolean remove(long deptno) {
		System.out.println("删除部门数据,删除的部门编号："+deptno);
		return false;
	}

}
