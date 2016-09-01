package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Odnolap on 25.06.2016.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Enter a port number:");
        int portNumber = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(portNumber))
        {
            ConsoleHelper.writeMessage("Server is running.");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        for (Connection connection : connectionMap.values()) {

            try
            {
                connection.send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Error on sending broadcast message!");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message nameRequestMessage = new Message(MessageType.NAME_REQUEST);

            while (true) {

                connection.send(nameRequestMessage);
                Message answer = connection.receive();
                String userName = answer.getData();

                if (answer.getType() == MessageType.USER_NAME
                        && userName != null
                        && !userName.isEmpty()
                        && !connectionMap.containsKey(userName)) {
                    connectionMap.put(userName, connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    return userName;
                }

            }

        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String addedUserName : connectionMap.keySet()) {
                if (!addedUserName.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, addedUserName));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message inputMessage = connection.receive();
                if (inputMessage.getType() != MessageType.TEXT) {
                    ConsoleHelper.writeMessage("Error! This message is not text!");
                } else {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + inputMessage.getData()));
                }

            }
        }

        @Override
        public void run() {
            String newUserName = null;
            try (Connection connection = new Connection(socket)) {
                ConsoleHelper.writeMessage("New connection is established. Address is " + connection.getRemoteSocketAddress());
                newUserName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUserName));
                sendListOfUsers(connection, newUserName);
                serverMainLoop(connection, newUserName);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("An error occurred when communicating with a remote server  ");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error occurred when communicating with a remote server  ");
            }

            if (newUserName != null) {
                connectionMap.remove(newUserName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUserName));
            }

            ConsoleHelper.writeMessage("Connection is closed: ");
        }
    }
}
