package in.quartz.learn.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.quartz.learn.job.NotificationJobDetails;
import in.quartz.learn.trigger.NotificationJobTrigger;

@Component
public class NotificationJobScheduler {

	@Autowired
	private NotificationJobDetails notificationJobDetails;

	@Autowired
	private NotificationJobTrigger notificationJobTrigger;

	public void scheduleJob() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(notificationJobDetails.notificationJobDetails(),
				notificationJobTrigger.notificationJobTrigger());
	}

}
