package org.developer.elbetasal.examples.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(RunOnlyOnLinuxCondition.class)
public class LinuxReader implements Reader {

	public LinuxReader() {
		System.out.println("Hello Linux");
	}

	@Override
	public void sayHello() {
		System.out.println("Hello from Linux");
	}
}
