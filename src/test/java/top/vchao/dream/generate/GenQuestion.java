package top.vchao.dream.generate;

import org.junit.jupiter.api.Test;

public class GenQuestion {

    @Test
    public void genQuestionCode() {
        System.out.println("====>  start generate question code  <====");
        String moduleName = "question";
        String tableName = "pro_question";

        GenCommon.getAutoGenerator(moduleName, tableName)
                .strategyConfig(builder -> {
                    builder.addFieldPrefix("qt_");
                })
                .execute();

        System.out.println("====>  end generate question code  <====");

    }
}
