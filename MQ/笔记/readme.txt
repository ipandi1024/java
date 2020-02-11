================================================
MQ的其他产品：
	ActiveMQ: Apache的JMS消息服务器。

	Kafka:分布式发布订阅消息系统。

================================================
一： RabbitMQ的安装
1、Erlang的安装
下载并运行Erlang for Windows 安装程序。下载地址http://www.erlang.org/downloads

2、RabbitMQ安装程序
运行RabbitMQ安装程序（下载地址http://www.rabbitmq.com/install-windows.html）

3、自定义环境变量
该服务将使用其默认设置正常运行。你可以自定义RabbitMQ环境或编辑配置。 
（1）erl环境变量配置

	ERLANG_HOME=C:\Program Files\erl10.3

	在Path中加入

	%ERLANG_HOME%\bin;

	测试erl配置是否正确，开始-运行-cmd，输入erl

（2）RabbitMQ环境变量配置 
	RABBITMQ_SERVER=C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.14

	在Path中加入

	%RABBITMQ_SERVER%\sbin;

4、激活rabbitmq_management
	在CMD中键入如下命令

	"C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.14\sbin\rabbitmq-plugins.bat" enable rabbitmq_management

5、启动RabbitMQ服务
	直接在命令行界面键入如下命令

	net start RabbitMQ

	关闭RabbitMQ服务命令如下：

	net stop RabbitMQ

二、RabbitMQ测试
	localhost:15672访问RabbitMQ的后台管理页面(初始化用户名和密码都是guest)

三、开发：
	https://www.rabbitmq.com/getstarted.html
	https://www.rabbitmq.com/tutorials/tutorial-one-java.html

1:发送消息
	官网代码：
	package com.woniu;

	import com.rabbitmq.client.Channel;
	import com.rabbitmq.client.Connection;
	import com.rabbitmq.client.ConnectionFactory;

	public class Test {
		private final static String QUEUE_NAME = "Hello";
		
		public static void main(String[] args) throws Exception {
			 // connection是socket连接的抽象，并且为我们管理协议版本协商（protocol version negotiation），
		// 认证（authentication ）等等事情。这里我们要连接的消息代理在本地，因此我们将host设为“localhost”。
		// 如果我们想连接其他机器上的代理，只需要将这里改为特定的主机名或IP地址。
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672); //默认端口号
		factory.setUsername("guest");//默认用户名
		factory.setPassword("guest");//默认密码
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// 接下来，我们创建一个channel，绝大部分API方法需要通过调用它来完成。
		// 发送之前，我们必须声明消息要发往哪个队列，然后我们可以向队列发一条消息：
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello world";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		channel.close();
		connection.close();

		}
	}
2:处理消息队列
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
工作队列

我们将创建一个工作队列，用于在多个工作人员之间分配耗时的任务。
工作队列（又称：任务队列）背后的主要思想是避免立即执行资源密集型任务，并且必须等待它完成。
相反，我们安排任务稍后完成。我们将任务封装 为消息并将其发送到队列。
在后台运行的工作进程将弹出任务并最终执行作业。当您运行许多工作程序时，它们之间将共享任务。

循环调度
使用任务队列的一个优点是能够轻松地并行工作。如果我们正在积压工作积压，我们可以添加更多工人，这样就可以轻松扩展。

首先，让我们尝试同时运行两个worker实例。他们都会从队列中获取消息，但究竟如何呢？让我们来看看。

你需要打开三个控制台。两个将运行工作程序。这些游戏机将成为我们的两个消费者 - C1和C2。

默认情况下，RabbitMQ将按顺序将每条消息发送给下一个消费者。平均而言，每个消费者将获得相同数量的消息。这种分发消息的方式称为循环法。


发送者代码跟以前一样。接受者也一样。但是接受者启动了两个。在这种体系下：
一旦RabbitMQ向消费者发送消息，它立即将其标记为删除。在这种情况下，如果你杀死一个工人，我们将丢失它刚刚处理的消息。我们还将丢失分发给这个特定工作者但尚未处理的所有消息。

但我们不想失去任何任务。如果工人死亡，我们希望将任务交付给另一名工人。
RabbitMQ支持 消息确认。消费者发回ack（nowledgement）告诉RabbitMQ已收到，处理了特定消息，RabbitMQ可以自由删除它。

如果消费者死亡（其通道关闭，连接关闭或TCP连接丢失）而不发送确认，
RabbitMQ将理解消息未完全处理并将重新排队。如果同时有其他在线消费者，
则会迅速将其重新发送给其他消费者。这样你就可以确保没有消息丢失，即使工人偶尔会死亡。

默认情况下，手动消息确认已打开。在前面的示例中，我们通过autoAck = true 标志明确地将它们关闭。一旦我们完成任务，就应该将此标志设置为false并从工作人员发送正确的确认。


channel.basicQos（1）; //一次只接受一条未包装的消息

boolean autoAck = false ;
channel.basicConsume（TASK_QUEUE_NAME，autoAck，deliverCallback，consumerTag  - > {}）;

确定即使您在处理消息时使用CTRL + C杀死一名工作人员，也不会丢失任何内容。工人死后不久，所有未经确认的消息将被重新传递。

*****但是未经确认的消息，当客户端退出时，会被重新传递。这样消息会重新入池。
内存占用会越来愈多。所以必须手工进行应答。channel.basicAck(envelope.getDeliveryTag(), false);

经过手工确认的消息，会进行销毁，未进行手工确认的消息，会重新入池。
确保消息不会丢失。

================
消息持久性

boolean durable = true ;
channel.queueDeclare（“hello”，durable，false，false，null）;
完成队列持久性。

消息持久性
	channel.basicPublish（“”，“task_queue”，
            MessageProperties.PERSISTENT_TEXT_PLAIN，
            message.getBytes（））;

但是：
	RabbitMQ接受消息，但未保存消息的时候，仍然有一段时间，可能只是放入缓存
	而未存入磁盘，可能仍然未完成持久性。
	对于普通任务队列已经足够，如果需要更强的保证，可以使用【发布者确认】。

==============
公平派遣

有时候会发生忙的忙死，闲的闲死。但RabbitMQ对此一无所知，仍然会均匀地发送消息。
原因是RabbitMQ只是在消息进入队列时调度消息，不会查看消费者未确认消息数量。只是盲目的按照次序发送消息。

解决方案：
	使用 basicQos方法和  prefetchCount = 1设置
	basicQos方法:
		指该消费者在接收到队列里的消息但没有返回确认结果之前,它不会将新的消息分发给它。

1:对比测试：两个消费者都订阅同一队列，no_ack均设置为false即开启acknowledge机制，
	且均未设置prefetch_count，向队列发布5条消息

结果：不管消息是否被ack，rabbitmq会轮流向两个消费者投递消息，
	第一个消费者收到"1"，"3"，"5"三条消息， 第二个消费者收到"2"，"4"两条消息。

2）prefetch_count设置测试：两个消费者都订阅同一队列，
	开启acknowledge机制，第一个消费者prefetch_count设置为1，
	另一个消费者未设置prefetch_count，同样向队列发布5条消息

结果：rabbitmq向第一个消费者投递了一条消息后，
	消费者未对该消息进行ack，rabbitmq不会再向该消费者投递消息，剩下的四条消息均投递给了第二个消费者


命令行批量删除
首先定位到 rabbitMQ 安装目录的sbin 目录下。打开cmd窗口。


关闭应用的命令为： rabbitmqctl stop_app

清除的命令为： rabbitmqctl reset

重新启动命令为： rabbitmqctl start_app
ps

查看所有队列命令： rabbitmqctl list_queues
