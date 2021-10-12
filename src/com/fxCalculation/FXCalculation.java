package com.fxCalculation;

import java.io.*; //FileReader
import java.util.*; //Properties

public class FXCalculation {

	public static void main(String[] args) {
		try {
			// config file contains - USD, PROFIT, AMOUNT
			FileReader fr = new FileReader("config-file");
			Properties props = new Properties();
			props.load(fr);

			double exRate = Double.parseDouble(props.getProperty("USD"));
			int profit = Integer.parseInt(props.getProperty("PROFIT"));
			double amount = Double.parseDouble(props.getProperty("TOTAL_AMOUNT"));
			
			double totalCustomerAmount = getAmount(profit, exRate, amount);
			
			getData(amount, exRate, profit, totalCustomerAmount);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static double getAmount(int profit, double exRate, double amount) {
		return (amount/exRate) + profit;
	}

	private  static void getData(double amount, double exRate, int profit, double totalCustomerAmount) {
		System.out.println("\nOutput:- \n");
		System.out.println("Amount in Rs.                      : " + "\t" + String.format("%.2f", amount));
		System.out.println("Exchange Rate                      : " + "\t" + String.format("%.2f", exRate));
		System.out.println("Profit in $                        : " + "\t" + "$" + profit);
		System.out.println("Amount to be paid by customer ($)  : " + "\t" + "$" + String.format("%.2f", totalCustomerAmount));
	}
}