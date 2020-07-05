package com.challenge.productAPI.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.productAPI.model.Taxes;
import com.challenge.productAPI.service.TaxesService;

@Component
public class TaxesUtils {
	/*
	 * Como não tinha nada na especificação, eu não sabia exatamente se deveria formatar os impostos
	 * e como deveria formatar, então coloquei do jeito que achei melhor, 
	 * mas quero saber como costumam fazer.
	 *
	*/
	
	@Autowired
	private TaxesService taxesService;
	
	public Double calculateTotalTaxes(Integer clientId, Double price) {
		
		Integer ICMS = 0;
		Integer IPI = 0;	
		List<Taxes> taxes = taxesService.findTaxesOfClient(clientId);
		for(Taxes tax : taxes) { 
			if (tax.getType().equals("ICMS")) {
				ICMS = tax.getPercentage();
			} else {
				IPI = tax.getPercentage();
			}
		}
		
		Double totalTaxes = price + (price * (IPI / 100.00)) + (price * (ICMS / 100.00));
		return Math.round(totalTaxes * 100) / 100.00;
	}
}
