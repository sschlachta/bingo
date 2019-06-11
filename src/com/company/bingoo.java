package com.company;
import javax.swing.*;
import java.util.ArrayList;

import java.util.Scanner;

public class bingoo {

    boolean yon = false;
    private int[][] bb;
    private int numTimesFound = 0;
    private int roundNum = 0;
    private int[][] foundNums = new int[100][5];
    private boolean fn = false;
    private boolean BINGO = false;
    String rT;

    public bingoo(int col, int rows, String roundType){

        bb = new int[col][rows];
        rT = roundType;

    }

    public void saveTime(){

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

    }

    public int setColumn(){

        int col = 1 + (int)(Math.random() * (5 + 1));
        col = col - 1;
        return col;

    }

    public String getColumnLetter(int cl){

        String gclng = " ";

        if(cl == 0){

            gclng = "B";

        } else if(cl == 1){

            gclng = "I";

        } else if(cl == 2){

            gclng = "N";

        } else if(cl == 3){

            gclng = "G";

        } else if(cl == 4){

            gclng = "O";

        }

        return gclng;

    }

    public int findNumTimesFound(int[][] aryy, int ranUm, int coln){

        numTimesFound = 0;

            for(int j = 0; j < aryy.length; j++){

                if(aryy[j][coln] == ranUm){

                    numTimesFound = numTimesFound + 1;

                }

            }


        return numTimesFound;

    }

    public int[][] removeNums(int[][] ary, int ranUm, int col){

        numTimesFound = 0;

            for(int j = 0; j < ary.length; j++){

                if(ary[j][col] == ranUm){

                    ary[j][col] = 0;
                    numTimesFound = numTimesFound + 1;

                }

            }

        return ary;

    }


    public int[][] createBoard(){

        for(int i = 0; i < bb.length; i++){

            for(int j = 0; j< bb[i].length; j++){

                int fill = 1 + (int)(Math.random() * ((100 - 1) + 1));

                bb[i][j] = fill;

            }

        }
        return bb;
    }



    private void printBoard(int[][] arry){

        System.out.println("\nB     I     N     G     O");

        for (int i = 0; i < arry.length; i++) {

            System.out.println(arry[i][0] + "    " + arry[i][1] + "    " + arry[i][2] + "    " + arry[i][3] + "    " + arry[i][4]);

        }

    }

    private boolean checkNum(int ntbc, int columnArray){

        for(int i = 0; i < foundNums.length; i++){

            if(ntbc == foundNums[i][columnArray]){

                fn = false;

            }

        }
        return fn;
    }

    public int findNextSpot(int[][] ary){

        int spot = 0;

        for(int i = 0; i < ary.length; i++){

            for(int j = 0; j < ary[i].length; j++) {

                if (ary[i][j] == 0) {

                    spot = i;

                }
            }
        }
        return spot;
    }

    public void playBingoRound(bingoo brd, int[][] dub){

        System.out.println("\nRound " + roundNum);

        brd.printBoard(dub);

        brd.saveTime();

        System.out.println("\nThe next number is: ");

        brd.saveTime();

        int rN = 1 + (int)(Math.random() * ((100 - 1) + 1));

        int coll = setColumn();

        String cL = getColumnLetter(coll);

        if(checkNum(rN, coll)){
            foundNums[findNextSpot(foundNums)][coll] = rN;
        } else {
            rN = 1 + (int)(Math.random() * ((100 - 1) + 1));
        }

        int nTF = brd.findNumTimesFound(dub, rN, coll);

        brd.saveTime();

        System.out.println("\n" + "-" + cL + " " + rN + "-");

        brd.saveTime();

        int g = -1;
        String input;
        while(g < 0) {
            input = JOptionPane.showInputDialog("Please Enter the Number of Times You See " + rN + " in column " + cL + " on Your Board: ");
            if (Integer.parseInt(input) == nTF) {
                g++;
                System.out.println("\nGreat!");
            } else if(input.length() <= 0) {
                System.out.println("\nPlease Enter a Number!");
            }else{
                System.out.println("\nThat number was not found that many times on your board, please take a second look!");
            }
        }

        brd.removeNums(dub, rN, coll);

        System.out.println("\nThe number was found " + nTF +" times on your board!");

        brd.printBoard(dub);

        brd.saveTime();

            int s = -1;
            String inpt = " ";
            while(s < 0) {
                inpt = JOptionPane.showInputDialog("Would you like to continue the game? Y/N");
                if (inpt.length() > 0) {
                    s++;
                    System.out.println("\nThank you!");
                } else if(inpt.length() <= 0) {
                    System.out.println("\nPlease Enter Y or N!");
                }

            if(inpt.equalsIgnoreCase("y")){

                yon = true;
                roundNum = roundNum + 1;

            } else {

                yon = false;
                roundNum = 0;

            }

        }

    }


