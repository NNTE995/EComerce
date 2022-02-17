package com.ecommerce.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Purchase;
import com.ecommerce.app.service.HistoricService;

@Controller
public class HistoricController {
	
	@Autowired
	HistoricService historicService;
	
	
	@RequestMapping(value = "/showPurchases", method = RequestMethod.GET)
	public ModelAndView showHistoric(ModelAndView modelAndView, @RequestParam("userId") Integer userId) {
		List<Purchase> purchases = historicService.getHistoric(userId);
		modelAndView.addObject("purchases", purchases);
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("userhistoric");
		//System.out.println(purchases.get(0).getUserId());
		//System.out.println(purchases.get(1).getUserId());
		//System.out.println(purchases.get(0).getDate());
		//System.out.println(purchases.get(1).getDate());
		//System.out.println(purchases.get(0).getTotal());
		//System.out.println(purchases.get(1).getTotal());
		return modelAndView;
	}
	
	@RequestMapping(value="/addingPurchase", method = RequestMethod.GET)
	public ModelAndView addPurchase(Model model, @RequestParam("total") Double total, ModelAndView modelAndView) {
		
		Cart cart = (Cart) model.asMap().get("cart");	
		System.out.println(cart.getProducts());
		Purchase newPurchase = new Purchase();
		LocalDate myDate = LocalDate.now();
		System.out.println(cart.getProducts());
		newPurchase.setCart(cart);
		newPurchase.setDate(myDate);
		newPurchase.setTotal(total);
		newPurchase.setUserId(cart.getUserId());
		historicService.addPurchase(newPurchase);
		
		//for(Purchase p : historicService.getHistoric())
		//	System.out.println(p.getCart().getProducts());
		
		modelAndView.addObject("cart",cart.getProducts());
		modelAndView.addObject("total",total);
		modelAndView.addObject("userId",cart.getUserId());
		modelAndView.setViewName("purchaseconfirmation");		
		return modelAndView;
	}
	
}
