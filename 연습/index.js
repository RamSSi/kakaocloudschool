// // Array.prototype.map()

// const array1 = [1, 4, 5, 7, 9, 16]

// // const map1 = array1.map(function(x) {
// //     return x * 2;
// // })

// const map1 = array1.map((x) => x * 2);
// console.log(map1);



// // Array.prototype.filter()
// // : 주어진 함수의 조건을 통과하는 모든 요소를 모아 새로운 배열로 반환

// const words = ['세종대왕', '이황', '강감찬', '샤인머스켓', "소리없는 아우성"];
// words.filter((word) => {
//     return word.length > 3;
// })



// 전개 연산자 (Spread Operator)

let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];
let arr3 = [7, 8, 9];

// let result = arr1.concat(arr2, arr3);
// console.log(result);    // Array(9) : [1, 2, 3, 4, 5, 6, 7, 8 ,9]

let result = [...arr1, ...arr2, ...arr3];
console.log(result);    // [1, 2, 3, 4, 5, 6, 7, 8, 9]

let obj1 = {
    a: '1',
    b: '2'
};

let obj2 = {
    c: '3',
    d: '4'
};

result = {...obj1, ...obj2};
console.log(result) // {a: '1', b: '2', c: '3', d: '4'}