class User {
  constructor(name) { // 멤버 변수 선언부가 없고, 생성자에서 생성과 선언을 동시에 한다.
    console.log("생성자");  
    this.name = name;
  }

  sayHi() {
    console.log(this.name);
  }
}

let user = new User("Tom");
user.sayHi();
user.age = 12;
console.log(user.age);