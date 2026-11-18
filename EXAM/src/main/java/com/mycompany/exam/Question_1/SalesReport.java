/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam.Question_1;
import java.util.Scanner;
/**
 *
 * @author pepea
 */
public class SalesReport {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        
        // 3 products x 3 months; all values default to 0 until the user enters them
        int[][] sales = new int[3][3];

        for (int p = 0; p < names.length; p++) {
            for (int m = 0; m < 3; m++) {
                System.out.print("Enter number of sales for month " + (m + 1)
                        + " for " + names[p] + " mattress: ");
                sales[p][m] = input.nextInt();
            }
            System.out.println();
        }

        Product product = new Product(names, sales);
        PrintProduct printer = new PrintProduct(product);

        printer.PrintHeader();
        printer.PrintTotalProductSales();
        printer.PrintAverageProductSales();
        printer.PrintMostPopularProduct();
        
        
        
    }
    
}
