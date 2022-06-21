let promise = new Promise(function (resolve, reject) {
  setTimeout(() => {
    s = 0;
    for (i = 1; i <= 100; i++) s += i;
    resolve(s);
  }, 1000);
  // setTimeout(() => resolve(10), 1000); // 1초 후에 작업이 성공했음을 알리는 명령어를 보냄
  
  // let data = {"name": "홍길동", "age":23, "phone": "010-0000-0001"};
  // setTimeout(() => resolve(data), 1000); // 잘못된 코드(?)
  // setTimeout(() => reject("데이터 수신 오류"), 1000);
})
  .then((value) => console.log(value))  // then으로부터 결과값을 받아 출력할 수 있음 (promise문에서는 return 사용 불가)
  .catch((error) => console.log(error))
  .finally(() => console.log("ending..."));

console.log(promise);