package com.poc.serviceimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.poc.models.User;
import com.poc.service.Processor;

@Component(value="fileprocessor")
public class FileProcessor implements Processor{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileProcessor.class);
	
	@Value("${file.path1}")
	private String filePath1;
	
	@Value("${file.path2}")
	private String filePath2;
	
	@Value("${file.path3}")
	private String filePath3;
	
	@Value("${file.path4}")
	private String filePath4;
	
	@Value("${process.url}")
	private String url;

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
        Thread t1 = new Thread(()->this.processUsersfromFile(filePath1));
        Thread t2 = new Thread(()->this.processUsersfromFile(filePath2));
        Thread t3 = new Thread(()->this.processUsersfromFile(filePath3));
        Thread t4 = new Thread(()->this.processUsersfromFile(filePath4));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
	}	

	@Override
	public void process(User user) {
		// TODO Auto-generated method stub
		processUsers(user);
	}
	
	private static void logInfo(String msg){
		if(LOGGER.isInfoEnabled()){
			LOGGER.info(msg);
		}
	}
	
	private void processUsersfromFile(String path) {
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(cvsSplitBy);
                logInfo("++++read column+++"+columns[0]+","+columns[1]);       
                this.processUsers(new User(columns[0], columns[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private void processUsers(User user) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.postForEntity(url, user, String.class);
        logInfo("++++done processing column+++ "+response.getStatusCode());
	}
}
