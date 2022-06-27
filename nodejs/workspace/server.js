const http = require("http"); // 외부모듈을 파일로 불러옴
const fs = require("fs");
const url = request("url");

// 클라이언트로부터 연결 요청이 오면 호출되는 함수
const server = http.createServer((req, res) => {
  let pathName = url.parse(req.url).pathname;

  if (req.method === "GET" && pathName === "/") {
    // GET 방식일 때
    let query = url.parse(req.url, true).query; // 문자열을 JSON 객체로 전환
    // console.log(req);

    console.log(query);
    console.log(query.name, query.age);
    console.log(query["name"], query);

    let data = fs.readFileSync("./html/index.html", "utf-8");
    // 동기모드로 파일을 읽어옴
    res.statusCode = 200;
    res.setHeader("Content-type", "text/html");
    res.end(data);
  } else if (req.method === "POST") {
    // req.on("data", (data) => {
    //   res.statusCode = 200;
    //   res.setHeader("Content-type", "text/html");
    //   res.end("<h1>" + data + "</h1>");
    // });
    let body = "";
    req.on("data", (data) => {
      body += data;
    });
    req.on("end", () => {
      let postData = new URLSearchParameter(b);
      console.log(postData);
      console.log(postData.get("username"), postData.get("age"));

      res.setHeader("Content-type", "text/html");
      res.end(`<h1>${postData.get("username")} ${postData.get("age")}</h1>`);
    });

});

server.listen(3000, "127.0.0.1", () => {
  console.log("Server start at http:/127.0.0.1:3000");
}); // 3000번 포트 연결
