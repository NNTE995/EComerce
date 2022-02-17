package com.ecommerce.app.dao;

import java.util.List;

import com.ecommerce.app.entity.Purchase;

public interface HistoricDao {

	public List<Purchase> getHistoric();
	public void addPurchase(Purchase purchase);
	public List<Purchase> getHistoric(Integer userId);
}
