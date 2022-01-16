package top.vchao.dream.v1.question.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
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
     * 题目
     */
    @TableField("qt_title")
    private String title;

    /**
     * 难度
     */
    @TableField("qt_level")
    private Integer level;

    /**
     * 题目内容
     */
    @TableField("qt_content")
    private String content;

    /**
     * 题目考验能力
     */
    @TableField("qt_ability")
    private String ability;

    /**
     * 题目类型-[1单选、2判断、3问答]
     */
    @TableField("qt_type")
    private Integer type;

    /**
     * 题目答案（问答题均略）
     */
    @TableField("qt_answer")
    private String answer;

    /**
     * 题目备注
     */
    @TableField("qt_remark")
    private String remark;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除[0否,1是]
     */
    @TableField("deleted")
    @TableLogic
    private Boolean deleted;


}
