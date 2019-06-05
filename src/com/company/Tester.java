package com.company;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;



public class Tester {

    public static void tester(String [] args) {

        String input = JOptionPane.showInputDialog("Please Enter your Name: ");
        if (input.length() > 0) {

            System.out.println("Thank you");

        } else {

            System.out.println("Enter Your name!");

        }
    }
}