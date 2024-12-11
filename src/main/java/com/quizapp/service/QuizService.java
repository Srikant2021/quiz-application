package com.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapp.model.Question;
import com.quizapp.model.QuestionWrapper;
import com.quizapp.model.Quiz;
import com.quizapp.model.Response;
import com.quizapp.repository.QuestionRepo;
import com.quizapp.repository.QuizRepo;

@Service
public class QuizService {
	@Autowired
	QuizRepo quizRepo;
	@Autowired
	QuestionRepo questionRepo;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> findAll = questionRepo.findRandomQuestionsByCategory(category, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(findAll);
		quizRepo.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(int id) {
		Optional<Quiz> findById = quizRepo.findById(id);
		Quiz quiz = findById.get();
		List<Question> questions = quiz.getQuestions();
		List<QuestionWrapper> list = new ArrayList<>();
		for (Question q : questions) {
			QuestionWrapper questionWrapper = new QuestionWrapper();
			questionWrapper.setId(q.getId());
			questionWrapper.setOption1(q.getOption1());
			questionWrapper.setOption2(q.getOption2());
			questionWrapper.setOption3(q.getOption3());
			questionWrapper.setOption4(q.getOption4());
			questionWrapper.setQuestionTitle(q.getQuestionTitle());
			list.add(questionWrapper);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResponse(Integer id, List<Response> responses) {
		Optional<Quiz> findById = quizRepo.findById(id);
		Quiz quiz = findById.get();
		List<Question> questions = quiz.getQuestions();
		int count = 0;
		int i = 0;
		for (Response r : responses) {

			if (r.getAnswer().equals(questions.get(i).getRightAnswer())) {
				count++;
			}
			i++;
		}

		return new ResponseEntity<>(count, HttpStatus.OK);
	}

}
