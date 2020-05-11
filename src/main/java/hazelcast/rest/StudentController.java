package hazelcast.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.HazelcastInstance;

@RestController
public class StudentController {

	@Autowired
	//static
	HazelcastInstance hazelcastInstance;
	
	@PostMapping(value = "/students")
	public String addstudent(@RequestBody  String student) {
	Map<Integer, String> studentsMap = hazelcastInstance.getMap("students");
				 studentsMap.put(2000, student+30000);
				
				 return "ajouter ...." ; 
	
	}
	
	
}
