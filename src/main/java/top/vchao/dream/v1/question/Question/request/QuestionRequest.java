package top.vchao.dream.v1.question.Question.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import top.vchao.dream.v1.pojo.request.PageRequest;

/**
 * 面试题目请求体
 */
@Getter
@Setter
public class QuestionRequest extends PageRequest implements Serializable {

    @NotNull(message = "请输入id", groups = {delete.class, update.class, detail.class})
    @Min(value = 1, message = "请输入合法id", groups = {delete.class, update.class, detail.class})
    private Integer id;

    /**
     * 题目标题
     */
    @NotBlank(message = "请输入题目标题", groups = {add.class})
    private String title;

    /**
     * 难度等级[1高、2中、3低]
     */
    @NotNull(message = "请输入难度等级[1高、2中、3低]", groups = {add.class})
    private Integer level;

    /**
     * 内容
     */
    @NotBlank(message = "请输入内容", groups = {add.class})
    private String content;

    /**
     * 考验能力
     */
    @NotBlank(message = "请输入考验能力", groups = {add.class})
    private String ability;

    /**
     * 类型[1单选、2判断、3问答]
     */
    @NotNull(message = "请输入类型[1单选、2判断、3问答]", groups = {add.class})
    private Integer type;

    /**
     * 答案概要
     */
    @NotBlank(message = "请输入答案概要", groups = {add.class})
    private String answer;

    /**
     * 备注
     */
    @NotBlank(message = "请输入备注", groups = {add.class})
    private String remark;

}