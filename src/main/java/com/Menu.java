package com;

import java.util.Scanner;

public class Menu {

    public static void startProgramme() {
        CollectionProcessing processing = new CollectionProcessing();
        Scanner scanner = new Scanner(System.in);

        do {
            processing.createCircles();
            processing.showAllCircles();
            processing.analiseCircles();

            System.out.println("\ndo you wanna continue? (1 - yes, 2 - no)");
        } while (scanner.nextLine().trim().equals("1"));
    }
}
