package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            System.out.println("New connection accepted");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    String request = in.readLine();
                    MaxCategory.saveRequest(request);
                    JsonObject dataCat = new JsonObject();
                    JsonObject answer = new JsonObject();
                    dataCat.add("category", new JsonPrimitive(MaxCategory.maxCategory(request).getKey()));
                    dataCat.add("sum", new JsonPrimitive(MaxCategory.maxCategory(request).getValue()));
                    answer.add("maxCategory", dataCat);
                    out.println(answer);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
