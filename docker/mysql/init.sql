CREATE DATABASE `dream` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

use dream;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pro_question
-- ----------------------------
DROP TABLE IF EXISTS `pro_question`;
CREATE TABLE `pro_question`
(
    `id`          int                                                           NOT NULL AUTO_INCREMENT,
    `qt_title`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT '' COMMENT '题目标题',
    `qt_level`    tinyint                                                       NOT NULL DEFAULT 1 COMMENT '难度等级[1高、2中、3低]',
    `qt_content`  text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         NULL COMMENT '内容',
    `qt_ability`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '考验能力',
    `qt_type`     tinyint                                                       NULL     DEFAULT 3 COMMENT '类型[1单选、2判断、3问答]',
    `qt_answer`   text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         NULL COMMENT '答案概要',
    `qt_remark`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '备注',
    `create_time` datetime                                                      NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user` bigint                                                        NULL     DEFAULT NULL COMMENT '创建人',
    `update_time` datetime                                                      NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_user` bigint                                                        NULL     DEFAULT NULL COMMENT '更新人',
    `deleted`     tinyint(1)                                                    NOT NULL DEFAULT 0 COMMENT '逻辑删除[0否,1是]',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '面试题目'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pro_question
-- ----------------------------
INSERT INTO `pro_question`
VALUES (1, 'equals 和 == 的区别？', 1, 'equals 和 == 的区别？', 'java', 1,
        '1、 ==是判断两个变量或实例是不是指向同一个内存空间 equals是判断两个变量或实例所指向的内存空间的值是不是相同\r\n\r\n2、 ==是指对内存地址进行比较 equals()是对字符串的内容进行比较3.==指引用是否相同 equals()指的是值是否相同',
        NULL, '2021-11-24 00:08:46', NULL, '2021-11-24 00:08:46', NULL, 1);
INSERT INTO `pro_question`
VALUES (2, 'synchronized 和 Lock 有什么区别？', 1, 'synchronized 和 Lock 有什么区别？', 'java', 1,
        '1、 首先synchronized是Java内置关键字，在JVM层面，Lock是个Java类；\r\n\r\n2、 synchronized 可以给类、方法、代码块加锁；而 lock 只能给代码块加锁。\r\n\r\n3、 synchronized 不需要手动获取锁和释放锁，使用简单，发生异常会自动释放锁，不会造成死锁；而 lock 需要自己加锁和释放锁，如果使用不当没有 unLock()去释放锁就会造成死锁。\r\n\r\n4、 通过 Lock 可以知道有没有成功获取锁，而 synchronized 却无法办到。',
        NULL, '2021-11-25 22:19:32', 1265476890672672808, '2022-06-15 13:41:22', NULL, 1);
INSERT INTO `pro_question`
VALUES (3, '什么是vue生命周期？', 2, '什么是vue生命周期？', 'vue', 3,
        'Vue 实例从创建到销毁的过程，就是生命周期。也就是从开始创建、初始化数据、编译模板、挂载Dom→渲染、更新→渲染、卸载等一系列过程，我们称这是 Vue 的生命周期。', '1',
        '2021-11-25 23:28:01', 1265476890672672808, '2022-06-15 13:41:50', 1265476890672672808, 0);

SET
    FOREIGN_KEY_CHECKS = 1;
