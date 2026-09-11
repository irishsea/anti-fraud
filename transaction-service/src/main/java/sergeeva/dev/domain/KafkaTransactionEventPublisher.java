package sergeeva.dev.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import sergeeva.dev.kafka.TransactionEvent;

@Component
@RequiredArgsConstructor
public class KafkaTransactionEventPublisher implements TransactionEventPublisher {

    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;
    private final String topic;

    @Override
    public void publish(TransactionEvent event) {
        /**
         * TODO Sergeeva: нужно ожидать подтверждения принятие ивента.
         * Синхронное ожидание? Другие способы?
         */
        kafkaTemplate.send(topic, event.userId(), event);
    }
}
