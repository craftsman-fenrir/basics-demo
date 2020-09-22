package com.fenrir.hystrix;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fenrir.entity.BasicListResponseGenericityVO;
import com.fenrir.entity.BasicResponseGenericityVO;
import com.fenrir.entity.DataVO;
import com.fenrir.service.DiscoveryService;

/**
 * feign的hystrix配置
 * @Component spring配置，把该class设置为spring的组件（不是bean，所以不会放到bean容器）
 * @author fenrir
 *
 */
@Component
public class DiscoveryHystrix implements DiscoveryService {

	@Override
	public BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> discovery() {
		BasicResponseGenericityVO<BasicListResponseGenericityVO<DataVO>> basicResponseGenericity = new BasicResponseGenericityVO<>();
		basicResponseGenericity.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		basicResponseGenericity.setMessage("feign hystrix demo调用第三方微服务时出现了异常并且熔断了");
		return basicResponseGenericity;
	}
	
}