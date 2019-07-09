package com.geoin.iot.modules.OneNet.api.dtu;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.geoin.iot.modules.OneNet.api.AbstractAPI;
import com.geoin.iot.modules.OneNet.exception.OnenetApiException;
import com.geoin.iot.modules.OneNet.http.HttpDeleteMethod;
import com.geoin.iot.modules.OneNet.request.RequestInfo.Method;
import com.geoin.iot.modules.OneNet.response.BasicResponse;
import com.geoin.iot.modules.OneNet.utils.Config;

public class DeleteDtuParser extends AbstractAPI {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private Integer id;
	private HttpDeleteMethod HttpMethod;

	/**
	 * TCP透传parser删除
	 * @param id:parser_id,Integer
	 * @param key:masterkey 或者 设备key
	 */
	public DeleteDtuParser(Integer id, String key) {
		this.id = id;
		this.key = key;
		this.method = Method.DELETE;
		Map<String, Object> headmap = new HashMap<String, Object>();
		HttpMethod = new HttpDeleteMethod(method);
		headmap.put("api-key", key);
		HttpMethod.setHeader(headmap);
		if (id == null) {
			throw new OnenetApiException("parser id is required ");
		}
		this.url = Config.getString("test.url") + "/dtu/parser/" +id;
		HttpMethod.setcompleteUrl(url, null);
	}
	public BasicResponse<Void> executeApi() {
		BasicResponse response = null;
		try {
			HttpResponse httpResponse = HttpMethod.execute();
			response = mapper.readValue(httpResponse.getEntity().getContent(), BasicResponse.class);
			response.setJson(mapper.writeValueAsString(response));
			return response;
		} catch (Exception e) {
			logger.error("json error {}", e.getMessage());
			throw new OnenetApiException(e.getMessage());
		}finally {
			try {
				HttpMethod.httpClient.close();
			} catch (Exception e) {
				logger.error("http close error: {}", e.getMessage());
				throw new OnenetApiException(e.getMessage());
			}
		}
	
	}
}
