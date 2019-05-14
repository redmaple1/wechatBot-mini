package com.wechat.remindBot;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemindBotApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	@Ignore
	public void testLearnCloud() throws AVException {
		AVObject testObject = new AVObject("TestObject");
		testObject.put("words","Hello World!");
		testObject.save();
	}

}
