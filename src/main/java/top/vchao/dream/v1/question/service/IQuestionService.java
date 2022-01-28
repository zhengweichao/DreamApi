package top.vchao.dream.v1.question.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.vchao.dream.v1.question.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import top.vchao.dream.v1.question.Question.request.QuestionRequest;

/**
 * 面试题目 服务类
 */
public interface IQuestionService extends IService<Question> {

    Page<Question> page(QuestionRequest request);

    Question detail(Integer id);

    void save(QuestionRequest request);

    void remove(Integer id);

    void update(QuestionRequest request);

}
