package com.geoin.iot.modules.OneNet.api.device;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geoin.iot.modules.OneNet.api.AbstractAPI;
import com.geoin.iot.modules.OneNet.exception.OnenetApiException;
import com.geoin.iot.modules.OneNet.http.HttpGetMethod;
import com.geoin.iot.modules.OneNet.request.RequestInfo.Method;
import com.geoin.iot.modules.OneNet.response.BasicResponse;
import com.geoin.iot.modules.OneNet.response.device.DeciceLatestDataPoint;
import com.geoin.iot.modules.OneNet.utils.Config;

public class GetLatesDeviceData extends AbstractAPI{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private HttpGetMethod HttpMethod;
	private String devIds;
	
	/**
	 * 批量查询设备最新数据
	 * 参数顺序与构造函数顺序一致
	 * @param devIds :设备id用逗号隔开, 限制1000个设备,String
	 * @param key:masterkey 
	 */
	
	public GetLatesDeviceData(String devIds, String key) {
		this.devIds = devIds;
		this.key = key;
		this.method = Method.GET;
		this.HttpMethod=new HttpGetMethod(method);
		this.url = Config.getString("test.url") + "/devices/datapoints";
		Map<String, Object> headmap = new HashMap<String, Object>();
		Map<String, Object> urlmap = new HashMap<String, Object>();
		if(devIds!=null){
			urlmap.put("devIds", devIds);
		}
		headmap.put("api-key", key);
        HttpMethod.setHeader(headmap);
        HttpMethod.setcompleteUrl(url,urlmap);
	}
	
	public BasicResponse<DeciceLatestDataPoint> executeApi() {
		BasicResponse response=null;
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		try {
			HttpResponse httpResponse=HttpMethod.execute();
			response = mapper.readValue(httpResponse.getEntity().getContent(), BasicResponse.class);
			response.setJson(mapper.writeValueAsString(response));
			Object newData = mapper.readValue(mapper.writeValueAsString(response.getDataInternal()), DeciceLatestDataPoint.class);
			response.setData(newData);
			return response;
		} catch (Exception e) {
			logger.error("json error {}", e.getMessage());
			throw new OnenetApiException(e.getMessage());
		}
		finally {
			try {
				HttpMethod.httpClient.close();
			} catch (Exception e) {
				logger.error("http close error: {}", e.getMessage());
				throw new OnenetApiException(e.getMessage());
			}
		}
	
	}
}