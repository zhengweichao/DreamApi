package top.vchao.dream.v1.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class ScheduledTask {
    private int i;

    /**
     * 定时执行
     * <p>
     * cron: [秒] [分] [时] [日] [月] [周] [年]
     * 注：[年]不是必须的域，可以省略[年]，则一共6个域
     */
    @Scheduled(cron = "0 * * * * ?")
    public void execute() {
//        System.out.println("每分钟定时执行的任务----->" + ++i);
    }
}
