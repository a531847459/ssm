package cn.zj.mydbshiro.service.back;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;

import cn.zj.mydbshiro.vo.Dept;


public interface IDeptServiceBack {
	@RequiresAuthentication
	@RequiresRoles("dept")
	@RequiresPermissions("dept:add")
	public boolean add(Dept vo);
	@RequiresAuthentication
	@RequiresRoles("dept")
	@RequiresPermissions("dept:list")
	public List<Dept> list();
	@RequiresAuthentication
	@RequiresRoles("dept")
	@RequiresPermissions("dept:remove")
	public boolean remove(long deptno);
}
