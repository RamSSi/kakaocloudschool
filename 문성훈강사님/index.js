// let str1 = `이것은
// 소리없는
// 아우성`;
// console.log(str1)



// var obj = {
//     'name': '홍길동',
//     'printNmame': function myPrint() {
//         console.log(`내 이름은 ${this.name}`);
//     },   // property이지만 메서드(객체의 멤버함수)라고 부름
//     '!myPhone': '010-1234-5678',
//     10: 300 // key 값인 10은 '10'로 변환됨 (자동 형변환)
// }

// console.log(obj);   // 
// console.log(typeof obj);   // object



// var obj = {
//     myName: '홍길동'
// }
// obj.myAge = 20; // dot notaion
// obj['!myPhone'] = '010-1111-2222';  // bracket notation

// console.log(obj);    // { myName: '홍길동', myAge: 20, '!myPhone': '010-1111-2222' }

// delete obj.myAge;
// console.log(obj);   // { myName: '홍길동', '!myPhone': '010-1111-2222' }



// var obj = {
//     10: 100,
//     let: '권장 X!',
//     myName: '홍길동',
//     '!myName': '김길동',
//     myName: '김연아'    // 중복이 아님, 값을 덮어씀
// }
// console.log(obj);   // { '10': 100, let: '권장 X!', myName: '김연아', '!myName': '김길동' }
// console.log(obj.myAddress); // undefined 
// // 객체 내에 key가 존재하지 않지만 referenceError가 아닌 undefined(정의되지 않음)이 출력됨



// let x = 1;
// let y = 2;
// const obj = {x, y};
// console.log(obj);   // { x: 1, y: 2 } (객체 리터럴 확장 표현 방식)



// let myObj = {
//     name: '홍길동',
//     printName: function() {
//         console.log(this.name);
//     }   // 메서드라고 부름
// }

// let myObj1 = {
//     name: '홍길동',
//     printName() {
//         console.log(this.name);
//     }   // 축약표현 : 이 형식이 진짜! 메서드임
// }
// myObj1.printName();
// console.log(myObj.name === myObj1.name);



// let myStr = 'Hello';
// // primitive type을 마치 객체(배열)처럼 사용
// console.log(myStr[0]);  // H (primitive type을 유사배열객체(array-like object)로 사용할 경우 배열이 생성되고, 그 참조를 myStr에 저장, 배열의 첫 번째 요소에 myStr이 갖고 있던 값을 넣어주고, 두 번째 요소에는 배열의 길이, 세 번째 요소부터 key와 value로 저장함)
// myStr[0] = 'h'; 
// console.log(myStr['0']);
// console.log(myStr.length);  // 5
// console.log(myStr); // Hello



// var myFunc = function add(x, y) {
//     return x + y;
// }
// // console.log(add(3, 5)); // add is not defined
// console.log(myFunc(3, 5));  // 8

// var myFunc1 = function(x, y) {
//     return x + y;
// }
// console.log(myFunc1(3, 5)); // 8




// foo();  // foo 함수
// // add();  // add is not a function
// // 

// // 함수 선언문 : 자바스크립트 엔진이 식별자를 찾다가 함수 선언문을 발견하면 함수 이름과 똑같은 식별자(변수)를 만들고, 함수 객체를 만들어 식별자에 할당
// function foo() {    // 리터럴이 아님
//     console.log('foo 함수');
// }

// // 함수 표현식 : 자바스크립트 엔진이 식별자 add를 식별자 list에 올리고 undefined를 할당 (끝! 함수를 바로 바인딩하지 않는다. 함수 객체는 런타임에 만들어지기 때문)
// var add = function bar() {
//     console.log('bar 함수');
// };

// // 함수 표현식 : 해석하면 객체만 존재하는 것 -> 객체가 변수에 할당되지 않은 상태로 존재
// (function bar() {   // 리터럴
//     console.log('bar 함수');
// })

// foo();  // foo 함수
// // bar();  // bar is not defined



