package org.developer.elbetasal.examples.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(RunOnlyOnLinuxCondition.class)
public class WindowsReader implements Reader{

	public WindowsReader() {
		System.out.println("Hello Windows");
	}

	@Override
	public void sayHello() {
		System.out.println("Say hello from windows");
	}
}
