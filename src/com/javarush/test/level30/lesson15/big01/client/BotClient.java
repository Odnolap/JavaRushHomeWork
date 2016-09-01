package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Odnolap on 02.07.2016.
 */
public class BotClient extends Client
{
    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            if (message == null || message.isEmpty() || !message.contains(": "))
                return;

            String userName = message.substring(0, message.indexOf(": "));
            String messageText = message.substring(message.indexOf(": ") + 2);
            SimpleDateFormat sdf = null;
            switch (messageText) {
                case "дата": sdf = new SimpleDateFormat("d.MM.YYYY"); break;
                case "день": sdf = new SimpleDateFormat("d"); break;
                case "месяц": sdf = new SimpleDateFormat("MMMM"); break;
                case "год": sdf = new SimpleDateFormat("YYYY"); break;
                case "время": sdf = new SimpleDateFormat("H:mm:ss"); break;
                case "час": sdf = new SimpleDateFormat("H"); break;
                case "минуты": sdf = new SimpleDateFormat("m"); break;
                case "секунды": sdf = new SimpleDateFormat("s"); break;
            }
            if (sdf != null) {
                Calendar calendar = Calendar.getInstance();
                String answer = "Информация для " + userName + ": "+ sdf.format(calendar.getTime());
                sendTextMessage(answer);
            }
        }
    }
}
