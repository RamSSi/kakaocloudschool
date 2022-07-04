let json = "{bad json}";

try {
  let user = JSON.parse(json);
  alert(user.name);
} catch (e) {
  console.log(e.message);
} finally {
  console.log("finally문 블럭은 에러 발생유무와 관계없이 실행된다.");
}