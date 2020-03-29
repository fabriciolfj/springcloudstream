package br.com.stream.practice.domain.api;

import br.com.stream.practice.domain.model.LogMessage;
import br.com.stream.practice.domain.service.messaging.ProducerLogMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class LogMessageController {

    private final ProducerLogMessage producerLogMessage;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void send(@RequestBody LogMessage logMessage) throws JsonProcessingException {
        producerLogMessage.process(logMessage);
    }
}
