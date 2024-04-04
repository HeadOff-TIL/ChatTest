package org.example.chattest.chatMessage.config;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.chattest.chatMessage.Domain.KafkaMessageDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareRebalanceListener;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@EnableKafka
@Configuration
public class ConsumerConfiguration {
    // KafkaListener 컨테이너 팩토리를 생성하는 Bean 메서드
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaMessageDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, KafkaMessageDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        ContainerProperties prop = factory.getContainerProperties();
        prop.setConsumerRebalanceListener(rebalanceListener());
        return factory;
    }

    // Kafka ConsumerFactory를 생성하는 Bean 메서드
    @Bean
    public ConsumerFactory<String, KafkaMessageDTO> consumerFactory() {
        JsonDeserializer<KafkaMessageDTO> deserializer = new JsonDeserializer<>();
        // 패키지 신뢰 오류로 인해 모든 패키지를 신뢰하도록 작성
        deserializer.addTrustedPackages("*");

        // Kafka Consumer 구성을 위한 설정값들을 설정 -> 변하지 않는 값이므로 ImmutableMap을 이용하여 설정
        Map<String, Object> consumerConfigurations =
                ImmutableMap.<String, Object>builder()
                        .put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_BROKER)
                        .put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID)
                        .put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class)
                        .put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer)
                        .put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest")
                        .build();

        return new DefaultKafkaConsumerFactory<>(consumerConfigurations, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConsumerAwareRebalanceListener rebalanceListener() {
        return new ConsumerAwareRebalanceListener() {
            @Override
            public void onPartitionsAssigned(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
                // here partitions
                List<Integer> partList = new ArrayList<>();
                for (TopicPartition partition : partitions) {
                    int partition1 = partition.partition();
                    partList.add(partition1);
                    log.info("사용중인파티션:{}", partition1);
                }
                KafkaConstants.partitionList = partList;
            }
        };
    }

}
