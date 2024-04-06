package org.example.chattest.chatMessage.config;

import java.util.List;
import java.util.UUID;

public class KafkaConstants {
    private static String name = UUID.randomUUID().toString();
    public static final String KAFKA_TOPIC = "chat-topic";
    public static final String GROUP_ID = name;
    public static final String KAFKA_BROKER = "localhost:9092";
    public static List<Integer> partitionList;
}
