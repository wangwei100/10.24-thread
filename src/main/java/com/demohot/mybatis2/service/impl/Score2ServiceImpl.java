package com.demohot.mybatis2.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demohot.mybatis2.mapper.Score2Mapper;
import com.demohot.mybatis2.model.Score2;
import com.demohot.mybatis2.service.Score2Service;

@Service
public class Score2ServiceImpl implements Score2Service {

	@Autowired
	private Score2Mapper score2Mapper;

	@Override
	public void insertMany(int number) {
		for (int i = 0; i < number; i++) {
			Score2 score2 = new Score2();
			String name = buildName();
			Integer s = buildScore();
			score2.setName(name);
			score2.setFenshu(s);
			score2Mapper.insert(score2);
		}
	}

	public String buildName() {
		String surnames = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤";
		String[] name2 = { "成龙", "杰伦", "德华", "姚明", "子怡", "本山", "依林", "子丹", "刘翔", "冰冰", "姚明", "子怡", "赵薇", "王菲", "巩俐",
				"艺谋", "周迅", "黎明", "孙楠", "连杰" };
		int len = surnames.length();
		Random random = new Random();
		int rand = random.nextInt(len);
		char surname = surnames.charAt(rand);

		int name2Len = name2.length;
		int rand2 = random.nextInt(name2Len);
		String n = name2[rand2];
		return surname + n;
	}

	public int buildScore() {
		Random random = new Random();
		return 40 + random.nextInt(60);
	}

	@Override
	public Score2 get(String name) {
		return score2Mapper.get(name);

	}

	@Override
	public List<Score2> query(String name) {
		return score2Mapper.query(name);
	}

	@Override
	public void update(Integer id, String name, Integer score) {
		Score2 score2 = new Score2();
		// Integer id1;
		// String name1 = "";
		// Integer score1 = 77;
		score2.setId(id);
		score2.setName(name);
		score2.setFenshu(score);
		score2Mapper.update(score2);
	}

	@Override
	public void delete(Integer id) {
		Score2 score2 = new Score2();
		score2.setId(id);
		score2Mapper.delete(score2);
	}
}
