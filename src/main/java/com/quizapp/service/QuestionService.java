package com.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizapp.model.Question;
import com.quizapp.repository.QuestionRepo;

@Service
public class QuestionService {
	@Autowired
	QuestionRepo repo;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity(repo.findAll(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(repo.findAll(), HttpStatus.OK);
	}

	public List<Question> getQuestionsByCategory(String category) {
		return repo.findAllByCategory(category);
	}

	public Question addQuestion(Question question) {
		return repo.save(question);
	}

	public String deleteQuestion(int id) {
		repo.deleteById(id);
		return "Deleted...";
	}

	public Question updateQuestion(int id, Question question) {
		question.setId(id);
		return repo.save(question);
	}

}
