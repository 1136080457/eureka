package ribbon_config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration   
public class ribbon_Configs {

	//使用何种策略，不要被springboot启动类扫描到就行(放在不同包下或者不要加在@ComponentScan注解中)
	
	@LoadBalanced
	@Bean
	public IRule myRule() {
		
		return new RandomRule(); //当前选择的一种策略(随机)
	}
}
