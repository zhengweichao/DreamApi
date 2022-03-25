package top.vchao.dream.v1.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz定时任务配置类
 */
@Configuration
@Slf4j
public class SqlExecScheduler {

    private static String JOB_GROUP_NAME = "SQL_JOB_GROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "SQL_TRIGGER_GROUP_NAME";

    /**
     * 定时查询 question 总数（触发器）
     */
    @Bean
    public Trigger sqlExecTrigger() {
        //每隔5秒执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/15 * * * * ?");

        //创建触发器
        return TriggerBuilder.newTrigger()
                .forJob(sqlExecDetail())//关联上述的JobDetail
                .withIdentity("sqlExecTrigger", TRIGGER_GROUP_NAME)//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    /**
     * 定时查询 question 总数（任务详情）
     */
    @Bean
    public JobDetail sqlExecDetail() {
        return JobBuilder.newJob(SqlExecJob.class)
                .withIdentity("sqlExecDetail", JOB_GROUP_NAME)
                .usingJobData("sqlName", "定时查询问题表总数")
                .usingJobData("sql", "SELECT count(*) as conut FROM pro_question")
                .storeDurably() //即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }

}