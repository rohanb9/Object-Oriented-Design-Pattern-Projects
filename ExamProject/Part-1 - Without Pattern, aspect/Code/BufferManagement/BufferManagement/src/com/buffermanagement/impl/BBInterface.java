package com.buffermanagement.impl;

import com.buffermanagement.exception.BBException;

public interface BBInterface {
	int getRequest() throws BBException;
	void putRequest(int val) throws BBException;
}
