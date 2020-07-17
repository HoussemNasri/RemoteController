package com.company;

import com.company.exception.IncompatibleCommandException;
import com.company.exception.UnsupportedCommandException;
import com.company.executor.CommandExecutor;
import com.company.executor.CommandExecutorFactory;
import com.company.shared.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteReceiver implements Receiver {
    public static final int PORT = 25481;
    private ServerSocket serverSocket;

    public RemoteReceiver() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean connect() {
        try {
            Socket clientSocket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
            Command command = (Command) inputStream.readObject();
            CommandExecutor executor = CommandExecutorFactory.create(command);

            try {
                executor.execute();
            } catch (IncompatibleCommandException | UnsupportedCommandException e) {
                e.printStackTrace();
            }

        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public boolean disconnect() throws IOException {
        serverSocket.close();
        return false;
    }
}
