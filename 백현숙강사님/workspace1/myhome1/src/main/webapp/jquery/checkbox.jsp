<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous">
</script>
</head>
<body>
	<input type="checkbox" name="book" id="book1" value="1">마법사의 돌<br />
	<input type="checkbox" name="book" id="book2" value="2">비밀의 방<br />
	<input type="checkbox" name="book" id="book3" value="3">아즈카반의 죄수들<br />
	<input type="checkbox" name="book" id="book4" value="4">불의 잔<br />
	<input type="checkbox" name="book" id="book5" value="5">불사조 기사단<br />
	<input type="checkbox" name="book" id="book6" value="6">혼혈왕자<br />
	<input type="checkbox" name="book" id="book7" value="7">죽음의 성물<br />
	<button id="btnAllSelect" type="button">전체선택</button>
	<button id="btnAllRelease" type="button">전체해제</button>
	
</body>
</html>

<script>
	$(function () {
		$("button").click(function () {
			if (this.id === "btnAllSelect")	{
				/* $("input[type=checkbox]").each(function (i, item) {
				item.checked = true;
				})	 */
				$("input[type=checkbox][name=book]").prop("checked", true);
			}
			else {
				/* $("input[type=checkbox]").each(function (i, item) {
					$(this).prop("checked", false);
				}) */
				$("input[type=checkbox][name=book]").prop("checked", false);
			}
		});
	})
</script>