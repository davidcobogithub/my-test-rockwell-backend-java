package com.example.demo.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.models.TaskDto;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TaskService {

	private OkHttpClient httpclient;

	public TaskService() {
		httpclient = new OkHttpClient();
	}

	public Map<String, String> sendRequestUrl(TaskDto taskDto) {

		Map<String, String> responseURL = new HashMap<>();

		try {
			Request request = new Request.Builder().url(taskDto.getUrl()).get().addHeader("Accept", "*/*")
					.addHeader("Content-Type", "application/json; charset=utf-8").build();

			Response response = httpclient.newCall(request).execute();
			String responseCode = String.valueOf(response.code());
			String responseHeaders = String.valueOf(response.headers().toString());
			String responseBody = response.body().string();

			responseURL.put("response", responseBody);

			if (200 == Integer.parseInt(responseCode)) {
				responseURL.put("responseCode", responseCode);
			} else {
				responseURL.put("responseCode", responseCode);
			}
			
			if(taskDto.getTypetaskaction().equals("Scrape Headers")) {
				responseURL.put("response", responseHeaders);
			}
			response.close();

		} catch (IOException e) {
			responseURL.put("response", e.getMessage() + ". IOException");
		} catch (Exception i) {
			responseURL.put("response", i.getMessage() + ". Exception");
		}
		return responseURL;
	}

}
