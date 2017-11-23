package com.github.antksk.java8_training.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class _00_Introduction {


    @Value(staticConstructor = "of")
    static class Printer implements  Runnable{
        private String message;

        @Override
        public void run() {
            for(int i = 0; 100_000 > i; ++i){
                System.out.println(message);
            }
        }
    }

    @Test
    public  void ThreadFactoryTest() {
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(Printer.of("Nice")).start();
        for(int i = 0; 100_000 > i; ++i){
            System.out.println("Good");
        }
    }

    @AllArgsConstructor(staticName = "of")
    @Getter
    static class Bank{
        private int money;
        private String name;

        public synchronized void deposit(int m){
            money += m;
        }

        public synchronized boolean withDraw(final int m){
            // 인출 가능
            if ( m <= money ){
                money -= m;
                return true;
            }
            // 인출 불가
            else{
                return false;
            }
        }
    }
}
