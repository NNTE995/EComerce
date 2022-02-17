package com.ecommerce.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.app.entity.Purchase;

@Service
public interface HistoricService {
	public List<Purchase> getHistoric();
	public void addPurchase(Purchase purchase);
	public List<Purchase> getHistoric(Integer userId);
	
}
