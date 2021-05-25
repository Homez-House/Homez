package com.ssafy.homez.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssafy.homez.dto.MemberDto;

// async only
// ajax 요청과 page 요청을 모두 처리하는 방식은 cors 문제 발생
@Component
public class LoginInterceptor implements HandlerInterceptor{
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println(">>>>> " + request.getRequestURI());
        HttpSession session = request.getSession();
        MemberDto userDto = (MemberDto) session.getAttribute("memberDto");
        if( userDto == null ) {
        	
			Gson gson = new Gson();

			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("result", "login");
			
			String jsonStr = gson.toJson(jsonObject);
			response.getWriter().write(jsonStr);
			
        	return false;
        }

        return true;
    }
}