    public void playTutorial(bingoo board, int[][] brd){

        System.out.println("\nBINGO WAS HIS NAME-OE");
        System.out.println("---------------------");

        System.out.println("\nWelcome to bingo! Here is your board: ");

        board.saveTime();

        board.printBoard(brd);

        board.saveTime();

        System.out.println("\nReady to start the tutorial? ");

        board.saveTime();

        System.out.println("\nGreat! Here's the first number: ");

        int rN = 1 + (int)(Math.random() * ((100 - 1) + 1));

        board.saveTime();

        int colle = setColumn();

        String cLl = getColumnLetter(colle);

        System.out.println("\n" + "-" + cLl + " " + rN + "-");

        board.saveTime();

        int nTF = board.findNumTimesFound(brd, rN, colle);

        board.saveTime();

        int g = -1;
        String input = " ";
        while(g < 0) {
            input = JOptionPane.showInputDialog("Please Enter the Number of Times You See " + rN + " in column " + cLl + " on Your Board: ");
            if (Integer.parseInt(input) == nTF) {
                g++;
                System.out.println("\nThank you!");
            } else if(input.length() <= 0) {
                System.out.println("\nPlease Enter a Number!");
            }else{
                System.out.println("\nThat number was not found that many times on your board, please take a second look!");
            }
        }

        board.removeNums(brd, rN, colle);

        System.out.println("\nThe number was found " + nTF +" times on your board!");

        board.printBoard(brd);

        board.checkBingo(board, brd, rT);

        board.saveTime();

        System.out.println("\n\n");

        int k = -1;
        String inp = " ";
        while(k < 0) {
            inp = JOptionPane.showInputDialog("Would you like to continue the game? Y/N ");
            if (input.length() > 0) {
                k++;
                System.out.println("\nThank you!");
            } else if(input.length() <= 0) {
                System.out.println("\nPlease Enter Y or N!");
            }
        }

        if(inp.equalsIgnoreCase("Y")){

            yon = true;

        }

    }

    private void checkBingo(bingoo brd, int[][] dub, String roundType){

        if(roundType.equalsIgnoreCase("O")){

            if(checkForBingo(dub)){

                System.out.println("CONGRATULATIONS!!! YOU HAVE BINGO!!!");

            }

        } else if(roundType.equalsIgnoreCase("FC")){

            if(checkForFourCorners(dub)){

                System.out.println("CONGRATULATIONS!!! YOU HAVE BINGO!!!");

            }

        } else if(roundType.equalsIgnoreCase("T")){

            if(checkForT(dub)){

                System.out.println("CONGRATULATIONS!!! YOU HAVE BINGO!!!");

            }

        } else if(roundType.equalsIgnoreCase("FS")){

            if(checkForFourSides(dub)){

                System.out.println("CONGRATULATIONS!!! YOU HAVE BINGO!!!");

            }

        }
    }

    public boolean checkForFourSides(int[][] Tw){

        BINGO = false;

        int isZero = 0;

        for(int i = 0; i < Tw[0].length; i++){
            if(Tw[0][i] == 0){
                isZero++;
            }
            if(Tw[i][0] == 0){
                isZero++;
            }
            if(Tw[4][i] == 0){
                isZero++;
            }
            if(Tw[i][4] == 0){
                isZero++;
            }
        }
        if(isZero == 16){
            BINGO = true;
        } else {
            BINGO = false;
        }
        return BINGO;
    }

    private boolean checkForT(int[][] Tw){

        BINGO = false;
        int isZero = 0;

        for(int i = 0; i < Tw[0].length; i++){

            if(Tw[0][i] == 0){

                isZero = isZero + 1;

            }

            if(Tw[i][2] == 0){

                isZero = isZero + 1;

            }

        }

        if(isZero == 9){

            BINGO = true;

        } else {

            BINGO = false;

        }

        return BINGO;

    }

    public boolean checkForFourCorners(int[][] Tw){

        BINGO = false;
        int isZero = 0;

        if(Tw[0][0] == 0){

            isZero = isZero + 1;

        }

        if(Tw[0][4] == 0){

            isZero = isZero + 1;

        }

        if(Tw[4][0] == 0){

            isZero = isZero + 1;

        }

        if(Tw[4][4] == 0){

            isZero = isZero + 1;

        }

        if(isZero == 4){

            BINGO = true;

        }

        return BINGO;

    }

    private boolean checkForBingo(int[][] brd){

        BINGO = false;
        int isZero = 0;

        for(int i = 0; i < brd.length; i++){

            for(int j = 0; j < brd[i].length; j++){

             if(brd[i][j] == 0){

                 isZero = isZero + 1;

             }

            }

            if(isZero == 5){

                BINGO = true;

            }

        }

       isZero = 0;

        if(!BINGO){

            for(int i = 0; i < brd.length; i++){

                for(int j = 0; j < brd[i].length; j++){

                    if(brd[j][i] == 0){

                        isZero = isZero + 1;

                    }

                }

                if(isZero == 5){

                    BINGO = true;

                }

            }

        }

        return BINGO;
    }

}