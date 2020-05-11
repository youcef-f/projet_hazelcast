package hazelcast;

import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@SpringBootApplication
public class MemberHazelCast {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MemberHazelCast.class, args);
	}

	@Bean
	CommandLineRunner start(HazelcastInstance hazelcastInstance) {

		return args -> {
	
		/*
		 * Config config=new Config(); ManagementCenterConfig centerConfig=new
		 * ManagementCenterConfig(); centerConfig.setEnabled(true);
		 * centerConfig.setUrl("http://localhost:8080/hazelcast-mancenter");
		 * config.setManagementCenterConfig(centerConfig);
		 * 
		 * HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
		 */

		// Creer une map distribué sur les server hazelcast
		Map<Integer, String> studentsMap = hazelcastInstance.getMap("students");

		for (int i = 0; i < 10000; i++) {

			studentsMap.put(i, "Ahmed" + i);
		}

		System.out.println("----------MAP--------------------");
		System.out.println("First student: " + studentsMap.get(1));
		System.out.println(studentsMap.size());

		// Creer une queue distribué sur les server hazelcast
		Queue<String> studentsQueue = hazelcastInstance.getQueue("students");
		studentsQueue.offer("Ahmed");
			studentsQueue.offer("Youcef");
		studentsQueue.offer("Mohamed");

		System.out.println("--------QUEUE------------------");

		System.out.println("first element: " + studentsQueue.poll());
		System.out.println(studentsQueue.size());
	};
	

}
	
}
