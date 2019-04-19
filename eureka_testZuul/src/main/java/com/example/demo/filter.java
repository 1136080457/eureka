package com.example.demo;

import java.io.IOException;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class filter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// 是否需要执行该过滤器
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 所需要执行过滤的具体操作
		RequestContext rc = RequestContext.getCurrentContext();
		rc.setResponseStatusCode(200);
		
		try {
			rc.getResponse().sendRedirect("http://127.0.0.1:1111/findall");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String filterType() {
		// 过滤器类型
		return "pre";
	}

	@Override
	public int filterOrder() {
		// 执行顺序
		return 0;
	}

}
