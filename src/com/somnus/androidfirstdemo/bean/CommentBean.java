package com.somnus.androidfirstdemo.bean;

import java.io.Serializable;

public class CommentBean implements Serializable {
	private String Comment;

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
}
