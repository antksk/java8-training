package com.github.antksk.java8_training.basic;

import java.util.Arrays;

public class _00_01_enum {

    enum Operation {
        PLUS("+")   {double apply(double x, double y) {return x + y;}},
        MINUS("-")  {double apply(double x, double y) {return x - y;}},
        TIMES("*")  {double apply(double x, double y) {return x * y;}},
        DIVIDE("/") {double apply(double x, double y) {return x / y;}};

        private final String symbol;

        Operation(String symbol){
            this.symbol = symbol;
        }

        @Override
        public String toString(){
            return symbol;
        }

        abstract double apply(double x, double y);
    }

    public static void main(String[] args){
        double x = 10; // Double.parseDouble(args[0]);
        double y = 20; // Double.parseDouble(args[1]);
        Arrays.stream(Operation.values())
                .forEach(op->
                        System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x,y)));
    }
}
