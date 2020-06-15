package com;

import java.util.Objects;

public class Circle {
    private final int firstCoordinate;
    private final int secCoordinate;
    private final int radius;

    public Circle(int firstCoordinate, int secCoordinate, int radius) {
        this.firstCoordinate = firstCoordinate;
        this.secCoordinate = secCoordinate;
        this.radius = radius;
    }

    public int getFirstCoordinate() {
        return firstCoordinate;
    }

    public int getSecCoordinate() {
        return secCoordinate;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "(" + firstCoordinate +
                ";" + secCoordinate +
                ") with r=" + radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return firstCoordinate == circle.firstCoordinate &&
                secCoordinate == circle.secCoordinate &&
                radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCoordinate, secCoordinate, radius);
    }
}
