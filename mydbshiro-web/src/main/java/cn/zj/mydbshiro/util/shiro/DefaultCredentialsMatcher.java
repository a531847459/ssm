package cn.zj.mydbshiro.util.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.zj.mydbshiro.util.PasswordUtil;
/**
 *定义一个加密匹配器
 * @author J1K3N
 *
 */
public class DefaultCredentialsMatcher extends SimpleCredentialsMatcher {
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//获取加密后的token串中的密码
		Object tokenCredentials = PasswordUtil.encoder(super.toString(token.getCredentials()));
		//获取认证后的密码
		Object infoCredentials=super.getCredentials(info);
		System.out.println("token密码"+tokenCredentials);
		System.out.println("info密码"+infoCredentials);
		return super.equals(tokenCredentials, infoCredentials);
	}
}
