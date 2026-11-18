/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam.Question_1;

/**
 *
 * @author pepea
 */
public class Product implements IProduct {
    private final String[] names;   // single array
    private final int[][] sales;    // 2D array [product][month]

    public Product(String[] names, int[][] sales) {
        this.names = names;
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
