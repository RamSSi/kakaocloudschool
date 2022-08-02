// // Array.prototype.map()

// const array1 = [1, 4, 5, 7, 9, 16]

// // const map1 = array1.map(function(x) {
// //     return x * 2;
// // })

// const map1 = array1.map((x) => x * 2);
// console.log(map1);



// Array.prototype.filter()
// : 주어진 함수의 조건을 통과하는 모든 요소를 모아 새로운 배열로 반환

const words = ['세종대왕', '이황', '강감찬', '샤인머스켓', "소리없는 아우성"];
words.filter((word) => {
    return word.length > 3;
})