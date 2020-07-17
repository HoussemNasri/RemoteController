package com.company.ui;

import com.company.RemoteReceiverThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Window extends JFrame {
    private boolean isServerUp = false;

    public Window(int width, int height, RemoteReceiverThread thread) {
        this.setLayout(new BorderLayout());
        this.setTitle("Remote Station");
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String> interfacesBox = new JComboBox<>();

        JLabel ipLabel = new JLabel();
        ipLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ipLabel.setFont(new Font("", Font.BOLD, 40));

        Button serverControl = new Button("start server");
        serverControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isServerUp){
                    thread.disconnect();
                    try {
                        thread.receiver.disconnect();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    serverControl.setLabel("start server");
                    isServerUp = false;
                }
                else {
                    thread.start();
                    serverControl.setLabel("stop server");
                    isServerUp = true;
                }
            }
        });

        List<NetworkInterface> networkInterfaces = getAllNetworkInterfaces();
        List<InetAddress> ipAddresses = getAllIpAddresses(networkInterfaces);

        for (NetworkInterface iface : networkInterfaces) {
            interfacesBox.addItem(iface.getDisplayName());
        }

        interfacesBox.addItemListener(e -> {
            int selected = interfacesBox.getSelectedIndex();
            ipLabel.setText(ipAddresses.get(selected).getHostAddress());
        });

        int selected = interfacesBox.getSelectedIndex();
        ipLabel.setText(ipAddresses.get(selected).getHostAddress());

        this.add(interfacesBox, BorderLayout.NORTH);
        this.add(ipLabel, BorderLayout.CENTER);
        this.add(serverControl, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public List<NetworkInterface> getAllNetworkInterfaces() {
        List<NetworkInterface> networkInterfaces = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp())
                    continue;
                networkInterfaces.add(iface);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        return networkInterfaces;
    }

    public List<InetAddress> getAllIpAddresses(List<NetworkInterface> interfaces) {
        List<InetAddress> addresses = new ArrayList<>();
        for (NetworkInterface inter : interfaces) {
            Enumeration<InetAddress> adrs = inter.getInetAddresses();
            addresses.add(adrs.nextElement());
        }
        return addresses;
    }

}
