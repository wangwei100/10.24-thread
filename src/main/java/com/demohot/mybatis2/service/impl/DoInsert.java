package com.demohot.mybatis2.service.impl;

import java.util.Random;

interface IProduct1 {
	public String buildName();
}

interface IProduct2 {
	public int buildScore();
}

class Product1 implements IProduct1 {
	@Override
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
}

class Product2 implements IProduct2 {
	@Override
	public int buildScore() {
		Random random = new Random();
		return 40 + random.nextInt(60);
	}
}

interface IFactory {
	public IProduct1 createProduct1();

	public IProduct2 createProduct2();
}

class Factory implements IFactory {

	public IProduct1 createProduct1() {
		return new Product1();
	}

	public IProduct2 createProduct2() {
		return new Product2();
	}
}

public class DoInsert {
	public static void main(String[] args) {
		IFactory factory = new Factory();
		factory.createProduct1().buildName();
		factory.createProduct2().buildScore();
	}
}
