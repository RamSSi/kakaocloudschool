function getData() {
	// 서버 프로그램을 호출해서 결과를 받아 화면 처리
	// 비동기 방식으로 처리
	// Ajax를 이용
	
	let today = $("#searchDate").val();
	today = today.replace(/-/g, "");
	
	let movieCd = [];
	let actorNm = null;
	
	new Promise(() => {
		$.ajax({	
			// 동기 : 한 가지 작업이 끝난 후 다음 작업을 시작
			// 비동기 : 이전 작업의 결과와 상관없이 작업이 가능 (hold X)
			async: false, 	// Ajax의 기본 동작 방식 : 비동기 방식
			url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
			type: "GET",
			data: {
				key: "df2acfdbdc7d7e7227c231abee8bcad3",
				targetDt: today	// 2022-07-30의 '-' 제거 필요
			},
			timeout: 3000,	// ms, 시간 내에 서버로부터 응답이 오지 않으면 실패로 간주
			dataType: "json",
			success: function(result) {
				// 서버로부터 응답이 도착하면 호출되어 실행됨
				console.log(result);
				
				$('tbody').empty();
				
				for (let i = 0; i < 10; i++) {
					movieCd.push(result["boxOfficeResult"]["dailyBoxOfficeList"][i]["movieCd"]);
					
					let tr = $("<tr></tr>");
					movieName = result['boxOfficeResult']['dailyBoxOfficeList'][0]['movieNm'];
					
					let orderTd = $("<td></td>").text(result["boxOfficeResult"]["dailyBoxOfficeList"][i]["rank"]);
					tr.append(orderTd);
					let postTd = $("<td></td>");
					tr.append(postTd);
					let titleTd = $("<td></td>").text(result['boxOfficeResult']['dailyBoxOfficeList'][0]['movieNm']);
					tr.append(titleTd);
					
					$.ajax({
						async: false, 	// Ajax의 기본 동작 방식 : 비동기 방식
						url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
						type: "GET",
						data: {
							key: "df2acfdbdc7d7e7227c231abee8bcad3",
							movieCd: movieCd[i]	// 2022-07-30의 '-' 제거 필요
						},
						timeout: 3000,	// ms, 시간 내에 서버로부터 응답이 오지 않으면 실패로 간주
						dataType: "json",
						success: function(result) {
							if (result["movieInfoResult"]["movieInfo"]["actors"].length == 0) {
								actorNm = "정보 없음";
							} else {
								actorNm = result["movieInfoResult"]["movieInfo"]["actors"][0]["peopleNm"];
							}
						},
						error: function(result) {
							alert("1실패");
						}
					});
					let actorTd = $("<td></td>").text(actorNm);
					tr.append(actorTd);
					let deleteTd = $("<td></td>");
					tr.append(deleteTd);
					$('tbody').append(tr);
					
					let query = movieName + " 포스터";
					
					const REST_API_KEY = "57d1ea39e93148c5b6ea3a563d428583";
					$.ajax({
						async: false, 	// Ajax의 기본 동작 방식 : 비동기 방식
						url: "https://dapi.kakao.com/v2/search/image",
						type: "GET",
						Headers: {
							Authorization: "KakaoAK b36f6fbce3755e9ae1f4cd32c5788353"
						},
						data: {
							query: movieName + " 포스터"
						},
						timeout: 3000,	// ms, 시간 내에 서버로부터 응답이 오지 않으면 실패로 간주
						dataType: "json",
						success: function(result) {
							console.log(result);
						},
						error: function(result) {
							alert("2 실패");
						}
					})
				}
			},
			error: function() {
				// 서버 응답이 오지 않으면 호출되어 실행됨
				alert("에러 발생");
			}
		});
		
		
	});
}