package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Thread.sleep(5000L);
        robot.keyPress(KeyEvent.VK_E);
    }
}
