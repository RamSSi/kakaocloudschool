package com.rapa.control.guestbook;

public class GuestbookDto {
	private int id = 1;
	private String title = "";
	private String contents = "";
	private String writer = "";
	private String wdate = "";
	private int hit = 0;
	
	// 추가적인 생성자를 만들지 않을 경우 따로 생성자를 만들어주지 않아도 된다.
	// 시스템은 디폴트 생성자를 만들어 호출 (필요가 없더라도 생성한다.)
	// 필요에 의해 디폴트 생성자 이외의 생성자를 만들면 시스템은 디폴트 생성자를 만들지 않는다.
	// 그래서 기본 객체 생성 못함 GuestbookDto dto = new GuestbookDto();
	// 실제로 데이터베이스에 접근해야 할 상황이라면 생성자를 만들지 않아도 된다.
	public GuestbookDto() {
		super();	// 부모 클래스 생성자 호출
	}
	public GuestbookDto(int id, String title, String contents, String writer, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.wdate = wdate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
}
