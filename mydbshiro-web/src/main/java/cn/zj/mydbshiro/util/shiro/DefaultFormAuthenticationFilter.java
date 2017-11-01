package cn.zj.mydbshiro.util.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class DefaultFormAuthenticationFilter extends FormAuthenticationFilter {
	private String randName="rand";//验证码生成的的session属性名称
	private String randParam="code";//用户表单输入的名称
	
	public String getRandName() {
		return randName;
	}

	public void setRandName(String randName) {
		this.randName = randName;
	}

	public String getRandParam() {
		return randParam;
	}

	public void setRandParam(String randParam) {
		this.randParam = randParam;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpSession session = ((HttpServletRequest)request).getSession();
		//通过session获取生成的验证码信息
		System.out.println(randName);
		String rand=(String)session.getAttribute(randName);
		//获取用户表单输入的验证码信息
		String code=request.getParameter(randParam);
		
		System.out.println("验证码rand"+rand+"=="+"验证码code"+code);
		/*if(rand==null) {
			request.getRequestDispatcher("/login_pre.action").forward(request, response);
		}*/
		if(rand==null||"".equals(rand)) {
			return true;
		}
		if(code==null||"".equals(code)) {
			request.setAttribute("error", "验证码不允许为空");
			System.out.println("================");
			return true;//true表示拒绝
		}else {
			if(!rand.equalsIgnoreCase(code)) {
				request.setAttribute("error", "验证码输入错误");
				return true;
			}
		}
		
		return super.onAccessDenied(request, response);
	}
	
}
