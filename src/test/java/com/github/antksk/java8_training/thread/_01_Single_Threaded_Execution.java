package com.github.antksk.java8_training.thread;

import org.junit.jupiter.api.Test;

public class _01_Single_Threaded_Execution {
    static class Gate{
        private int counter;
        private String name;
        private String address;

        public Gate(){
            counter = 0;
            name = "Nobody";
            address = "Nowhere";
        }

        public synchronized void pass(String name, String address){
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        }

        public String toString(){
            return "No." + counter + " : " + name + ", " + address;
        }

        public void check(){
            if( name.charAt(0) != address.charAt(0) ){
                System.out.println("***** BROKEN *****" + toString());
            }
        }
    }

    static class UserThread extends  Thread{
        private final Gate gate;
        private final String name;
        private final String address;

        public UserThread(Gate gate, String name, String address){
            this.gate = gate;
            this.name = name;
            this.address = address;
        }

        public void run(){
            System.out.println(name + " BEGIN");
            while(true){
                gate.pass(name,address);
            }
        }
    }

    @Test
    public void test(){
        System.out.println("Testing Gate. hit CTRL+C to exit.");
        Gate gate = new Gate();

        new UserThread( gate, "Alice", "Alask").start();
        new UserThread( gate, "Bobby", "Brazil").start();
        new UserThread( gate, "Chris", "Canada").start();
    }
}
