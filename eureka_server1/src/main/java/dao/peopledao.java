package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import entity.people;

@Mapper
public interface peopledao {

	public List<people> findall();
	public people findpassword(String name);
}
