package hazelcast.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
public class hazelcastbean {

	  @Bean
	    public HazelcastInstance hazelcastInstance() {

			Config config=new Config();
			ManagementCenterConfig centerConfig=new ManagementCenterConfig();	
			centerConfig.setEnabled(true);
			centerConfig.setUrl("http://localhost:8080/hazelcast-mancenter");
			config.setManagementCenterConfig(centerConfig);
					 return  Hazelcast.newHazelcastInstance(config);
			
	    }
}
