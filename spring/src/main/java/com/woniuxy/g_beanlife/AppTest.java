package com.woniuxy.g_beanlife;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 bean���������ڣ�
 1. ���ڳ����д���spring ioc������ʱ�� spring ioc�����ͻ�ȥ����spring���������ļ���������ClassPathXmlApplicationContext���������أ�
 2. ��spring ioc�����ڼ���spring�����õ�ʱ�򣬾ͻᷢ��bean������
 3. ��spring ioc��������һbean��ʱ�򣬾͵��ø�bean���޲ι������� Ҳ����ʵ�����������Ҫ��bean�������������һ���޲ι�������
 4. ��spring ioc����ʵ������һ��bean֮�󣬾ͻ�������ԣ�Ҳ���ǵ��ö����setter������
 5. ��spring ioc��������������֮�󣬾ͻ��ж�bean�������࣬�Ƿ�ʵ����BeanNameAware�ӿ�
 		���ʵ����BeanNameAware�ӿڣ��ͻ���øýṹ��setBeanName����
 		���ûʵ��BeanNameAware�ӿڣ���ֱ�ӽ�����һ��
 6. �ж�bean�������࣬��û��ʵ��BeanFactoryAware�ӿ�
 		���ʵ����BeanFactoryAware�ӿڣ��ͻ���øýӿڵ�setBeanFactory����
 		���ûʵ��BeanFactoryAware�ӿڣ���ֱ�ӽ�����һ��
 7. �ж�bean�������࣬��û��ʵ��ApplicationContextAware�ӿ�
 	 	���ʵ����ApplicationContextAware�ӿڣ��ͻ���øýṹ��setApplicationContex����
 		���ûʵ��ApplicationContextAware�ӿڣ���ֱ�ӽ�����һ��
 8. �ж�����bean�Ƿ�ʵ����BeanPostProcessor�ӿ�
 		�������beanʵ����BeanPostProcessor�ӿڣ��ͻ��������bean�� postProcessBeforeInitialization ���� ��ע�⣬spring ioc������������������ν�ġ�����bean����
 		���ûʵ��BeanPostProcessor�ӿڣ���ֱ�ӽ�����һ��
 9. �ж�bean�������࣬�Ƿ�ʵ����InitializingBean�ӿ�
 		���ʵ����InitializingBean�ӿڣ��ͻ���øý�ŷ���afterPropertiesSet����
 		���ûʵ��InitializingBean�ӿڣ���ֱ�ӽ�����һ��
 10. �ж���spring���������ļ��У��Ƿ���beanԪ����������init-method����
 		��������ˣ������init-method������ָ���ķ���
 		���û���ã���ֱ�ӽ�����һ��
 11. �ж�����bean�Ƿ�ʵ����BeanPostProcessor�ӿ�
 		�������beanʵ����BeanPostProcessor�ӿڣ��ͻ��������bean�� postProcessAfterInitialization ���� ��ע�⣬spring ioc������������������ν�ġ�����bean����
 		���ûʵ��BeanPostProcessor�ӿڣ���ֱ�ӽ�����һ��
 		
 12. ��ʱ��bean�Ѿ�����spring ioc�������ˣ� �ͻ��˾Ϳ��Դ�spring ioc�����л�ȡbean��bean�Ϳ���ʹ���ˣ�����
 
 13. �����ǹر�Spring ioc������ʱ�� �ж�bean�������࣬�Ƿ�ʵ����DisposableBean�ӿ�
 		���ʵ����DisposableBean�ӿڣ��ͻ���øý�ŷ���destroy����
 		���ûʵ��DisposableBean�ӿڣ���ֱ�ӽ�����һ��
 14. �����ǹر�Spring ioc������ʱ��spring ioc�����ж�bean�������У��Ƿ�������destroy-method����
 		��������ˣ������destroy-method������ָ���ķ���
 		���û���ã������ˡ�
*/

public class AppTest {
	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext ctx = //
				new ClassPathXmlApplicationContext("com/woniuxy/g_beanlife/applicationContext.xml");
		
//		Resource r = new ClassPathResource("com/woniuxy/g_beanlife/applicationContext.xml");
//		XmlBeanFactory bf = new XmlBeanFactory(r);
//		System.out.println("=================================");
//		Foo f  = (Foo) bf.getBean("f");
//		bf.addBeanPostProcessor(f);
//		bf.getBean("u");
		
		Object u  =  ctx.getBean("u");
		System.out.println(u.getClass());
//		u.eat();
		
//		ctx.close();
	}
}
