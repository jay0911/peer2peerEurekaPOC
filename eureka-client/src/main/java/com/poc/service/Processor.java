package com.poc.service;

import com.poc.models.User;

public interface Processor {
	public void process();
	public void process(User user);
}
