package com.company;

import java.io.IOException;

public interface Receiver {
    boolean connect();
    boolean disconnect() throws IOException;
}
