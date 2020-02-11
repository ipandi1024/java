================================================
MQ��������Ʒ��
	ActiveMQ: Apache��JMS��Ϣ��������

	Kafka:�ֲ�ʽ����������Ϣϵͳ��

================================================
һ�� RabbitMQ�İ�װ
1��Erlang�İ�װ
���ز�����Erlang for Windows ��װ�������ص�ַhttp://www.erlang.org/downloads

2��RabbitMQ��װ����
����RabbitMQ��װ�������ص�ַhttp://www.rabbitmq.com/install-windows.html��

3���Զ��廷������
�÷���ʹ����Ĭ�������������С�������Զ���RabbitMQ������༭���á� 
��1��erl������������

	ERLANG_HOME=C:\Program Files\erl10.3

	��Path�м���

	%ERLANG_HOME%\bin;

	����erl�����Ƿ���ȷ����ʼ-����-cmd������erl

��2��RabbitMQ������������ 
	RABBITMQ_SERVER=C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.14

	��Path�м���

	%RABBITMQ_SERVER%\sbin;

4������rabbitmq_management
	��CMD�м�����������

	"C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.14\sbin\rabbitmq-plugins.bat" enable rabbitmq_management

5������RabbitMQ����
	ֱ���������н��������������

	net start RabbitMQ

	�ر�RabbitMQ�����������£�

	net stop RabbitMQ

����RabbitMQ����
	localhost:15672����RabbitMQ�ĺ�̨����ҳ��(��ʼ���û��������붼��guest)

����������
	https://www.rabbitmq.com/getstarted.html
	https://www.rabbitmq.com/tutorials/tutorial-one-java.html

1:������Ϣ
	�������룺
	package com.woniu;

	import com.rabbitmq.client.Channel;
	import com.rabbitmq.client.Connection;
	import com.rabbitmq.client.ConnectionFactory;

	public class Test {
		private final static String QUEUE_NAME = "Hello";
		
		public static void main(String[] args) throws Exception {
			 // connection��socket���ӵĳ��󣬲���Ϊ���ǹ���Э��汾Э�̣�protocol version negotiation����
		// ��֤��authentication ���ȵ����顣��������Ҫ���ӵ���Ϣ�����ڱ��أ�������ǽ�host��Ϊ��localhost����
		// ����������������������ϵĴ���ֻ��Ҫ�������Ϊ�ض�����������IP��ַ��
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672); //Ĭ�϶˿ں�
		factory.setUsername("guest");//Ĭ���û���
		factory.setPassword("guest");//Ĭ������
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// �����������Ǵ���һ��channel�����󲿷�API������Ҫͨ������������ɡ�
		// ����֮ǰ�����Ǳ���������ϢҪ�����ĸ����У�Ȼ�����ǿ�������з�һ����Ϣ��
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello world";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		channel.close();
		connection.close();

		}
	}
2:������Ϣ����
	import com.rabbitmq.client.ConnectionFactory;
	import com.rabbitmq.client.Connection;
	import java.io.IOException;
	import org.junit.Test;
	import com.rabbitmq.client.AMQP;
	import com.rabbitmq.client.Channel;
	import com.rabbitmq.client.Consumer;
	import com.rabbitmq.client.DefaultConsumer;
	import com.rabbitmq.client.Envelope;

	public class RecvMQ {
	    private final static String QUEUE_NAME = "Hello";

	    public static void main(String[] args) throws IOException, Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		Consumer consumer = new DefaultConsumer(channel) {
		    @Override
		    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
			    byte[] body) throws IOException {
			String message = new String(body, "UTF-8");
			System.out.println(" [x] Received '" + message + "'");
		    }
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	    }

	}
============================
��������

���ǽ�����һ���������У������ڶ��������Ա֮������ʱ������
�������У��ֳƣ�������У��������Ҫ˼���Ǳ�������ִ����Դ�ܼ������񣬲��ұ���ȴ�����ɡ�
�෴�����ǰ��������Ժ���ɡ����ǽ������װ Ϊ��Ϣ�����䷢�͵����С�
�ں�̨���еĹ������̽�������������ִ����ҵ������������๤������ʱ������֮�佫��������

ѭ������
ʹ��������е�һ���ŵ����ܹ����ɵز��й���������������ڻ�ѹ������ѹ�����ǿ�����Ӹ��๤�ˣ������Ϳ���������չ��

���ȣ������ǳ���ͬʱ��������workerʵ�������Ƕ���Ӷ����л�ȡ��Ϣ������������أ���������������

����Ҫ����������̨�����������й���������Щ��Ϸ������Ϊ���ǵ����������� - C1��C2��

Ĭ������£�RabbitMQ����˳��ÿ����Ϣ���͸���һ�������ߡ�ƽ�����ԣ�ÿ�������߽������ͬ��������Ϣ�����ַַ���Ϣ�ķ�ʽ��Ϊѭ������


