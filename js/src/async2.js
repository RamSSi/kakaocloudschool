async function f() {
  let promise = new Promise((resolve, reject) => {
    setTimeout(() => resolve("완료!"), 1000)
  });

  let result = await promise; // promise가 모두 실행될 때까지 기다림
  alert(result);
  // async와 await을 이용하여 then 없이도 동기 함수처럼 만들 수 있다.
}