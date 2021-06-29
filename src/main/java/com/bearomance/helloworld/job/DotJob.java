package com.bearomance.helloworld.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DotJob {

    @Scheduled(fixedRate = 600000)
    public void dot() {
        log.info("...");
    }
}
