package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("localhost", 8989);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String request = "{\"title\": \"булка\", \"date\": \"2022.02.08\", \"sum\": 200}";
            out.println(request);

            String category = in.readLine();
            System.out.println(category);
        }
    }
}
