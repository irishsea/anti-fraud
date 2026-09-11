package sergeeva.dev.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sergeeva.dev.api.CreateTransactionRequest;
import sergeeva.dev.kafka.TransactionEvent;

import java.time.Clock;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {

    public static int SCHEMA_VERSION = 1;

    private final TransactionEventPublisher publisher;
    private final Clock clock;

    public TransactionEvent create(CreateTransactionRequest request) {
        TransactionEvent event = new TransactionEvent(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                request.userId(),
                request.merchantId(),
                request.amount(),
                request.currency(),
                request.country(),
                request.deviceId(),
                Instant.now(clock),
                SCHEMA_VERSION);

        publisher.publish(event);
        return event;
    }
}
