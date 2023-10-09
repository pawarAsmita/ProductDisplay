package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;

import ch.qos.logback.core.model.Model;

@Controller
@SessionAttributes({"name","price","quantity"})
public class ProductController {

	@Autowired
	ProductService proService;

	@RequestMapping("productform")
	public String displayForm() {
		System.out.println("To display productform jsp>>>>");
		return "productform";

	}

	@PostMapping("saveProduct")
	public ModelAndView saveProductData(@RequestParam("name") String name, @RequestParam("price") Double price,
			@RequestParam("quantity") String quantity, @ModelAttribute Product proObj) {
		proObj.setName(name);
		proObj.setPrice(price);
		proObj.setQuantity(quantity);
		System.out.println("Is data coming>>>>>");
		proService.saveData(proObj);
		ModelAndView mv = new ModelAndView("productsearch");
		return mv; 

	}
	
	@RequestMapping("productsearch")
	public String displayproductsearch() {
		System.out.println("display productsearch");
		return "productsearch";
	}

	@GetMapping("productList")
	public ModelAndView productSearch(@RequestParam("name") String name, Model model) {
		System.out.println("To display productsearch jsp>>>>");
		System.out.println("p:" + name);
		List<Product> list = proService.findByName(name);
		System.out.println("list is:" + list);
		ModelAndView mv = new ModelAndView("productdisplay");
//		mv.addObject("productList", list);
		mv.addObject("policyList", list);
		return mv;
	}
	
	@RequestMapping("productdisplay")
	public String dispalyProduct() {
		System.out.println("display productdisplay page>>>>");
		return "productdisplay";
	}

}
