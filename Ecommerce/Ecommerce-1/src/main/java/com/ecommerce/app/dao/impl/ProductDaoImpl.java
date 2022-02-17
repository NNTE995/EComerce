package com.ecommerce.app.dao.impl;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.ProductDao;
import com.ecommerce.app.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	List<Product> productsList = new ArrayList<>();
	

	 public ProductDaoImpl() {
		 initProductsList();
	 }
	 
	 private void initProductsList(){

			Product p1 = new Product();
			p1.setProductId(1);
			p1.setProductName("Samsung S21");
			p1.setCategory("mobile phone");
			p1.setPrice(800);
			p1.setProducQuantity(22);
			
			Product p2 = new Product();
			p2.setProductId(2);
			p2.setProductName("Smart tv 2");
			p2.setCategory("tv");
			p2.setPrice(500);
			p2.setProducQuantity(32);
			
			Product p3 = new Product();
			p3.setProductId(3);
			p3.setProductName("refrigerator");
			p3.setCategory("home");
			p3.setPrice(550);
			p3.setProducQuantity(34);
			
			Product p4 = new Product();
			p4.setProductId(4);
			p4.setProductName("laptop ???");
			p4.setCategory("home office");
			p4.setPrice(1100);
			p4.setProducQuantity(324);
			
			productsList.add(p1);
			productsList.add(p2);
			productsList.add(p3);
			productsList.add(p4);
		}

	@Override
	public List<Product> getProducts() {
		//initProductsList();
		System.out.println("Adding products");
		return productsList;
	}

	@Override
	public void deleteProduct(Product p) {
		// TODO Auto-generated method stub
		for(Product pro : productsList) {
			if(pro.equals(p)) {
				if(pro.getProducQuantity() == 1)
					productsList.remove(pro);
				else
					pro.setProducQuantity(pro.getProducQuantity()-p.getProducQuantity());
			}
		}
		
	}
	
	@Override
	public List<Product> getProductByName(String name) {
		List<Product> products = new ArrayList<>();
		for(Product p : productsList) 
			if(p.getProductName().equalsIgnoreCase(name))
				products.add(p);
		return products;
	}
}
