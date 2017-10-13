package com.lxjr.sudadai.utils;

import com.lxjr.sudadai.constants.BaseConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendMessage {

	private static final Logger logger = LoggerFactory.getLogger(SendMessage.class);

	public static String send(String content, String mobile) {
		String inputLine = "";
		try {
			StringBuilder sb = new StringBuilder("http://m.5c.com.cn/api/send/index.php");
			sb.append("?username=").append("gairui");
			sb.append("&password=").append("ml160816");
			sb.append("&apikey=").append("60f6119a17ca2127012b00287a6605f2");
			sb.append("&mobile=").append(mobile);
			sb.append("&content=").append(URLEncoder.encode(content, "GBK"));
			URL url = new URL(sb.toString());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			inputLine = in.readLine();
			logger.info(inputLine);
		} catch (Exception e) {
			logger.error(BaseConstant.LOG_ERR_MSG + " send error:" + e, e);
		}
		return inputLine;

	}
}
