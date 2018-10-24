package dao.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.demohot.mybatis2.model.Score2;
import com.demohot.mybatis2.service.Score2Service;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath*:app-context.xml" })
public class Score2MapperTest {
	private Logger logger = LoggerFactory.getLogger(Score2MapperTest.class);
	@Autowired
	private Score2Service score2Service;

	@Test
	public void insertTest() {
		int number = 5000;
		score2Service.insertMany(number);
	}

	@Test
	public void getTest() {
		String name = "李连杰";
		Score2 score2 = score2Service.get(name);
		String s = JSON.toJSONString(score2);
		System.out.println(s);
		logger.debug(s);
		logger.info(s);
		logger.warn(s);
		logger.error(s);
	}

	@Test
	public void testQuery() {
		String name = "姜依林";
		List<Score2> ls = score2Service.query(name);
		String s = JSON.toJSONString(ls);
		logger.info(s);
		logger.info("" + ls.size());
	}

	@Test
	public void testUpdate() {
		Integer score = 11;
		String name = "ww";
		Integer id = 1;
		score2Service.update(id, name, score);
	}

	@Test
	public void testDelete() {
		Integer id = 1;
		score2Service.delete(id);
	}
}
