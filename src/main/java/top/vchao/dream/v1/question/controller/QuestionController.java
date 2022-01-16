package top.vchao.dream.v1.question.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.vchao.dream.v1.question.entity.Question;
import top.vchao.dream.v1.question.service.IQuestionService;

import javax.annotation.Resource;
import java.util.List;


/**
 * 前端控制器
 */
@RestController
@RequestMapping("/v1/question")
public class QuestionController {

    @Resource
    IQuestionService mIQuestionService;

    @GetMapping("/page")
    public List<Question> page() {
        return mIQuestionService.list();
    }

    @GetMapping("/get_detail")
    public Question getDetail() {
        return mIQuestionService.list().get(0);
    }

}
