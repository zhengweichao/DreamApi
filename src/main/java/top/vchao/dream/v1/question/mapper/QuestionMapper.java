package top.vchao.dream.v1.question.mapper;

import top.vchao.dream.v1.question.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author vchao
 * @since 2022-01-16
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}
