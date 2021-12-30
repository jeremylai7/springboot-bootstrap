package com.springbootbootstrap.util;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @Author: laizc
 * @Date: Created in  2021-12-30
 * @desc:
 */
@Intercepts({
		@Signature(method = "query", type = Executor.class, args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class PageInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("intercept");
		return null;
	}

	@Override
	public Object plugin(Object o) {
		return Plugin.wrap(o,this);
	}

	@Override
	public void setProperties(Properties properties) {
		System.out.println("setproperties");
	}
}
