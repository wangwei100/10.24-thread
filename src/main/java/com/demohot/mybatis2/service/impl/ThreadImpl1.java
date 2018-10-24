package com.demohot.mybatis2.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demohot.mybatis2.mapper.Score2Mapper;
import com.demohot.mybatis2.model.Score2;
import com.demohot.mybatis2.service.Score2Service;

public class ThreadImpl1 {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		Score2Service service = ctx.getBean(Score2Service.class);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
		Connection conn = DriverManager.getConnection(jdbc, "root", "");
		String sql = "insert into score(name,fenshu) values(?,?);";
		PreparedStatement state = conn.prepareStatement(sql);
		state.setString(1, service.buildName());
		state.setInt(2, service.buildScore());
		// Statement st=conn.createStatement();
		state.executeUpdate();

		// long startTimes=System.currentTimeMillis();
		Thread t1 = new ThreadTest1("t1", 100, service, ctx);
		Thread t2 = new ThreadTest1("t2", 100, service, ctx);
		Thread t3 = new ThreadTest1("t3", 100, service, ctx);
		Thread t4 = new ThreadTest1("t4", 100, service, ctx);
		Thread t5 = new ThreadTest1("t5", 100, service, ctx);
		Thread t6 = new ThreadTest1("t6", 100, service, ctx);
		Thread t7 = new ThreadTest1("t7", 100, service, ctx);
		Thread t8 = new ThreadTest1("t8", 100, service, ctx);
		Thread t9 = new ThreadTest1("t9", 100, service, ctx);
		Thread t10 = new ThreadTest1("t10", 100, service, ctx);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}

}

class ThreadTest1 extends Thread {
	// private String name;
	private int score;
	// private Score2Service s1;
	private ApplicationContext ctx;

	public ThreadTest1(String name, int score, Score2Service s, ApplicationContext ctx) {
		// this.name = name;
		this.score = score;
		// this.s1 = s;
		this.ctx = ctx;
	}

	public void run() {
		for (int i = 0; i < score; i++) {
			Score2Service service = ctx.getBean(Score2Service.class);
			Score2Mapper mapper = ctx.getBean(Score2Mapper.class);
			Score2 score2 = new Score2();
			String name = service.buildName();
			Integer s = service.buildScore();
			score2.setName(name);
			score2.setFenshu(s);
			mapper.insert(score2);
		}
	}
}
