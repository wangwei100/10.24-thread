package com.demohot.mybatis2.service;

import java.util.List;

import com.demohot.mybatis2.model.Score2;

public interface Score2Service {
	public void insertMany(int number);
	
	public String buildName();
	
	public int buildScore();

	public Score2 get(String name);

	public List<Score2> query(String name);

	public void update(Integer id, String name, Integer score);

	public void delete(Integer id);

}