// // 함수 선언문
// function add() {    // (x, y) {
//     // arguments (들어오는 인수 모두를 담는 배열 객체(매개변수와 상관 없음))
//     // : 유사배열 객체 (Array-like Object)
//     // 모든 유사배열 객체는 length property를 가지며, 
//     // 배열처럼 index를 이용해 access 가능, 당연히 순환 가능
//     // return x + y;
//     let sum = 0;
//     for (let i = 0; i < arguments.length; i++) {
//         sum += arguments[i];
//     }
//     return sum;
//     // return 구문이 없을 경우 함수를 호출하면 undefined가 return 됨
// }
// console.log(add(2, 5)); // 7
// console.log(add(2));    // 2   // NaN (2 + undefined, 호출 가능)
// console.log(add(2, 3, 4));  // 9



// // IIFE : 함수객체를 실행하는 함수 표현식이 됨
// // 선언 후 바로 실행하고 끝나는 함수 -> 재사용이 불가능 => 일반적으로 익명 함수 사용
// (function() {    // definition
//     let x = 10;
//     let y = 20;
//     console.log(x + y);
// }());  // invoke



// var x = 100;    // global scope (전역변수)
// var y = 200;    // global scope (전역변수)
// // outer function
// function outer() {
//     let x = 0;  // function level scope (지역변수)
//     // inner function
//     function inner() {
//         let x  = 10;    // function level scope (지역변수)
//         console.log(y);
//     }
// }
// outer();




// // 1. 원래 있던 함수를 수정
// // 2. 함수를 새로 추가하여 만들기
// // 3. 함수를 추상화시켜 인자로 받아 사용
// function repeat1(n) {
//     // for(var i = 0; i < n; i++) {
//     //     console.log(i);
//     // }
    
//     // 1.
//     for(var i = 0; i < n; i++) {
//         if (i%2) {
//             console.log(i);
//         }
//     }
// }
//     // 2. 
// function repeat2(n) {
//     for(var i = 0; i < n; i++) {
//         if (i % 2) {
//             console.log(i);
//         }
//     }
// }


// // 3. 함수를 추상화 시켜서 인자로 받아 사용
// // 고차함수 (Higher-Ordered Function)
// function repeat3(n, f) {
//     for(var i = 0; i < n; i++) {
//         f(i);
//     }
// }

// // Callback Function
// let logAll = function(i) {
//     console.log(i);
// }
// let logOdd = function(i) {
//     if(i % 2) {
//         console.log(i);
//     }
// }
// repeat3(5, logOdd); // 함수를 넘겨줄 땐 함수의 주소값을 넘겨줌, logAll()은 함수 실행(호출)



// var x = 1;  // 전역 scope의 전역변수
// function foo() {
//     var x = 10; // 지역 scope의 지역변수
//     bar();
// }
// function bar() {
//     console.log(x);
// }
// foo();



// var obj = {
//     name: '홍길동'
// };

// console.dir(obj);  // 객체의 세부 내용을 브라우저에서 확인 가능

// // obj.[prototype] = null;
// // obj[['prototype']] = null;



// Property Attribute를 확인해 보아요!!!
// const person = {
//     name: 'Lee',
//     age: 20
// };

// console.log(Object.getOwnPropertyDescriptor(person, 'name'));
// console.log(Object.getOwnPropertyDescriptors(person))



// const person = {
//     age: 20
// };
// // person.name = '홍길동';
// Object.defineProperty(person, 'name', {
//     value: '홍길동',
//     writable: false,
//     enumerable: false,
//     configrable: true
// });

// console.log(person);
// console.log(Object.getOwnPropertyDescriptor(person, 'name'));
// person.name = '아이유';
// console.log(person);    // { name: '홍길동' }

// console.log(Object.keys(person));   // enumerable: false => key가 노출되지 않음

// for (let idx in person) {
//     console.log(idx);   // property key(=index)
// }
// // for (let value of person) {
// //     console.log(value);   // property value
// // }
// for(let value of Object.values(person)) {
//     console.log(value);
// }



// -------------------------------------------------------------
// 220706
// 'use strict';   // 유연성 저하, 정형성 상승 => JS 강점 훼손 but 안쓰면 에러 파악 불가

// const person = {
//     name: 'Lee',

// };
// // 객체의 확장이 가능한지 확인
// console.log(Object.isExtensible(person));   // 확장이 가능한지 확인: true
// person.age = 20;
// console.log(person);

