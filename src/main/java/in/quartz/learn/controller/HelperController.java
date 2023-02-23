package in.quartz.learn.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.quartz.learn.scheduler.NotificationJobScheduler;

@RestController
@RequestMapping("/v1.0/quartz")
public class HelperController {

	@Autowired
	private NotificationJobScheduler notificationJobScheduler;

	@GetMapping("/test")
	public ResponseEntity<?> runQuartz() throws SchedulerException {

		notificationJobScheduler.scheduleJob();
		return ResponseEntity.status(HttpStatus.OK).body(new ModelMap().addAttribute("msg", "Success"));

	}
}
