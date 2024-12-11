package com.quizapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quizapp.model.Question;
import com.quizapp.service.QuestionService;

@SpringBootApplication
public class QuizAppApplication implements CommandLineRunner{
	@Autowired
	QuestionService qs;
	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
		System.out.println("running..");
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Question question = new Question();
		 * question.setQuestionTitle("What is sql stands for ?");
		 * question.setCategory("SQL"); question.setDifficulty("easy");
		 * question.setOption1("simple ql");
		 * question.setOption2("s questions language");
		 * question.setOption3("sturctured query langage");
		 * question.setOption4("non of the above");
		 * question.setRightAnswer("sturctured query langage");
		 * qs.addQuestion(question);
		 */
		
	}

}
