package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {

	private MemberService memberService;
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService ;
		
	}
	private String getViewName(HttpServletRequest request) throws Exception{
		String contextPath =request.getContextPath();
		String uri =(String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri ==null || uri.trim().equals("")) {
			uri = request.getRequestURI();
			System.out.println(uri);
		}
		
		//http://localHOst:8080/member/listMember.do 로 요청시
		
		int begin = 0;
		if(!((contextPath == null)||("".equals(contextPath)))) {
			begin=contextPath.length();
			System.out.println("begin :"+begin);
		}
		int end;
		if(uri.indexOf(";")!=-1) {
			end=uri.indexOf(";");// 요청 uri에 ';'가 있을 경우';"문자 위치를 구함
		}else if(uri.indexOf("?")!=-1) {
			end=uri.indexOf("?");//요청 uri에 "?"가 있을 경우"?" 문자 위치를 구함
		}else {
			end=uri.length();
			System.out.println("uri :"+uri);
			System.out.println(uri.length());
		}
//		http://localhost:8080/member/listMember.do로 요청시 먼저 ".do"를 제거한
//		http://localhost:8080/member/listMember를 구한후,
//		'/' 위치를 구한후 , 그 뒤위 listMember를 구한다
		
		String fileName=uri.substring(begin,end);
		if(fileName.indexOf(".")!=-1) {
			fileName =fileName.substring(0,fileName.lastIndexOf("."));
//			요청명에서 역순으로 최초'.'의 위치를 구한후, '.do' 앞에까지의 문자열을 구함
		}
		if(fileName.lastIndexOf("/")!=-1) {
			fileName= fileName.substring(fileName.lastIndexOf("/"),fileName.length());
//			요청 명에서 역순으로 최초'/'의 위치를 구한후,'/'다음부터의 문자열을 구함
			System.out.println("fileName :"+fileName);
		}
		return fileName;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request ,HttpServletResponse response)
			throws Exception{
				System.out.println("시작1");
				String viewName =getViewName(request);
				List membersList = memberService.listMembers();
				ModelAndView mav = new ModelAndView(viewName);
				mav.addObject("membersList",membersList);
				return mav;
			}
			
	
	
	@Override
	public ModelAndView addMember(HttpServletRequest request ,HttpServletResponse response)
		throws Exception{
		request.setCharacterEncoding("utf-8");
		MemberVO  memberVO = new MemberVO();
		/*
		 String id =request.getParameter("id");
		 String pwd =request.getParameter("pwd");
		 String name =request.getParameter("name");
		 String email =request.getParameter("email");
		 memberVO.setId(id);
		 memberVO.setPwd(pwd);
		 memberVO.setName(name);
		 memberVO.setEmail(email); 
		 */
		System.out.println("시작2");
		bind(request,memberVO);
		int result = 0 ;
		result = memberService.addMember(memberVO);
		System.out.println("result :"+result);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	public ModelAndView removeMember(HttpServletRequest request ,HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("시작3");
		String id =request.getParameter("id");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	public ModelAndView form(HttpServletRequest request , HttpServletResponse response)
		throws Exception{
		String viewName = getViewName(request);
		System.out.println("시작4");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}


	
}
