package com.example.demo;

import org.springframework.stereotype.Service;

@Service //Bean化
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	//ShainRepositoryのDI
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public String findByNo(String number) {
		//リポジトリから商品を選択
		String name = productRepository.selectByNo(number);
		return name;
	}

}
