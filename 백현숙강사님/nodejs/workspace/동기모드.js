let fs = require("fs");

try {
  let data = fs.readFileSync("./mymodule1.js", "utf-8");
}
catch(e) {
  console.log(e);
}

console.log("종료");