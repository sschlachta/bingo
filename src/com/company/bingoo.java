package com.company;
import javax.swing.*;
import java.util.ArrayList;

import java.util.Scanner;

public class bingoo {

    int[][] bb;
    int numTimesFound = 0;
    int roundNum = 0;
    boolean yon = false;
    int[] foundNums = new int[100];
    boolean fn = false;
    int spotsFilled = 0;
    boolean BINGO = false;
    String rT = " ";
    boolean miniGameYon = false;

    public bingoo(int col, int rows, String roundType){

        bb = new int[col][rows];
        rT = roundType;

    }

    public boolean getYON(){

        return yon;

    }

    public int findNumTimesFound(int[][] aryy, int ranUm){

        numTimesFound = 0;

        for(int i = 0; i < aryy.length; i++){

            for(int j = 0; j < aryy[i].length; j++){

                if(aryy[i][j] == ranUm){

                    numTimesFound = numTimesFound + 1;

                }

            }

        }

        return numTimesFound;

    }

    public int[][] removeNums(int[][] ary, int ranUm){

        numTimesFound = 0;

        for(int i = 0; i < ary.length; i++){

            for(int j = 0; j < ary[i].length; j++){

                if(ary[i][j] == ranUm){

                    ary[i][j] = 0;
                    numTimesFound = numTimesFound + 1;

                }

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



    public void printBoard(int[][] arry){

        System.out.println("\nB     I     N     G     O");

        for (int i = 0; i < arry.length; i++) {

            System.out.println(arry[i][0] + "    " + arry[i][1] + "    " + arry[i][2] + "    " + arry[i][3] + "    " + arry[i][4]);

        }

    }

    public boolean checkNum(int ntbc){

        for(int i = 0; i < foundNums.length; i++){

            if(ntbc == foundNums[i]){

                fn = false;

            } else {

                fn = true;

            }

        }
        return fn;
    }

    public int findNextSpot(int[] ary){

        int spot = 0;

        for(int i = 0; i < ary.length; i++){

            if(ary[i] == 0){

                spot = i;

            }

        }
        return spot;
    }

    public void play20Questions(){

        ArrayList lo = new ArrayList();
        ArrayList pw = new ArrayList();

        pw.add("Toaster");
        pw.add("Ostrich");
        pw.add("Bike");
        pw.add("Bread");
        pw.add("Frog");
        pw.add("Canoe");
        pw.add("Lamp");
        pw.add("Marker");
        pw.add("Doctor");
        pw.add("Xylophone");
        pw.add("Violin");
        pw.add("Happiness");
        pw.add("Mountain");
        pw.add("Fly");
        pw.add("Fork");
        pw.add("Horn");
        pw.add("Tooth");
        pw.add("Zebra");
        pw.add("Park");
        pw.add("Teacher");
        pw.add("The White House");
        pw.add("Juice");
        pw.add("Tree");
        pw.add("Yarn");
        pw.add("Anger");

        for(int i = 0; i < pw.size();i++){

            System.out.println(pw.get(i));

        }

        System.out.println("\nPick any word from this list and think of it in your head!");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("\nGot it? Great, let's get started!!");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("Is your word alive?");
        Scanner an = new Scanner(System.in);
        String answ = an.next();

        if(answ.equalsIgnoreCase("Y")){

            lo.add("Toaster");
            lo.add("Bike");
            lo.add("Bread");
            lo.add("Canoe");
            lo.add("Lamp");
            lo.add("Marker");
            lo.add("Xylophone");
            lo.add("Violin");
            lo.add("Happiness");
            lo.add("Mountain");
            lo.add("Fork");
            lo.add("Horn");
            lo.add("Tooth");
            lo.add("Park");
            lo.add("The White House");
            lo.add("Juice");
            lo.add("Yarn");
            lo.add("Anger");

            pw.remove(0);
            pw.remove(2);
            pw.remove(3);
            pw.remove(5);
            pw.remove(6);
            pw.remove(7);
            pw.remove(9);
            pw.remove(10);
            pw.remove(11);
            pw.remove(12);
            pw.remove(14);
            pw.remove(15);
            pw.remove(16);
            pw.remove(18);
            pw.remove(20);
            pw.remove(21);
            pw.remove(23);
            pw.remove(24);

        } else if(answ.equalsIgnoreCase("N")){

            pw.remove(1);
            pw.remove(4);
            pw.remove(8);
            pw.remove(13);
            pw.remove(17);
            pw.remove(19);
            pw.remove(22);
            pw.remove(10);
            pw.remove(11);
            pw.remove(12);
            pw.remove(14);
            pw.remove(15);
            pw.remove(16);
            pw.remove(18);
            pw.remove(20);
            pw.remove(21);
            pw.remove(23);
            pw.remove(24);

        }

    }

    public void playGuessMyNumber(){



    }

    public void playMiniGame(){

        int rN = 1 + (int)(Math.random() * ((5 - 1) + 1));

        System.out.println(rN);

        if(rN == 1){

            play20Questions();

        } else if(rN == 2){

            playGuessMyNumber();

        }

    }


    public void playBingoRound(bingoo brd, int[][] dub){

        brd.printBoard(dub);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("\nReady to start round " + roundNum + "?");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("\nGreat! Here's the next number: ");

        int rN = 1 + (int)(Math.random() * ((100 - 1) + 1));

        if(checkNum(rN)){

            foundNums[findNextSpot(foundNums)] = rN;

        } else {

            rN = 1 + (int)(Math.random() * ((100 - 1) + 1));

        }

        int nTF = brd.findNumTimesFound(dub, rN);

        if(nTF > 0){

            spotsFilled = spotsFilled + 1;

        }

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("\n" + "-" + rN + "-");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        int g = -1;
        String input = " ";
        while(g < 0) {
            input = JOptionPane.showInputDialog("Please Enter the Number of Times You See " + rN + " on Your Board: ");
            if (Integer.parseInt(input) == nTF) {
                g++;
                System.out.println("Great!");
            } else if(input.length() <= 0) {
                System.out.println("Please Enter a Number!");
            }else{
                System.out.println("That number was not found that many times on your board, please take a second look!");
            }
        }

        brd.removeNums(dub, rN);

        if(rT.equalsIgnoreCase("O")){

            if(checkForBingo(brd, dub)){

                System.out.println("CONGRATULATIONS!!! YOU HAVE BINGO!!!");

            }

        } else if(rT.equalsIgnoreCase("FC")){

            if(checkForFourCorners(brd, dub)){

                System.out.println("CONGRATULATIONS!!! YOU HAVE BINGO!!!");

            }

        } else if(rT.equalsIgnoreCase("T")){

            if(checkForT(brd, dub)){

                System.out.println("CONGRATULATIONS!!! YOU HAVE BINGO!!!");

            }

        } else if(rT.equalsIgnoreCase("FS")){

            if(checkForFourSides(brd, dub)){

                System.out.println("CONGRATULATIONS!!! YOU HAVE BINGO!!!");

            }

        }

        System.out.println("\nThe number was found " + nTF +" times on your board!");

        brd.printBoard(dub);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }


        int u = -1;
        String intp = " ";
        while(u < 0) {
            intp = JOptionPane.showInputDialog("Would you like to play a Mini Game? Y/N");
            if (intp.length() > 0) {
                u++;
                System.out.println("Thank you!");
            } else if(intp.length() <= 0) {
                System.out.println("Please Enter Y or N!");
            }
        }

        if(intp.equalsIgnoreCase("Y")){

            miniGameYon = true;

        } else if(intp.equalsIgnoreCase("N")){

            int s = -1;
            String inpt = " ";
            while(s < 0) {
                inpt = JOptionPane.showInputDialog("Would you like to continue the game? Y/N");
                if (inpt.length() > 0) {
                    s++;
                    System.out.println("Thank you!");
                } else if(inpt.length() <= 0) {
                    System.out.println("Please Enter Y or N!");
                }
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

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        board.printBoard(brd);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("\nReady to start the tutorial? ");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("\nGreat! Here's the first number: ");

        int rN = 1 + (int)(Math.random() * ((100 - 1) + 1));

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("\n" + "-" + rN + "-");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        int nTF = board.findNumTimesFound(brd, rN);

        if(nTF > 0){

            spotsFilled = spotsFilled + 1;

        }

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        int g = -1;
        String input = " ";
        while(g < 0) {
            input = JOptionPane.showInputDialog("Please Enter the Number of Times You See " + rN + " on Your Board: ");
            if (Integer.parseInt(input) == nTF) {
                g++;
                System.out.println("Thank you!");
            } else if(input.length() <= 0) {
                System.out.println("Please Enter a Number!");
            }else{
                System.out.println("That number was not found that many times on your board, please take a second look!");
            }
        }

        board.removeNums(brd, rN);

        System.out.println("\nThe number was found " + nTF +" times on your board!");

        board.printBoard(brd);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }

        System.out.println("\n\n");

        int k = -1;
        String inp = " ";
        while(k < 0) {
            inp = JOptionPane.showInputDialog("Would you like to continue the game? Y/N ");
            if (input.length() > 0) {
                k++;
                System.out.println("Thank you!");
            } else if(input.length() <= 0) {
                System.out.println("Please Enter Y or N!");
            }
        }

        if(inp.equalsIgnoreCase("Y")){

            yon = true;

        } else {

            yon = false;

        }

    }

    public boolean checkForFourSides(bingoo deoB, int[][] Tw){

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

    public boolean checkForT(bingoo deoB, int[][] Tw){

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

    public boolean checkForFourCorners(bingoo deoB, int[][] Tw){

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

        } else {

            BINGO = false;

        }

        return BINGO;

    }

    public boolean checkForBingo(bingoo deobi, int[][] brd){

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
