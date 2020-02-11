package com.woniu.page;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

//拦截了StatementHandler类
@Intercepts(@Signature(type=StatementHandler.class,method="prepare",args= {Connection.class,Integer.class}))
public class PageInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		//首先取得当前环境中是否有RowBounds。
		//获取被拦截被代理的目标对象
		StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
		//在mybatis中，你的运行中的所有参数都放在 MetaObject中。需要先得到元对象的实例
		MetaObject metaObject =MetaObject.forObject(statementHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
		//你的执行的条件和参数都放在metaObject中，需要从metaObject中进行获取
		RowBounds rb = (RowBounds)metaObject.getValue("delegate.rowBounds");
		if(rb!=null&&!rb.equals(RowBounds.DEFAULT)) {
			//取得你原有的SQL语句 
			String boundSQL = metaObject.getValue("delegate.boundSql.sql").toString();
			int limit = rb.getLimit();
			int offset = rb.getOffset();
			
			//读取配置文件
		    Configuration configuration = (Configuration)metaObject.getValue("delegate.configuration");
		    String type = configuration.getVariables().getProperty("dialect");
		    
		    Dialect dialect = DialectFactory.create(type);
		    
			String pageSQL = dialect.getPageSql(boundSQL, offset, limit);
			//将新的分页SQL放入metaObject中
			metaObject.setValue("delegate.boundSql.sql",pageSQL);
			//如果此时运行 则物理分页和内存分页都会执行
			//还原成原始的不分页的值
			metaObject.setValue("delegate.rowBounds.limit",RowBounds.NO_ROW_LIMIT);
			metaObject.setValue("delegate.rowBounds.offset",RowBounds.NO_ROW_OFFSET);
			//此时metaObject中的RowBounds是默认的RowBounds
			//此时metaObject中的sql 是带分页的SQL了
			
		}
		Object obj = invocation.proceed();
		return obj;
	}

}
