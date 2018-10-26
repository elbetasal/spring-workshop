package org.developer.elbetasal.examples.spel.collections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@Configuration
@ComponentScan
public class CollectionsApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(CollectionsApp.class);
		applicationContext.refresh();
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("employeeHours['maria']");

		EvaluationContext evaluationContext =
				new StandardEvaluationContext(applicationContext.getBean(EmployeService.class));
		System.out.println(expression.getValue(evaluationContext));

		applicationContext.registerShutdownHook();
	}
}
