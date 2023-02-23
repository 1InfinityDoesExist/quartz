package in.quartz.learn.trigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificationJobTrigger {

	public Trigger notificationJobTrigger() {

		Trigger trigger = TriggerBuilder.newTrigger()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(1).repeatForever()).build();

		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("crontrigger", "crontriggergroup1")
				.withSchedule(CronScheduleBuilder.cronSchedule("10 * * * * ?")).build();

		return trigger;

	}
}
