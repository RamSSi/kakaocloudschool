async function f() {
  return 1; // async 키워드로 인해 Promise 객체로 쌓여서 반환됨
}
f()
.then((a) => { // async 키워드로 인해 then을 호출할 수 있는 프라미스 객체임
  alert(a);
})