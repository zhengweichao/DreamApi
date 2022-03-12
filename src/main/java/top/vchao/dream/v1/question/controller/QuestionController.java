package top.vchao.dream.v1.question.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.vchao.dream.v1.pojo.request.BaseRequest;
import top.vchao.dream.v1.pojo.response.PageResponse;
import top.vchao.dream.v1.pojo.response.ResponseData;
import top.vchao.dream.v1.pojo.response.SuccessResponseData;
import top.vchao.dream.v1.question.Question.request.QuestionRequest;
import top.vchao.dream.v1.question.entity.Question;
import top.vchao.dream.v1.question.service.IQuestionService;

import javax.annotation.Resource;

/**
 * 面试题目接口
 */
@RestController
@RequestMapping("/v1/question")
public class QuestionController {

    @Resource
    IQuestionService iQuestionService;

    @GetMapping("/page")
    public SuccessResponseData<PageResponse<Question>> page(@Validated(BaseRequest.page.class)QuestionRequest request) {
        Page<Question> page = iQuestionService.page(request);
        return ResponseData.successPage(page);
    }

    @GetMapping("/detail")
    public SuccessResponseData<Question> detail(@Validated(BaseRequest.detail.class)QuestionRequest request) {
        Question bean = iQuestionService.detail(request.getId());
        return ResponseData.success(bean);
    }

    @PostMapping("/add")
    public ResponseData add(@Validated(BaseRequest.add.class)QuestionRequest request) {
        iQuestionService.save(request);
        return ResponseData.success();
    }

    @DeleteMapping("/delete")
    public ResponseData delete(@Validated(BaseRequest.delete.class)QuestionRequest request) {
        iQuestionService.remove(request.getId());
        return ResponseData.success();
    }

    @PutMapping("/update")
    public ResponseData update(@Validated(BaseRequest.update.class)QuestionRequest request) {
        iQuestionService.update(request);
        return ResponseData.success();
    }

}
