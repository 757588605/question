package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.Answers;
import com.kgc.pojo.Questions;

import java.util.List;

public interface IQuestionsService {
    List<Answers> selectAnswers(Integer id);

    PageInfo<Questions> selectQuestions(Integer pageNum);

    int add(Questions questions);

    Questions selectOneQuestion(Integer id);

    int insertQuestions(Questions questions);

    int insertAnswers(Answers answers);



}
