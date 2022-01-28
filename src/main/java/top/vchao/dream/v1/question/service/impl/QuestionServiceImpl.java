package top.vchao.dream.v1.question.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.vchao.dream.v1.question.Question.request.QuestionRequest;
import top.vchao.dream.v1.question.entity.Question;
import top.vchao.dream.v1.question.mapper.QuestionMapper;
import top.vchao.dream.v1.question.service.IQuestionService;

/**
 * 面试题目 服务实现类
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Override
    public Page<Question> page(QuestionRequest request) {
        Page<Question> pageInfo = new Page<>(request.getPage(), request.getSize());
        return this.page(pageInfo);
    }

    @Override
    public Question detail(Integer id) {
        return this.getById(id);
    }

    @Override
    public void save(QuestionRequest request) {
        Question bean = new Question();
        BeanUtil.copyProperties(request, bean);
        this.save(bean);
    }

    @Override
    public void remove(Integer id) {
        this.removeById(id);
    }

    @Override
    public void update(QuestionRequest request) {
        Question bean = new Question();
        BeanUtil.copyProperties(request, bean);
        this.updateById(bean);
    }

}
