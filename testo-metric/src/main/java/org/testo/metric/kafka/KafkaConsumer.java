package org.testo.metric.kafka;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.testo.core.model.KafkaMsg;

public interface KafkaConsumer {

	public void onReceiving(KafkaMsg kafkaMsg, @Header(KafkaHeaders.OFFSET) Integer offset,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic);
}
