package com.company;

import com.company.ui.Window;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {
        RemoteReceiver remoteReceiver = new RemoteReceiver();
        RemoteReceiverThread receiverThread = new RemoteReceiverThread(remoteReceiver);
        Window window = new Window(600, 600, receiverThread);
    }
}
