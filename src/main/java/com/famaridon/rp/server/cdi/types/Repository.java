package com.famaridon.rp.server.cdi.types;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by famaridon on 17/11/2016.
 */
@Qualifier
@ApplicationScoped
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE })
public @interface Repository
{
}
