package top.vchao.dream.v1.question.service.impl;

import top.vchao.dream.v1.question.entity.Question;
import top.vchao.dream.v1.question.mapper.QuestionMapper;
import top.vchao.dream.v1.question.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vchao
 * @since 2022-01-16
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
