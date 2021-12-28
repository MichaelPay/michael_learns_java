package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Contacts michael = new Contacts();
        Scanner in = new Scanner(System.in);
        System.out.print("What's your Name? \n");
        michael.setName(in.nextLine());
        System.out.print("What's your Address? \n");
        michael.setAddress(in.nextLine());
        System.out.print("What's your Age? \n");
        michael.setAge(in.nextInt());
        System.out.println("Hi, " + michael.getName() + "!\nYou seem to be living at: " + michael.getAddress() + "\n"
                + "And you're " + String.valueOf(michael.getAge()) + " years old!");

    }
}
