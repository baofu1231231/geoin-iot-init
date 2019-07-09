package com.geoin.iot.modules.OneNet.api;


import com.geoin.iot.modules.OneNet.request.RequestInfo.Method;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractAPI <T>{
	public String key;
	public String url;
	public Method method;
    public ObjectMapper mapper = new ObjectMapper();
}
