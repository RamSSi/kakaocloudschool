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



const person = {
    age: 20
};
// person.name = '홍길동';
Object.defineProperty(person, 'name', {
    value: '홍길동',
    writable: false,
    enumerable: false,
    configrable: true
});

console.log(person);
console.log(Object.getOwnPropertyDescriptor(person, 'name'));
person.name = '아이유';
console.log(person);    // { name: '홍길동' }

console.log(Object.keys(person));   // enumerable: false => key가 노출되지 않음

for (let idx in person) {
    console.log(idx);   // property key(=index)
}
// for (let value of person) {
//     console.log(value);   // property value
// }
for(let value of Object.values(person)) {
    console.log(value);
}