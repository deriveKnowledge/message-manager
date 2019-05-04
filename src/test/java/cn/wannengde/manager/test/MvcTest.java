package cn.wannengde.manager.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import cn.wannengde.manager.bean.Msg;

/*
 * 使用Spring测试模块提供的测试请求功能，测试curd请求的正确性
 * Spring4测试的时候，需要servlet3.0的支持
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:springMVC.xml"})
public class MvcTest {
		
		//传入Springmvc的ioc
		@Autowired
		WebApplicationContext context;
		//虚拟mvc请求，获取到处理结果
		MockMvc mockMvc;
		
		@Before
		public void initMockMvc() {
			mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		}
		
		@Test
		public void testPage() throws Exception {
			//模拟请求拿到返回值
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/thingQueryALL").param("userId","1"))	
					.andReturn();
			//请求成功后，请求域中会有pageInfo，我们可以去除pageInfo进行验证
			MockHttpServletRequest request = result.getRequest();
			Msg msg = (Msg)request.getAttribute("msg");
			System.out.println(msg);
		}
}
