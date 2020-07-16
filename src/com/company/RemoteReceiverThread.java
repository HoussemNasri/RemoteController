package com.company;

public class RemoteReceiverThread extends Thread {

    @Override
    public void run() {
        System.out.println("Starting...");
        System.out.println("Waiting for Commands...");

        Receiver receiver = new RemoteReceiver();
        while (true) {
            receiver.connect();
            System.out.println("->connect<-");
        }
    }
}
