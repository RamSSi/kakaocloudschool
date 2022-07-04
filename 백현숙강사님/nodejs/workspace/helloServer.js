const http = require("http"); // 외부모듈을 파일로 불러옴

// 클라이언트로부터 연결 요청이 오면 호출되는 함수
http.createServer((req, res) => {
  res.statusCode = 200; // 클라이언트에게 연결 요청이 성공했음을 알림
  res.setHeader("Content-type", "text/html"); // 보내는 정보의 타입이 html임을 알림
  res.end("<h1>Hello Nodejs</h1>");
}).listen(3000, "127.0.0.1", () => {
  console.log("Server start at http:/127.0.0.1:3000");
});  // 3000번 포트 연결
