package com.ecommerce.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.app.dao.HistoricDao;
import com.ecommerce.app.entity.Purchase;

@Repository
public class HistoricDaoImpl implements HistoricDao{

	
	List<Purchase> purchases = new ArrayList<>(); 
	
	@Override
	public List<Purchase> getHistoric() {
		return purchases;
	}

	@Override
	public void addPurchase(Purchase purchase) {
		purchase.setPurchaseId(purchases.size());
		purchases.add(purchase);
	}

	@Override
	public List<Purchase> getHistoric(Integer userId) {
		// TODO Auto-generated method stub
		List<Purchase> purchaseByUser = new ArrayList<>();		
		for(Purchase p : purchases)
			if (p.getCart().getUserId().equals(userId))
				purchaseByUser.add(p);
		return purchaseByUser;
	}

}
