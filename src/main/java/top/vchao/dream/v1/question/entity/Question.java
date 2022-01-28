package top.vchao.dream.v1.question.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 面试题目
 * </p>
 *
 * @author vchao
 * @since 2022-01-16
 */
@Getter
@Setter
@TableName("pro_question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目标题
     */
    @TableField("qt_title")
    private String title;

    /**
     * 难度等级[1高、2中、3低]
     */
    @TableField("qt_level")
    private Integer level;

    /**
     * 内容
     */
    @TableField("qt_content")
    private String content;

    /**
     * 考验能力
     */
    @TableField("qt_ability")
    private String ability;

    /**
     * 类型[1单选、2判断、3问答]
     */
    @TableField("qt_type")
    private Integer type;

    /**
     * 答案概要
     */
    @TableField("qt_answer")
    private String answer;

    /**
     * 备注
     */
    @TableField("qt_remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除[0否,1是]
     */
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;


}
