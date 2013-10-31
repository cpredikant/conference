package com.prodyna.pac.conference.service.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

@Logging
@Interceptor
public class LoggingInterceptor {

	@Inject
	Logger logger;


	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		long start = System.currentTimeMillis();
		
		Object proceed = ic.proceed();
		
		long end = System.currentTimeMillis();
		
		logger.info("SERVICE CALL on CLASS: "
				+ ic.getTarget().getClass().getSimpleName() + " METHOD: "
				+ ic.getMethod().getName() + " DURATION: " + (end - start)
				+ "ms");

		return proceed;
	}

}
