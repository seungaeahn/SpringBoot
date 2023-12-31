package com.kh.springdb.model;
/*
CREATE TABLE Board (
    board_id NUMBER(10) PRIMARY KEY,
    title VARCHAR2(100),
    content VARCHAR2(200), 
    author VARCHAR2(50)
);
 * */

public class Board {
	private int boardId;
	private String title;
	private String content;
	private String author;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}