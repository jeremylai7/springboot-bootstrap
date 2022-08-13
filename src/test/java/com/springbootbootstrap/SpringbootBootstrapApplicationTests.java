package com.springbootbootstrap;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootBootstrapApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		String url = "https://api.beijinxuetang.com/api/common/ip";
		Ip ip = new Ip();
		ip.setIp("39.144.169.99");
		JSONObject json = restTemplate.postForObject(url,ip, JSONObject.class);
		System.out.println(json);
	}

	class Ip {
		private String ip;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}
	}

}