�����ߴ������ǰһ����������Ҳһ�������ǽ�������������������������ϵ�£�
һ��RabbitMQ�������߷�����Ϣ��������������Ϊɾ��������������£������ɱ��һ�����ˣ����ǽ���ʧ���ոմ������Ϣ�����ǻ�����ʧ�ַ�������ض������ߵ���δ�����������Ϣ��

�����ǲ���ʧȥ�κ����������������������ϣ�������񽻸�����һ�����ˡ�
RabbitMQ֧�� ��Ϣȷ�ϡ������߷���ack��nowledgement������RabbitMQ���յ����������ض���Ϣ��RabbitMQ��������ɾ������

�����������������ͨ���رգ����ӹرջ�TCP���Ӷ�ʧ����������ȷ�ϣ�
RabbitMQ�������Ϣδ��ȫ�����������Ŷӡ����ͬʱ���������������ߣ�
���Ѹ�ٽ������·��͸����������ߡ�������Ϳ���ȷ��û����Ϣ��ʧ����ʹ����ż����������

Ĭ������£��ֶ���Ϣȷ���Ѵ򿪡���ǰ���ʾ���У�����ͨ��autoAck = true ��־��ȷ�ؽ����ǹرա�һ������������񣬾�Ӧ�ý��˱�־����Ϊfalse���ӹ�����Ա������ȷ��ȷ�ϡ�


channel.basicQos��1��; //һ��ֻ����һ��δ��װ����Ϣ

boolean autoAck = false ;
channel.basicConsume��TASK_QUEUE_NAME��autoAck��deliverCallback��consumerTag  - > {}��;

ȷ����ʹ���ڴ�����Ϣʱʹ��CTRL + Cɱ��һ��������Ա��Ҳ���ᶪʧ�κ����ݡ��������󲻾ã�����δ��ȷ�ϵ���Ϣ�������´��ݡ�

*****����δ��ȷ�ϵ���Ϣ�����ͻ����˳�ʱ���ᱻ���´��ݡ�������Ϣ��������ء�
�ڴ�ռ�û�Խ�����ࡣ���Ա����ֹ�����Ӧ��channel.basicAck(envelope.getDeliveryTag(), false);

�����ֹ�ȷ�ϵ���Ϣ����������٣�δ�����ֹ�ȷ�ϵ���Ϣ����������ء�
ȷ����Ϣ���ᶪʧ��

================
��Ϣ�־���

boolean durable = true ;
channel.queueDeclare����hello����durable��false��false��null��;
��ɶ��г־��ԡ�

��Ϣ�־���
	channel.basicPublish����������task_queue����
            MessageProperties.PERSISTENT_TEXT_PLAIN��
            message.getBytes������;

���ǣ�
	RabbitMQ������Ϣ����δ������Ϣ��ʱ����Ȼ��һ��ʱ�䣬����ֻ�Ƿ��뻺��
	��δ������̣�������Ȼδ��ɳ־��ԡ�
	������ͨ��������Ѿ��㹻�������Ҫ��ǿ�ı�֤������ʹ�á�������ȷ�ϡ���

==============
��ƽ��ǲ

��ʱ��ᷢ��æ��æ�����е���������RabbitMQ�Դ�һ����֪����Ȼ����ȵط�����Ϣ��
ԭ����RabbitMQֻ������Ϣ�������ʱ������Ϣ������鿴������δȷ����Ϣ������ֻ��äĿ�İ��մ�������Ϣ��

���������
	ʹ�� basicQos������  prefetchCount = 1����
	basicQos����:
		ָ���������ڽ��յ����������Ϣ��û�з���ȷ�Ͻ��֮ǰ,�����Ὣ�µ���Ϣ�ַ�������

1:�ԱȲ��ԣ����������߶�����ͬһ���У�no_ack������Ϊfalse������acknowledge���ƣ�
	�Ҿ�δ����prefetch_count������з���5����Ϣ

�����������Ϣ�Ƿ�ack��rabbitmq������������������Ͷ����Ϣ��
	��һ���������յ�"1"��"3"��"5"������Ϣ�� �ڶ����������յ�"2"��"4"������Ϣ��

2��prefetch_count���ò��ԣ����������߶�����ͬһ���У�
	����acknowledge���ƣ���һ��������prefetch_count����Ϊ1��
	��һ��������δ����prefetch_count��ͬ������з���5����Ϣ

�����rabbitmq���һ��������Ͷ����һ����Ϣ��
	������δ�Ը���Ϣ����ack��rabbitmq���������������Ͷ����Ϣ��ʣ�µ�������Ϣ��Ͷ�ݸ��˵ڶ���������


����������ɾ��
���ȶ�λ�� rabbitMQ ��װĿ¼��sbin Ŀ¼�¡���cmd���ڡ�


�ر�Ӧ�õ�����Ϊ�� rabbitmqctl stop_app

���������Ϊ�� rabbitmqctl reset

������������Ϊ�� rabbitmqctl start_app
ps

�鿴���ж������ rabbitmqctl list_queues