// Object.preventExtensions(person);   // 확장 불가능
// person.address = '서울';
// console.log(person);    // { name: 'Lee', age: 20 } 
// // address 추가 불가 but Error가 발생하지 않음

// Object.seal(person);    // property 추가, 삭제 불가
// delete person.name;
// console.log(person);    // { name: 'Lee', age: 20 }

// Object.freeze(person);
// person.name = '아이유';
// console.log(person);    // { name: 'Lee', age: 20 }



// const person1 = new Object();
// person1.name = 'person1';
// console.dir(person1);
// // 생성자 함수를 이용한 객체 생성
// // => instance

// const person2 = {};
// person2.name = 'person2';
// console.dir(person2);
// // 객체 literal을 이용한 객체 생성

// function Person() {
//     // this
//     // this라는 keyword는 생성자 함수일 경우도 있고
//     // 일반 함수인 경우에도 있음
//     // 생성자 함수에서의 this : 생성자 함수에 의해 만들어질 instance
//     // 일반함수에서의 this : window
//     console.log(this);  // Object [global] (node.js로 실행)
// }

// const person1 = Person();
// console.log(person1);    // undefined : 함수의 반환값이 없기 때문에

// const person2 = new Person();
// console.log(person2);   // Person {} (= this)
// // 생성자 함수는 return 구문을 사용하지 않는다. 자동으로 객체를 생성하고 this에 바인딩하여 반환

// const person3 = {};
// console.log(person3);   // {}



// function Person(name) {
//     this.name = name;
//     this.getName = function() {
//         return `내 이름은 ${this.name}`
//     }
// }

// const person1 = new Person('아이유');
// const person2 = new Person('김연아');

// console.log(person1.getName());
// console.log(person2.getName());



// function foo() {
//     this.address = "hh";
//     this.age =  5;
//     console.log(this);
// };

// foo.myName = '홍길동';
// foo.getName = function() {
//     console.log(this);
// };

// foo();  // 함수 호출
// new foo();  // 생성자 함수 호출
// foo.getName();  // 메서드 호출  => 함수 객체 출력



// // 함수 선언문
// function foo() {}

// // 함수 표현식
// var bar = function() {};

// // 객체의 property인 일반 함수
// const barx = {
//     x: function() {}    // 객체의 property이면서 함수임
// };

// // foo 함수객체가 내부 메서드 [[constructor]]를 가지고 있음
// new foo();
// new bar();  
// new barx.x();

// //
// const arrow = () => {};
// new arrow();    // TypeError: arrow is not a constructor

// const obj = {
//     x() {

//    }    // constructor가 없음
// }



// // 함수 선언
// function add(x, y) {
//     return x + y;
// }

// var inst = new add();
// console.log(inst);  // add {}

// function createUser(name, role) {
//     return {name, role};
// }

// inst = new createUser();
// console.log(inst);  // { name: undefined, role: undefined }

// // 생성자 함수
// function Circle(radius) {
//     this.radius = radius;
//     this.getDiameter = function() {
//         return 2 * this.radius;
//     }
// }

// const circle = Circle(5);   
// // 일반함수에서의 this는 window(global)이기 때문에
// // window.radius = 5

// console.log(radius);    // 5
// console.log(circle);    // undefined : 일반함수 circle의 return 값이 없기 때문



// var obj = {
//     name: '홍길동'
// }
// console.dir(obj);

// function square(number) {
//     return number* number;
// }
// console.dir(square);



// function foo(f) {
//     return f();
// }

// function bar() {
//     return `caller: ${bar.caller}`; 
//     // 함수 내부에서의 bar는 함수 이름이다. => 함수 bar의 caller
// }

// console.log(bar()); //caller: null
// console.log(foo(bar));  // caller: function foo(f) {
//                         //    return f();
//                         // }


// // 함수 선언문 : 생성자 함수로 사용
// function Person(name) {
//     // 생성자 함수로 만들어질 instance가 가지는 property를 설정
//     this.name = name;
// }

// const person = new Person('홍길동');



// // 생성자 함수
// function Circle(radius) {
//     this.radius = radius;
//     this.getDiameter = function() {
//         return 2 * radius;
//     }
// }

// const circle1 = new Circle(5);
// const circle2 = new Circle(10);

