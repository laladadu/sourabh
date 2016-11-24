package com.aartek.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.model.ProductDto;
import com.aartek.service.ProductService;
import com.aartek.validator.ProductValidation;


@Controller
public class DashBoardController {

	@Autowired
	ProductService productService; 
	@Autowired 
	ProductValidation productValidation;
	
	@RequestMapping("/dashBoard")
	public String showDashBoard(Map<String, Object> map, Model model) {
		map.put("Product", new ProductDto());
	List<ProductDto> list=	productService.showProductsDetails();
	
	model.addAttribute("records", list);
	
	return "dashBoard";
	}

	@RequestMapping(value = "/saveProductDetails", method = { RequestMethod.POST })
	public String saveProdctDetails(@ModelAttribute("Product") ProductDto productDto ,BindingResult result) {
		
		//boolean status = false;

		productValidation.validate(productDto, result);
		
		if(result.hasErrors())
		{
			System.out.println("ERROR");
		    return"dashBoard";
		}
		else
		{
		
			if(productService.insertProductDetails(productDto)==true){
				System.out.println("Save In DB");

				return "redirect:/dashBoard.do";
		}
			else{
				System.out.println("NOT SAVE In DB");

				return "redirect:/dashBoard.do";
			}
		}

				
	}
	
	@RequestMapping(value = "/Edit",method={RequestMethod.GET})
	public String editDetails(@ModelAttribute("Product") ProductDto productDto,@RequestParam(required = false) String arg ,ModelMap model){
		String p_id1=arg;
		List<ProductDto> list=	productService.show_pro_detail(p_id1);
		
		model.addAttribute("pro_id", list.get(0).getPro_id());
		model.addAttribute("pro_name", list.get(0).getPro_name());
		model.addAttribute("pro_price", list.get(0).getPro_price());
		model.addAttribute("pro_category", list.get(0).getPro_category());
		model.addAttribute("p_id",Integer.parseInt(p_id1));
		model.addAttribute("records", list);
			 return "dashBoard";
			 
	}
	
	@RequestMapping(value = "/Delete",method={RequestMethod.GET})
	public String delete(@RequestParam(required = false) String arg,ModelMap model){
		String p_id1=arg;
		productService.delete_product(p_id1);
		return "redirect:/dashBoard.do";
	}

}
