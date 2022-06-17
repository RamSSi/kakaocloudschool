async function f() {
  return 1;
}
f().then((a) => { // async 키워드로 인해 then을 호출할 수 있는 프라미스 객체임
  console.log(a);
})