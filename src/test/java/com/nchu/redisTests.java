package com.nchu;

import com.google.gson.Gson;
import com.nchu.domain.DO.Option;
import com.nchu.domain.DO.UserOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private Gson gson=new Gson();
	@Test
	public void save(){

		UserOption userOption=new UserOption();
		userOption.setGood(1);

		Map<Long,UserOption>  questionIdAndUserOption=new HashMap<>();
		questionIdAndUserOption.put(1L,userOption);

		UserOption userOption1=new UserOption();
		userOption1.setBad(1);

		questionIdAndUserOption.put(2L,userOption1);

		UserOption userOption3=new UserOption();
		userOption3.setBad(1);

		questionIdAndUserOption.put(3L,userOption3);


		Option option=new Option();
		option.setUserOptionMap(questionIdAndUserOption);

		String object=gson.toJson(option);

		stringRedisTemplate.opsForValue().set("zzp",object);

		String reobj=stringRedisTemplate.opsForValue().get("zzp");
		System.out.println("获取的序列化对象"+reobj);
		Option map=gson.fromJson(reobj, Option.class);

		System.out.println("反序列化之后的值点赞值"+map.getUserOptionMap().get(1L).getGood());



	}
}
