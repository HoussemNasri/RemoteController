package com.company;

public interface Receiver {
    boolean connect(int port);
    boolean disconnect();
}
