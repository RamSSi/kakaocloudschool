function search() {
	let keyword = $("#searchKeyword").val();
	let requestURL = "http://localhost:8080/book/bsearch" + "?keyword=" + keyword;
	// Servlet에 keyword = 사용자가 검색한 키워드를 전달
	
	window.location.href = requestURL;
	
}