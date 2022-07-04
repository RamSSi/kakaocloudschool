var fs = require("fs");

// try {
//   fs.readFile("./mymodule1.js", "utf-8", (error, data) => {
//     console.log(data);
//   });
// }
// catch(e) {
//   console.log(e);
// }


fs.readFile("./mymodule1.js", "utf-8", (error, data) => {
  if(error) { // error가 발생하면 error 객체가 만들어져 전달됨
    console.log(error);
    return;
  }

  console.log(data);
})

console.log("종료");