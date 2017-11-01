package cn.zj.mydbshiro.service.front;

import java.util.Map;
import java.util.Set;

import cn.zj.mydbshiro.vo.Member;



public interface IMemberServiceFront {
	public Member get(String mid);
	
	public Map<String,Set<String>> getRoleAndActionByMembers(String mid);
}
