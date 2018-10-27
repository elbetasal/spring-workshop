package org.developer.elbetasal.examples.spel.rules.engine;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

@ComponentScan
@Configuration
public class CalculatorApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(CalculatorApp.class);
		applicationContext.refresh();

		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("add");

		EvaluationContext context = new StandardEvaluationContext(applicationContext.getBean(CalculatorService.class));
		Map<Object , Object> params = new HashMap<>();
		params.put("first" , 1d);
		params.put("second" , 2d);
		context.setVariable("params" , params);

		applicationContext.registerShutdownHook();
	}
}
