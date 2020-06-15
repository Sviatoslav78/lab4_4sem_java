package com;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.Math.*;

public class CollectionProcessing {
    private Collection<Circle> circles;

    public void createCircles() {
        circles = new HashSet<>();
        int circlesNumber = getCirclesNumber();

        for (int i = 0; i < circlesNumber; i++) {
            circles.add(new Circle((int) (random() * 20 - 10),
                    (int) (random() * 20 - 10),
                    (int) (random() * 5 + 1)));
        }
    }

    private int getCirclesNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.println("How many circles do you wanna create?");
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine().trim());
                if (number > 1) {
                    return number;
                } else {
                    System.out.println("enter value > 1, please");
                }
            } catch (NumberFormatException e) {
                System.out.println("enter int value > 1, please");
            }
        }
    }

    public void analiseCircles() {
        Iterator<Circle> iterator = circles.iterator();
        Circle currentCircle;
        Circle anotherCircle;
        boolean circlesRelations = false;

        int i = 1;
        while (iterator.hasNext()) {
            Iterator<Circle> anotherIterator = circles.iterator();
            currentCircle = iterator.next();

            for (int j = 0; j < i; j++) {
                anotherIterator.next();
            }

            while (anotherIterator.hasNext()) {
                anotherCircle = anotherIterator.next();

                if (getCirclesDistance(currentCircle, anotherCircle) == 0) {
                    showCirclesCompare("touch", currentCircle, anotherCircle);
                    circlesRelations = true;
                } else if (getCirclesDistance(currentCircle, anotherCircle) < 0) {
                    showCirclesCompare("cross", currentCircle, anotherCircle);
                    circlesRelations = true;
                }
            }
            i++;
        }
        if (!circlesRelations) System.out.println("No circles that touch or cross each other");
    }

    private double getCirclesDistance(Circle first, Circle second) {
        return sqrt(pow(second.getFirstCoordinate() - first.getFirstCoordinate(), 2) +
                pow(second.getSecCoordinate() - first.getSecCoordinate(), 2)) -
                (first.getRadius() + second.getRadius());
    }

    private void showCirclesCompare(String condition, Circle first, Circle second) {
        System.out.println("Circles " + first.toString() + " and " +
                second.toString() + " " + condition + " each other");
    }

    public void showAllCircles() {
        System.out.println("Here are all circles:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
        System.out.println();
    }

}
