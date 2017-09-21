package org.testo.metric.kafka;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.testo.core.model.WorkUnit;

@Service
public class KafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "workunits")
    public void onReceiving(WorkUnit workUnit, @Header(KafkaHeaders.OFFSET) Integer offset,
                            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Processing topic = {}, partition = {}, offset = {}, workUnit = {}",
                topic, partition, offset, workUnit.getDefinition());
        Map<String,Object> params = workUnit.getParams();
        if (params != null) {
        	log.info("Service " + params.get("service"));
        }
    }
}
