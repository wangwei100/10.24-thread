package com.demohot.mybatis2.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demohot.mybatis2.service.Score2Service;

public class ThreadImpl {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		Score2Service service = ctx.getBean(Score2Service.class);
		Thread t1 = new ThreadTest("t1", 500, service);
		Thread t2 = new ThreadTest("t2", 500, service);
		Thread t3 = new ThreadTest("t3", 500, service);

		t1.start();
		t2.start();
		t3.start();
	}
}

class ThreadTest extends Thread {
	private String name;
	private int score;
	private Score2Service s1;

	public ThreadTest(String name, int score, Score2Service s) {
		this.name = name;
		this.score = score;
		this.s1 = s;
	}

	public void run() {
		for (int i = 0; i < score; i++) {
			System.out.println(name + "正在执行" + i);
			System.out.println(Thread.currentThread().getName() + name + "正在执行" + i);
			System.out.println("名字叫" + name + "的线程开始休眠" + s1.buildName() + s1.buildScore());
		}
	}
}