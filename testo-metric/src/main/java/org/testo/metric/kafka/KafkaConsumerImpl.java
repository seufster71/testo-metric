package org.testo.metric.kafka;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.testo.core.model.KafkaMsg;
import org.testo.metric.model.Message;

@Service("KafkaConsumer")
public class KafkaConsumerImpl implements KafkaConsumer {

	@Autowired
	MessageDao messageDao;
	
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerImpl.class);

    @KafkaListener(topics = "workunits")
    public void onReceiving(KafkaMsg kafkaMsg, @Header(KafkaHeaders.OFFSET) Integer offset,
                            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Processing topic = {}, partition = {}, offset = {}, kafkaMsg = {}",
                topic, partition, offset, kafkaMsg.getDefinition());
        Map<String,Object> params = kafkaMsg.getParams();
        if (params != null) {
        	log.info("Service " + params.toString());
        	
        	Message message = new Message(kafkaMsg.getDefinition());
        	
        	try {
				String r = messageDao.save(message);
				log.info("Save result " + r);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
