package com.woniu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.jcajce.provider.asymmetric.RSA;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyZuulFilter extends ZuulFilter{
	private List<String> ips = new ArrayList<String>();//应该来自于数据库
	
	public MyZuulFilter() {
		ips.add("192.168.9.60");
		ips.add("192.168.9.8");
		ips.add("192.168.9.22");
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		//是否执行这个过滤器
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		System.out.println("进入过滤器了");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		//当前过滤器的类型  类型总共只有四个  pre routing post error
		//pre代表当前过滤器在你的行为执行之前执行这个过滤器
		//ip黑名单 
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		String ip = request.getRemoteHost();
		System.out.println("当前ip为 "+ip);
		if(ips.contains(ip)) {//非法请求，不会把请求发送给提供者，而是选择代码从当前节点直接中断
			rc.setSendZuulResponse(false);//不会把请求发送给提供者，而是选择代码从当前节点直接中断
			rc.setResponseBody("您的ip已经被锁定了，警察正在来的路上");
			rc.getResponse().setContentType("text/html;charset=UTF-8");
		}
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		//当前过滤器的执行顺序  这个号码越大  越后执行 在项目 中可以有n个过滤器
		return 0;
	}

}
