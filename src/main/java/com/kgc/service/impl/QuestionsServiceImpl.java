package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.mapper.AnswersMapper;
import com.kgc.mapper.QuestionsMapper;
import com.kgc.pojo.Answers;
import com.kgc.pojo.AnswersExample;
import com.kgc.pojo.Questions;
import com.kgc.service.IQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class QuestionsServiceImpl implements IQuestionsService {
    @Autowired
    private QuestionsMapper questionsMapper;

    @Autowired
    private AnswersMapper answersMapper;

    @Override
    public List<Answers> selectAnswers(Integer id) {
        AnswersExample a = new AnswersExample();
        AnswersExample.Criteria c = a.createCriteria();
        c.andGidEqualTo(id);
        return answersMapper.selectByExample(a);
    }

    @Override
    public PageInfo<Questions> selectQuestions(Integer pageNum) {
     PageHelper.startPage(pageNum, 1);
        List<Questions> questions = questionsMapper.selectByExample(null);
        return  new PageInfo<Questions>(questions);
    }

    @Override
    public int add(Questions questions) {
        return questionsMapper.insertSelective(questions);
    }

    @Override
    public Questions selectOneQuestion(Integer id) {
        return questionsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertQuestions(Questions questions) {
        return questionsMapper.updateByPrimaryKeySelective(questions);
    }

    @Override
    public int insertAnswers(Answers answers) {
        return answersMapper.insertSelective(answers);
    }


}
