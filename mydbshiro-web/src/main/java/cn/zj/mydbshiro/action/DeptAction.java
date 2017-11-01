package cn.zj.mydbshiro.action;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zj.mydbshiro.service.back.IDeptServiceBack;
import cn.zj.mydbshiro.vo.Dept;


@Controller
@RequestMapping("/pages/back/dept*")
public class DeptAction {
	@Resource
	private IDeptServiceBack deptService;
	@ResponseBody
	@RequestMapping("dept_add")
	public Object add(Dept vo) {
		return deptService.add(vo);
	}
	
	@RequestMapping("dept_list")
	@RequiresAuthentication//表示当前subject进行了身份的验证
	/*@RequiresPermissions(value= {"user:dept"})*/
	@RequiresRoles("dept")
	@RequiresPermissions("dept:list")
	@ResponseBody
	public Object list() {
		return deptService.list();
	
	}
	
	
	@RequestMapping("dept_remove")
	@ResponseBody
	public Object remove(long deptno) {
		return deptService.remove(deptno);
	}
}
