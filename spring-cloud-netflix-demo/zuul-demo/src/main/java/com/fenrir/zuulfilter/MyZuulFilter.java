package com.fenrir.zuulfilter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * zuul路由过滤配置
 * @author fenrir
 *
 */
@Component
public class MyZuulFilter extends ZuulFilter {

//	private static final Logger LOGGER = LoggerFactory.getLogger(MyZuulFilter.class);
	
	/**
	 * 配置当前过滤器类型，有四种不同生命周期的过滤器类型
	 * 1. pre：路由之前
	 * 2. routing：路由之时
	 * 3. post：路由之后
	 * 4. error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	
	/**
	 * 配置当前过滤器是否需开启
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	/**
	 * 配置当前过滤器的顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 当前过滤器的具体业务代码
	 */
	@Override
	public Object run() throws ZuulException {
//		RequestContext context = RequestContext.getCurrentContext();
//        HttpServletRequest request = context.getRequest();
//        LOGGER.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
//        String token = request.getParameter("token");
//        if (token == null) {
//            LOGGER.warn("Token is empty");
//            context.setSendZuulResponse(false);
//            context.setResponseStatusCode(401);
//            try {
//                context.getResponse().getWriter().write("Token is empty");
//            } catch (IOException e) {
//            }
//        } else {
//            LOGGER.info("OK");
//        }
        return null;
	}

}