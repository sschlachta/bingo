package com.company;
import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {

        System.out.println("BINGO WAS HIS NAME-OE");
        System.out.println("---------------------");

        System.out.println("\nWelcome to bingo! Here is your board: ");
        System.out.println("\nB     I     N     G     O");

        int bingoBoard[][] = new int[5][5];

        Random rnd = new Random();

        for(int i = 0; i < bingoBoard.length; i++){

            for(int j = 0; j< bingoBoard[i].length; j++){

                int fill = 1 + (int)(Math.random() * ((100 - 1) + 1));

                bingoBoard[i][j] = fill;



            }

        }

        for (int i = 0; i < bingoBoard.length; i++) {

            int f2 = 1 + (int)(Math.random() * ((100 - 1) + 1));

            System.out.println(f2 + "    " + bingoBoard[i][0] + "    " + bingoBoard[i][1] + "    " + bingoBoard[i][2] + "    " + bingoBoard[i][3]);

        }

        System.out.println("\nReady to start? Great! Here's the first number: ");


        int rN = 1 + (int)(Math.random() * ((100 - 1) + 1));

        System.out.println("\n" + rN);

        for(int i = 0; i < bingoBoard.length; i++){

            for(int j = 0; j < bingoBoard[i].length; j++){

                if(bingoBoard[i][j] == rN){

                    bingoBoard[i][j] = 0;

                }

            }

        }



    }
}
