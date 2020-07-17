package com.company;

public class RemoteReceiverThread extends Thread {
    public Receiver receiver;
    private boolean running = false;

    RemoteReceiverThread(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        System.out.println("Starting...");
        System.out.println("Waiting for Commands...");
        running = true;
        while (running) {
            receiver.connect();
            System.out.println("->connect<-");
        }
    }

    public void disconnect() {
        running = false;
        stop();
    }
}
