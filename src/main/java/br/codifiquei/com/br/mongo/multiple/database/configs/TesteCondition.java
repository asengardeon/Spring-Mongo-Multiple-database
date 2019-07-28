package br.codifiquei.com.br.mongo.multiple.database.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TesteCondition implements Condition {

    @Autowired
    private Environment env;

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean cond = Boolean.parseBoolean(conditionContext.getEnvironment().getProperty("spring.data.isTest", "False"));
        return cond;
    }
}
