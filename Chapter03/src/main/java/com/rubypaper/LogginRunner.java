package com.rubypaper;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LogginRunner implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.trace("TRACE 로그 메시지");
		log.debug("DEBUG 로그 메시지");
		log.info("INFO 로그 메시지");
		log.warn("WARN 로그 메시지");
		log.error("ERROR 로그 메시지");	
	}
}
