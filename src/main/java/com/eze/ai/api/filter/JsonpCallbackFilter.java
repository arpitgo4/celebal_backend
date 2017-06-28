package com.eze.ai.api.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class JsonpCallbackFilter implements Filter {

	private static Logger log = Logger.getLogger(JsonpCallbackFilter.class);

	public void init(FilterConfig fConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Map<String, String[]> parms = httpRequest.getParameterMap();
		if(parms.containsKey("callback")) {
			log.info("Wrapping response with JSONP callback '" + parms.get("callback")[0] + "'");
			OutputStream out = httpResponse.getOutputStream();
			GenericResponseWrapper wrapper = new GenericResponseWrapper(httpResponse);
			chain.doFilter(request, wrapper);
			out.write(new String(parms.get("callback")[0] + "(").getBytes());
			out.write(wrapper.getData());
			if(parms.containsKey("parentData")) {
				log.info("Wrapping response with JSONP parent data '" + parms.get("parentData")[0] + "'");
				out.write(new String(","+parms.get("parentData")[0]).getBytes());
			}
			out.write(new String(");").getBytes());
			wrapper.setContentType("text/javascript;charset=UTF-8");
			out.close();
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {}
}