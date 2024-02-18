package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

	@MockBean
	// モック化
	private ProductRepository productRepository;

	@Test
	public void findByNoTest() throws Exception {
		// productRepositoryはmock化しているので、好きな戻り値を設定できる
		when(productRepository.selectByNo("100")).thenReturn("ビスコ");
		ProductService productService = new ProductServiceImpl(productRepository);
		// サービスに100を渡すと、本来はリポジトリからテーブルにアクセスしてselectしてくる作りだが、
		// ↑にモック化して100を渡すとビスコを返す！と定義しているので、その通りビスコを返してくれる。
		// つまりリポジトリが未完成でも、呼び出し元のほうで挙動を仮定して、テストができる。
		String employee = productService.findByNo("100");
		// 結果、OKになる
		assertEquals(employee, "ビスコ");
	}

}
