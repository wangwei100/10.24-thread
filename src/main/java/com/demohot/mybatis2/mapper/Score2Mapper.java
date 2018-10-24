package com.demohot.mybatis2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.mybatis2.model.Score2;

public interface Score2Mapper {
	public void insert(Score2 score2);

	public Score2 get(@Param("name") String name);

	List<Score2> query(@Param("name") String name);

	public void update(Score2 score2);

	public void delete(Score2 score2);
}
