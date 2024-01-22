package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplication {
    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplication.class);

    public CustomWebApplication(int port) {
        this.port = port;
    }

    public void start() throws IOException{
        try(ServerSocket serverSocket = new ServerSocket(port)){
            logger.info("[CustomWebApplicatioinServer] started {} port", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicatioinServer] waiting for client");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicatioinServer] connected!");

                // 사용자 요청을 메인 Thread가 처리하도록
                try(InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);
                }
            }
        }
    }
}
