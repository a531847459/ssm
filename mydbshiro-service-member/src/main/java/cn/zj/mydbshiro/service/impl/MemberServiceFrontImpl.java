package cn.zj.mydbshiro.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zj.mydbshiro.dao.IActionDAO;
import cn.zj.mydbshiro.dao.IMemberDAO;
import cn.zj.mydbshiro.dao.IRoleDAO;
import cn.zj.mydbshiro.service.front.IMemberServiceFront;
import cn.zj.mydbshiro.vo.Member;

@Service
public class MemberServiceFrontImpl implements IMemberServiceFront {
	@Resource
	private IMemberDAO memberDAO;
	@Resource
	private IRoleDAO roleDAO;
	@Resource
	private IActionDAO actionDAO;
	@Override
	public Member get(String mid) {
		if(mid==null||"".equals(mid)) {
			return null;
		}
		return memberDAO.findById(mid);
	}

	@Override
	public Map<String, Set<String>> getRoleAndActionByMembers(String mid) {
		Map<String,Set<String>> map=new HashMap<>();
		if(mid==null||"".equals(mid)) {
			return null;
		}
		map.put("allRoles", roleDAO.findById(mid));
		map.put("allActions", actionDAO.findById(mid));
		return map;
	}

}
