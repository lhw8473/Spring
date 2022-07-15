package com.spring.pr.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.spring.pr.command.UserVO;

public class UserLoginSuccessHandler implements HandlerInterceptor{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("�α��� ���ͼ��� ����.");
		ModelMap mv = modelAndView.getModelMap();
		UserVO vo = (UserVO)mv.get("user");
		System.out.println("interceptor vo:" + vo);
		
		//��Ʈ�ѷ����� �α����� ������ ���!
		if(vo != null) {
			System.out.println("�α��� ���� ���� ����.");
			//���� �����͸� �����Ͽ� �α��� ������ �ϰ� �� ��.
			HttpSession session = request.getSession();
			session.setAttribute("login", vo);
			response.sendRedirect(request.getContextPath());
		}
		else {
			modelAndView.addObject("msg", "loginFail");
			modelAndView.setViewName("/user/userLogin");
		}
		
	}
}
