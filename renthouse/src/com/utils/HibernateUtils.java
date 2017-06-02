package com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


/**
 * Hibernate框架的工具类
 * @author Administrator
 */
public class HibernateUtils {
	
	// ctrl + shift + x
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	
	// 编写静态代码块
	static{
		// 加载XML的配置文件
		CONFIG = new Configuration().configure();
		// 构造工厂
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	/**
	 * 从工厂中获取Session对象
	 * @return
	 */
	public static Session getSession(){
		return FACTORY.openSession();
	}
	
	/**
	 * 从ThreadLocal类中获取到session的对象
	 *  需要在hibernate.cfg.xml的配置文件中提供配置: <property name="hibernate.current_session_context_class">thread</property>
	 * @return
	 */
	public static Session getCurrentSession(){
		return FACTORY.getCurrentSession();
	}
	
	
	/**
	 * 用配置好的文件在数据库生成表 (只要获取到session便会自动在数据库中生成所配置的所有实体对应表)
	 * 注：此处用main方法也一样
	 */
	@Test
	public void genegateTable() {
		getSession();
	}
	
}
