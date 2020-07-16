package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {
        RemoteReceiverThread receiverThread = new RemoteReceiverThread();
        receiverThread.start();
    }
}
