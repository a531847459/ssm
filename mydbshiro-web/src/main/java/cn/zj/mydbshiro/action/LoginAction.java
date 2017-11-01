package cn.zj.mydbshiro.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAction {
//	@RequestMapping("/login_pre")
//	public String loginPre() {
//		return "login";
//	}
//	@RequestMapping("/login")
//	public String login(String mid,String password,HttpServletRequest request) {
//		AuthenticationToken token=new UsernamePasswordToken(mid, password);
//		try {
//			SecurityUtils.getSubject().login(token);
//			return "back/welcome";
//		}catch (Exception e) {
//			request.setAttribute("erro", e.getMessage());
//			return "login";
//		}
//	}
	@RequestMapping("/login_pre")
	public String loginPre() {
		return "login";
	}
	@ResponseBody
	@RequestMapping("/unauth")
	public Object unauth() {
		Object msg="没有此类权限处理";
		return msg;
	}
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@RequestMapping("/pages/back/welcome")
	public String welcome() {
		return "/back/welcome";
	}
}
