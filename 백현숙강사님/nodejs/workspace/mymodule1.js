function abs(number) {
  if (number > 0)
    return number;
  else
    return -number;
}

function isLeap(s) {
  if ((s % 4 == 0 && s % 100 != 0) || s % 400 == 0) return true;
  else return false;
}

function hello() {
  return "Hello nodejs";
}

// 외부로 
module.exports = abs;
module.exports = isLeap;
// module.exports