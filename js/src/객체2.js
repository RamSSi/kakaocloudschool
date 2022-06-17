let person = {
  name: "홍길동", age: 23, phone: "010-0000-0001",
  display: function() { 
    console.log(this.name, this.age, this.phone);
    // console.log(name, age, phone);  this 키워드 필요
  },
  // 객체 property로 화살표 함수 사용 불가
  // display2: () => {
  //   console.log(this.name, this.age, this.phone);
  // }

  setValue: function (name="", age=10, phone="") {
    this.name = name;
    this.age = age;
    this.phone = phone;
  }
}

person.display();
person.setValue("임꺽정", 33, "011-2222-3333");
console.log("person: ", person);

// 상속
let students = {
  name: "장길산", kor: 90, eng: 80, mat: 70, __proto__: person
};

console.log("students: ", students);
console.log(students.phone, students.age);
students.setValue("임꺽정", 33, "010-3333-6666");
students.display();
console.log(students);

// JSON.stringify로 객체를 문자열로 변환할 때 멤버 함수(?)는 포함되지 않는다.
console.log(JSON.stringify(person), JSON.parse(JSON.stringify(person)));
