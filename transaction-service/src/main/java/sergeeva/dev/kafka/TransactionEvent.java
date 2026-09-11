package sergeeva.dev.kafka;

import java.math.BigDecimal;
import java.time.Instant;

public record TransactionEvent(
        String eventId,
        String transactionId,
        String userId,
        String merchantId,
        BigDecimal amount,
        String currency,
        String country,
        String deviceId,
        Instant eventTime,
        int schemaVersion
) {}

