package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public String selectByNo(String number) {
		String name = "";
		switch (number) {
		case "100" -> name = "ルマンド";
		case "101" -> name = "ビスコ";
		default -> name = "登録されていません";
		}
		return name;
	}

}
