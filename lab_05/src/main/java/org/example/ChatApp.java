package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Класс для представления нового сообщения
class Message {
    private int messageId;
    private String chatId;
    private String sender;
    private String content;

    public Message(int messageId, String chatId, String sender, String content) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.sender = sender;
        this.content = content;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getChatId() {
        return chatId;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }
}

// Класс для представления чата
class Chat {
    private String chatId;
    private List<Message> messages;
    private List<String> subscribers;

    public Chat(String chatId) {
        this.chatId = chatId;
        messages = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public String getChatId() {
        return chatId;
    }

    public void addMessage(Message message) {
        messages.add(message);
        notifySubscribers(message);
    }

    public void subscribe(String userId) {
        subscribers.add(userId);
    }

    public void unsubscribe(String userId) {
        subscribers.remove(userId);
    }

    private void notifySubscribers(Message message) {
        for (String userId : subscribers) {
            System.out.println("Уведомление для пользователя " + userId + ": Новое сообщение в чате " + chatId + " от " + message.getSender() + ": " + message.getContent());
        }
    }
}

// Класс для представления пользователя
class User {
    private String userId;
    private List<String> subscribedChats;

    public User(String userId) {
        this.userId = userId;
        subscribedChats = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void subscribeToChat(Chat chat) {
        subscribedChats.add(chat.getChatId());
        chat.subscribe(userId);
    }

    public void unsubscribeFromChat(Chat chat) {
        subscribedChats.remove(chat.getChatId());
        chat.unsubscribe(userId);
    }
}

public class ChatApp {
    public static void main(String[] args) {
        // Создание чатов
        Chat chat1 = new Chat("chat1");
        Chat chat2 = new Chat("chat2");

        // Создание пользователей
        User user1 = new User("user1");
        User user2 = new User("user2");

        // Подписка пользователей на чаты
        user1.subscribeToChat(chat1);
        user2.subscribeToChat(chat1);
        user2.subscribeToChat(chat2);

        // Отправка сообщений в чаты
        Message message1 = new Message(1, "chat1", "user1", "Привет, как дела?");
        chat1.addMessage(message1);

        Message message2 = new Message(2, "chat1", "user2", "Привет, все хорошо, спасибо!");
        chat1.addMessage(message2);

        Message message3 = new Message(3, "chat2", "user2", "Здравствуй, что нового?");
        chat2.addMessage(message3);

        // Отписка пользователя от чата
        user2.unsubscribeFromChat(chat1);

        Message message4 = new Message(4, "chat1", "user1", "Какие планы на выходные?");
        chat1.addMessage(message4);
    }
}