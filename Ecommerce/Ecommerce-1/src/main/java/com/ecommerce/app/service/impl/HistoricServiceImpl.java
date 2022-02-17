package com.ecommerce.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.dao.HistoricDao;
import com.ecommerce.app.entity.Purchase;
import com.ecommerce.app.service.HistoricService;

@Service
public class HistoricServiceImpl implements HistoricService{
	
	@Autowired
	HistoricDao historicDao;

	@Override
	public List<Purchase> getHistoric() {
		// TODO Auto-generated method stub
		return historicDao.getHistoric();
	}

	@Override
	public void addPurchase(Purchase purchase) {
		historicDao.addPurchase(purchase);
	}

	@Override
	public List<Purchase> getHistoric(Integer userId) {
		// TODO Auto-generated method stub
		return historicDao.getHistoric(userId);
	}
}
