package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	private final ProductService productService;

	//ProductServiceのDI。コンストラクタでDIする
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/input")
	public String index(ProductForm productForm) {
		return "index.html";
	}

	@RequestMapping("/output")
	public String result(@Validated ProductForm shainForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "index.html";
		}

		model.addAttribute("number", shainForm.getNumber());

		//サービス層から商品名を取得してくる
		String name = productService.findByNo(shainForm.getNumber());
		model.addAttribute("name", name);
		return "output.html";
	}
}