// console.log(circle1.getDiameter === circle2.getDiameter);   
// // false : 함수 객체가 두 개 만들어 짐 => 메모리 낭비




// function Circle(radius) {
//     this.radius = radius;
//     Circle.prototype.getDiameter = function() {
//         return 2 * this.radius;
//     };

//     Circle.prototype.name = '홍길동';
// }
// circle1 = new Circle(5);
// circle2 = new Circle(10);
// console.log(circle1.name, circle2.name);    // 홍길동 홍길동

// console.log(circle1.getDiameter === circle2.getDiameter);   // true 
// console.log(circle1.name, circle2.name);    // 홍길동 아이유
// // => circle2.name = '아이유'; 는 property를 바꾸는 것이 아니라 새로운 property를 추가한 것이다.

// Circle.prototype.name = '아이유';
// console.log(circle1.name, circle2.name);    // 아이유 아이유

// circle1.__proto__.name = '김가나';
// console.log(circle1.name, circle2.name);    // 김가나 김가나

// function Square(width) {
//     this.width = width;
// }

// console.log(Square.prototype);
// console.log(circle1.name);



// function foo(param1, ...args) {
//     console.log(arguments);
//     // [Arguments] { '0': 1, '1': 2, '2': 3, '3': 4, '4': 5 }
//     console.log(args);
//     // [ 2, 3, 4, 5 ]
// }

// foo(1, 2, 3, 4, 5);



// function Person(name) {
//     this.name = name;
// }

// const person = new Person('홍길동');
// console.dir(Person);



// const obj = {};
// const parent = { x: 1 };

// obj.__proto__ = parent; // obj는 parent를 상속받을 수 있음
// console.log(obj.x); // 1



// const obj = {};
// console.log(obj.__proto__.constructor.name);    // Object



// // 객체 생성 방법
// // 객체를 생성할 때 객체의 상위 prototype 객체를 직접 지정 가능
// const obj = Object.create(null);
// console.log(obj.__proto__); // undefined

// // 따라서 이 경우  Object 메서드 사용하는 것 권장
// console.log(Object.getPrototypeOf(obj));    // null



// 함수 표현식
// var foo = function() {};
// console.log(foo.__proto__ === Function.prototype);  // true
// console.log(foo.prototype.__proto__ === Object.prototype);  // true
// console.log(Object.prototype.__proto__);    // null
// console.log(foo.constructor === Function);  // true



// console.log(Object === window.Object);  // (브라우저에서) true
// console.log(Object === global.Object);  // (node.js에서) true

// console.log(Object.__proto__);  // ƒ () { [native code] }



function Person(name='default') {
    this.name = name;
}

// Person.prototype.sayHello = function() {
//     console.log(`안녕하세요. ${this.name}`);
// };  // 프로토타입 메서드 (생성자 함수 객체의 프로토타입의 property로 붙는 메서드)
// // 인스턴스 메서드 : 생성자 함수 내에 property로 만들어지는 메서드

// const me = new Person('홍길동');
// me.sayHello();  // 안녕하세요. 홍길동 (prototype property 메서드를 호출)

// me.sayHello = function() {
//     console.log(`Hello ${this.name}`);
// };  // 오버라이딩 : 상속받은 메서드를 재정의
// // 만약 overriding이 발생하면 발생된 overriding에 의해 
// // 숨겨진 prototype method를 property shadowing이 발생했다고 한다
// me.sayHello();

// Person.sayHello();

// Person.prototype = {
//     // constructor: Person,    // 직접 constructor를 연결 가능
//     sayHello() {
//         console.log('안녕하세요!');
//     }
// };

// const me = new Person('홍길동');

// const parent = {
//     sayHello() {
//         console.log('안녕하세요!');
//     }
// };

// Object.setPrototypeOf(me, parent);    // prototype 객체를 변경할 수 있는 메서드
// // me의 prototype 객체를 parent로 설정
// console.log(me.__proto__.constructor === Person.prototype); // false


// function Person(name) {
//     this.name = name;
//     // instance 메서드
//     this.callme = function() {

//     }
// }

// // prototype method
// Person.prototype.sayHello = function() {
//     console.log('안녕');
// };

// // static method : Person의 property가 됨 (메서드)
// Person.staticMethod = function() {
//     console.log('하이하이');
// };

