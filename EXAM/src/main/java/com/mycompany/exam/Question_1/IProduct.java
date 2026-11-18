/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam.Question_1;

/**
 *
 * @author pepea
 */
public interface IProduct {
    
    /**
 * Contract for the product sales calculations.
 * Using an interface separates WHAT must be done from HOW it is done,
 * so the implementing class can change without affecting the code that uses it.
 */
    
    // Returns the total number of units sold across all products and all months
    int GetTotalProductsSold();
    
    // Returns the average units sold per product per month (double, so decimals are not lost)
    double GetAverageProductSold();
    
    // Returns the name of the product with the highest total sales
    String GetMostPopularProduct();
}
