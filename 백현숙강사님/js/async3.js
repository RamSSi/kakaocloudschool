async function loadData() {
  let promise = new Promise((resolve, reject) => {
    let user = {"username": "홍길동", "age": 32, "phone": "010-00000-0000"}
    setTimeout(() => resolve(user), 1000);
  })

  let result = await promise;
  // 프라미스가 이행될 때까지 기다린다.
  console.log(result);
}
let a = loadData();
a.then((data) => console.log(data));