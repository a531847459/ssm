package cn.zj.mydbshiro.realm;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.zj.mydbshiro.service.front.IMemberServiceFront;
import cn.zj.mydbshiro.util.PasswordUtil;
import cn.zj.mydbshiro.vo.Member;

public class MemberRealm extends AuthorizingRealm {
	@Resource 
	private IMemberServiceFront memberService;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println("===========1、进行用户认证操作（doGetAuthorizationInfo）");
		Member vo=memberService.get((String)token.getPrincipal());
		if(vo==null) {
			throw new UnknownAccountException("用户不存在");
		}
		String password=PasswordUtil.encoder(new String((char[])token.getCredentials()));
		System.out.println(password);
		if(!vo.getPassword().equals(password)) {
			throw new IncorrectCredentialsException("用户名或密码不正确");
		}
		if(vo.getLocked().equals(1)) {
			throw new LockedAccountException("该用户已被锁定");
		}
		return new SimpleAuthenticationInfo(token.getPrincipal(), password, "memberRealm");
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.err.println("===========2、进行用户授权处理操作（doGetAuthorizationInfo）");
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		Map<String,Set<String>> map=memberService.getRoleAndActionByMembers((String)principals.getPrimaryPrincipal());
		info.setRoles(map.get("allRoles"));
		info.setStringPermissions(map.get("allActions"));
		return info;
	}


}
