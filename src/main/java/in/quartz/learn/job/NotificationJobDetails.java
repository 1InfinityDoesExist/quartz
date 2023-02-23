package in.quartz.learn.job;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.stereotype.Component;

@Component
public class NotificationJobDetails {

	public JobDetail notificationJobDetails() {
		JobDetail jobDetail = JobBuilder.newJob(NotificationJob.class).withIdentity("notify").build();
		return jobDetail;
	}

}
