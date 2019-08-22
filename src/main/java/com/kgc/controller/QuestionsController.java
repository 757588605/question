package com.kgc.controller;


import com.github.pagehelper.PageInfo;
import com.kgc.mapper.AnswersMapper;
import com.kgc.pojo.Answers;
import com.kgc.pojo.AnswersExample;
import com.kgc.pojo.Questions;
import com.kgc.service.IQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("con1")
public class QuestionsController {
    @Autowired
    private IQuestionsService service;

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(defaultValue = "1")Integer pageNum, ModelAndView mav){

        PageInfo<Questions> pageInfo= service.selectQuestions(pageNum);

        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("show");
        return mav;
    }

    @RequestMapping("/add1")
    public String add1(Model m){

        return "add";
    }
    @RequestMapping("/add2")
    public String add2(Questions questions){
        questions.setLastmodified(new Date());
        int i= service.add(questions);
        return "redirect:/con1/search";
    }

   @RequestMapping("/add3")
   public String add3(Integer id,Model model){

       Questions questions = service.selectOneQuestion(id);
       List<Answers> answers = service.selectAnswers(id);
       model.addAttribute("questions",questions);
         model.addAttribute("answers",answers);
         return "answer";


   }
    @RequestMapping("/add4")
    public String add4(Answers answers,Questions questions){
       answers.setAnsdate(new Date());
       questions.setLastmodified(new Date());
       questions.setId(answers.getGid());
       questions.setAnswercount(questions.getAnswercount()+1);
       int i=service.insertQuestions(questions);
       int j=service.insertAnswers(answers);
       return "redirect:/con1/search";
    }

}
