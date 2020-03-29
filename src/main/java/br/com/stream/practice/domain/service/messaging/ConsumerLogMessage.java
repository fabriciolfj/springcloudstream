package br.com.stream.practice.domain.service.messaging;

import br.com.stream.practice.domain.configuration.MyProcessor;
import br.com.stream.practice.domain.model.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerLogMessage {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerLogMessage.class);

    @StreamListener(target = MyProcessor.INPUT)
    public void consumer(LogMessage logMessage) {
        LOG.info(logMessage.toString());
    }
}
