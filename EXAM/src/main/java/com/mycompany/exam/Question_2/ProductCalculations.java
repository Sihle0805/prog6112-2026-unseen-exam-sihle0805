/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam.Question_2;

/**
 *
 * @author pepea
 */
public class ProductCalculations implements IProductCalculations {
    private final double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    // VAT = 15% of the product price
    public double GetVat() {
        return price * 0.15;
    }

    @Override
    // Commission = 5% of the product price
    public double GetCommission() {
        return price * 0.05;
    }

    @Override
    // Total = price + VAT + commission (reuses the other methods so the percentages are only defined once)
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}
