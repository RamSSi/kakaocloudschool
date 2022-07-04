function hello() {
  return "Hello nodejs";
}

exports.hello = hello;

// exports는 함수를 외부로 내보낸다.
// 외부로 export하면 