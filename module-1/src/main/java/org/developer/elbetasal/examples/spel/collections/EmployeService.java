package org.developer.elbetasal.examples.spel.collections;

import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@Getter
public class EmployeService {

	private Map<String , Integer> employeeHours;

	@PostConstruct
	public void init(){
		employeeHours = new HashMap<>();
		employeeHours.putIfAbsent("lidia" , 40);
		employeeHours.putIfAbsent("luis" , 43);
		employeeHours.putIfAbsent("paco" , 41);
		employeeHours.putIfAbsent("pancho" , 42);
		employeeHours.putIfAbsent("maria" , 44);

	}

}
