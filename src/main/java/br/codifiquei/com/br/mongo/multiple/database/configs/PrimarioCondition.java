package br.codifiquei.com.br.mongo.multiple.database.configs;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PrimarioCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String[] profiles = conditionContext.getEnvironment().getActiveProfiles();
        boolean cond = profiles.length > 0 &&  profiles[0].equals("test");
        return !cond;
    }
}
