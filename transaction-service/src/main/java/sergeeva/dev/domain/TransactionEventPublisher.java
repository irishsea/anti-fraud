package sergeeva.dev.domain;

import sergeeva.dev.kafka.TransactionEvent;

public interface TransactionEventPublisher {

    void publish(TransactionEvent event);
}
