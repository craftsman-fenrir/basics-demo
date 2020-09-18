package com.fenrir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.netflix.loadbalancer.RandomRule;

/**
 * application - spring boot启动类
 * @SpringBootApplication - spring boot启动配置
 * @EnableEurekaClient - eureka配置，把该服务配置为eureka注册中心的客户端
 * @EnableHystrix - hystrix配置，开启熔断功能
 * @EnableHystrixDashboard - hystrix dashboard配置，开启hystrix dashboard，默认路径/hystrix
 * @RibbonClient - ribbon核心配置，可选，定义均衡负载的规则（默认ZoneAvoidanceRule）和微服务名字（不写用从配置获取默认名）
 * RoundRobinRule 轮询
 * RandomRule 随机
 * AvailabilityFilteringRule 会优先选择比较健康的微服务（短路或连接数量过多的会少访问）
 * WeightedResponseTimeRule 根据响应时间来决定优先级
 * RetryRule 先轮询，获取失败时会在指定时间内重试，多次失败则不会再获取该服务
 * BestAvailableRule 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
 * ZoneAvoidanceRule 默认规则，复合判断Server所在区域的性能和Server的可用性选择服务器
 * @author fenrir
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@RibbonClient(value = "RIBBON-HYSTRIX-DEMO", configuration = RandomRule.class)
public class RibbonHystrixDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonHystrixDemoApplication.class, args);
	}

}