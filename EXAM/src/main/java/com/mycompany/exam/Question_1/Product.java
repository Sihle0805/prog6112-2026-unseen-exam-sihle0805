/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam.Question_1;

/**
 *
 * @author pepea
 */

/**
 * Holds the sales data and performs all calculations for the report.
 * Implements IProduct, so it must provide every method in the interface.
 * Calculation logic is kept here, separate from printing (PrintProduct)
 * and user input (SalesReport), following separation of concerns.
 */
public class Product implements IProduct {
    private final String[] names;   // single array
    private final int[][] sales;    // 2D array [product][month]

    public Product(String[] names, int[][] sales) {
        
        // Single (1D) array: stores the product names, index matches the rows in sales
        this.names = names;
        
        // Two-dimensional array: rows = products, columns = months, e.g. sales[0][1] = product 1, month 2
        // Marked private so the data can only be accessed through this class's methods (encapsulation)
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int p = 0; p < sales.length; p++) {
            for (int m = 0; m < sales[p].length; m++) {
                total += sales[p][m];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int count = sales.length * sales[0].length;
        return (double) GetTotalProductsSold() / count;
    }

    @Override
    public String GetMostPopularProduct() {
        return names[GetMostPopularIndex()];
    }

    public int GetMostPopularTotal() {
        return GetProductTotal(GetMostPopularIndex());
    }

    private int GetMostPopularIndex() {
        int best = 0;
        for (int p = 1; p < sales.length; p++) {
            if (GetProductTotal(p) > GetProductTotal(best)) {
                best = p;
            }
        }
        return best;
    }

    private int GetProductTotal(int p) {
        int total = 0;
        for (int m = 0; m < sales[p].length; m++) {
            total += sales[p][m];
        }
        return total;
    }
}
