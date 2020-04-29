package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;

@Controller
public class ProductController {

	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/comprarproducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "Nintendo Switch", 8));
		productos.add(new Product(1, "Play Station 32 turbo hyper pro", 12));
		productos.add(new Product(2, "laptop", 6));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		
		return mav;
	}
	
	
	@PostMapping("validar")
	@ResponseBody
	public ModelAndView validar(Product product) {
		
		ModelAndView mav = new ModelAndView();
		
		int limite = productos.get(product.getId()).getCantidad();
		int solicitado = product.getCantidad();
		
		if(solicitado <= limite) {
			
			mav.setViewName("compra");
			mav.addObject("msg", "El producto "+ productos.get(product.getId()).getNombre() + " fue adquirido con exito :D");
			return mav;

		}
		
		mav.setViewName("error");
		mav.addObject("error","Se han solicitado mas items de los que se encuentran disponibles.\nEl inventario cuenta solo con " + limite+ " elementos del item " + productos.get(product.getId()).getNombre()+ " :C");
		return mav;
		
		//return productos.get(product.getId()).getNombre() + "\n" + productos.get(product.getId()).getCantidad();
	}
	
}
