package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TaskDto;
import com.example.demo.services.TaskService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class DemoController {

	HttpHeaders headers;

	private TaskService taskService;

	public DemoController() {
		taskService = new TaskService();
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<String> status() {

		return new ResponseEntity<>("Service OK", headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<TaskDto> generateBalance(@RequestBody TaskDto task) {

		System.out.println("Service OK " + task.getName() + " " + task.getUrl() + " " + task.getTypetaskaction());
		Map<String, String> responseURL = taskService.sendRequestUrl(task);

		if (responseURL.get("responseCode") != null && !responseURL.get("responseCode").equals("")) {
			task.setStatus(responseURL.get("responseCode"));
		} else {
			task.setStatus("Error 500");
		}

		if (responseURL.get("response") != null && !responseURL.get("response").equals("")) {
			task.setResponse(responseURL.get("response"));
		} else {
			task.setResponse("Error to response body");
		}

		return new ResponseEntity<>(task, headers, HttpStatus.OK);

	}
}