// const me = new Person('하이');


// x = 0;
// function foo() {
//     x = 10; // ReferenceError가 발생해야 상식과 부합!
// }   // 묵시적(암묵적) 전역, implicit global => 전역변수화!

// foo();
// console.log(x); // 10



// (function() {
//     // non-strict mode
//     var let = 10;

//     // inner function, nested function
//     function foo() {
//         'use strict';
//         let = 20;
//     }
// }());


// 'use strict';

// var obj = {};
// delete obj;

// console.log(obj);



// var obj = new Object();
// var str = 'Hello';  // primitive value
//                     // data type : string

// str.toUpperCase();  // wrapper 객체 생성, 소멸
// str.toLowerCase();  // wrapper 객체 생성, 소멸
// // 객체의 생성과 소멸이 반복되기 때문에 literal

// var strObj = new String('홍길동');
// 'Hello'.toUpperCase();  // primitive value에 메서드 호출 (원래는 에러)
// // 그러나 JS 엔진은 wrapper 객체(new String('Hello'))를 묵시적으로 만든다.
// // wrapper 객체(유사 배열 객체)는 String().prototype의 상속을 받기 때문에
// // String.prototype의 메서드를 사용할 수 있다.
// // 근데 String.prototype의 [[Prototype]]은 Object.prototype임

// // console.log(typeof strObj); // object
// console.dir(strObj);    // 유사 배열 객체 (wrapper 객체)



// 필기 14
// const x = 1;

// function foo() {
//     const y = 2;
//     function bar() {
//         const z = 3;
//         console.log(x + y + z);
//     }
//     bar();
// }
// foo();



// // 클로저 예시

// const x = 1;

// function outer() {
//     const x = 10;

//     const inner = function() {
//         console.log(x);
//     }
//     return inner;
// }

// const innerFunc = outer();
// innerFunc();

// // innerFunc()가 호출되면 outer()가 호출되는데 inner가 return되면 지역변수 x=10, inner 함수는 사라져야 한다.
// // 그러나 지역변수가 사라지지 않고 남아있어 innerFunc를 실행하면 10이 출력된다.
// // 가비지컬렉터 : 메모리를 효율적으로 사용하기 위해 어떤 데이터를 아무도 참조하지 않으면 이 데이터를 삭제한다.
// // inner 함수에서 x를 호출하면 이 x는 상위에 존재하는 (lexical) x의 value인 10을 출력하는데,
// // inner 함수가 return 되어 innerFunc가 inner 함수를 참조하게 된다.
// // 따라서 x와 inner의 참조가 아직 남아있기 때문에 가비지 컬렉션이 수행되지 않고 함수의 실행 컨텍스트가 종료되어도 
// // 데이터가 삭제되지 않음



// function foo() {
//     const x = 1;
//     const y = 2;
//     function bar() {    // 외부 함수의 식별자를 참조하지 않은 상태(3)
//         const z = 3;
//         console.log(z);
//     }
//     return bar;
// }
// const bar = foo();  // 중첩함수가 외부함수의 결과값으로 return되고 있지만 클로저는 아님
// bar();


// function foo() {    // 중첩함수가 return 되지 않고(2), 생명 주기가 외부 함수보다 짧다(4).
//     const x = 1;
//     const y = 2;

//     function bar() {
//         console.log(x);
//     }
//     bar();
// }

// foo();


// closure로 private 변수를 만드는 방법
// const increase = function() {
//     let num = 0;
//     return ++num;
// }
// console.log(increase());
// console.log(increase());
// console.log(increase());

// const increase = (function() {
//     let num = 0;
//     return function() {
//         return ++num;
//     }
// }());
// console.log(increase());
// console.log(increase());
// console.log(increase());

// const counter = (function() {
//     let num = 0;
//     return {    // 함수가 포함된 것을 return하면 클로저 생성 가능
//         increase() {    // 메서드1
//             return ++num;
//         },
//         decrease() {    // 메서드2
//             return --num;
//         }
//     };
// }());

// console.log(counter.increase());    // 1
// console.log(counter.increase());    // 2
// console.log(counter.increase());    // 3
// console.log(counter.decrease());    // 2
// console.log(counter.decrease());    // 1
