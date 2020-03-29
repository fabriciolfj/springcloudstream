package br.com.stream.practice.domain.service.messaging;

import br.com.stream.practice.domain.configuration.MyProcessor;
import br.com.stream.practice.domain.model.LogMessage;
import br.com.stream.practice.infrastructure.util.MessageBuild;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerLogMessage {

    private final MyProcessor myProcessor;

    public void process(LogMessage logMessage) throws JsonProcessingException {
        var json = new ObjectMapper().writeValueAsString(logMessage);
        var message = MessageBuild.message(json);
        myProcessor.anOutput().send(message);
    }
}
