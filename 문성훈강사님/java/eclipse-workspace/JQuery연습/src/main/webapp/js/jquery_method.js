

// event handler
function myDiv() {
	// 현재 선택된 option을 알아내기
	$("#myDiv").text($("option:selected").text());
}


function printRegion() {
	// 선택된 checkbox를 찾음
	// $("[type=checkbox]:checked + span").text();
	
	// 선택된 checkbox를 개별적으로 처리
	$("[type=checkbox]:checked + span").each(function(index, item) {
		// index : 0부터 1씩 증가
		// item : 현재 수행시키려는 DOM 요소를 지칭
		console.log(($(item)).text());
	});
}


function myFunc() {
	// method : css() - style 변경 => repaint 발생(속도가 느림)
	// $("#myDiv").css("color", "red");
	// $("#myDiv").css("background-color", "yellow");
	
	$("#myDiv").addClass("myClass");	// style 처리는 이 방식으로!
}


function insertLi() {
	let li = $("<li></li>").text("강감찬");
	$("li:eq(2)").after(li);
}

$(document).ready(function() {
	$("li").click(function() {
		// event target을 알아내기
		// this : event handler에서 사용하는 this는 event source에 대한 문서 객체가 됨
		// jquery로 변환하여 사용하기
		alert($(this).text());
	});
});