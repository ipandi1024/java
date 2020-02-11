package buy18;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		new Test().buy();
	}
	
	public void buy() throws InterruptedException {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		while (true) {
			System.out.println("Ö´ĞĞÒ»´Î");
			jedis.set("age","1");//set age 1
			jedis.watch("age");//watch age
			
			Thread.sleep(5000);
			
			Transaction tx= jedis.multi();//	multi
			tx.set("age", "2");//incr age
			List list = tx.exec();
			if(list!=null&&list.size()>0) {
				break;
			}
		}
		System.out.println(jedis.get("age"));
	}
}
