package com.quizapp.model;

public class Response {

	private int id;
	private String answer;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String result) {
		this.answer = result;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", result=" + answer + "]";
	}

}
