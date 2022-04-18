package top.vchao.dream.generate.modules;

import org.junit.jupiter.api.Test;

/**
 * 生成代码
 */
public class GenCodeTest extends BaseGenTest {

    @Test
    public void genQuestionCode() {
        genCode("question", "pro_question", "qt_");
    }

    @Test
    public void genTaskCode() {
        genCode("task", "pro_task", "task_");
    }
}
