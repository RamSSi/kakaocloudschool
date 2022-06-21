function go() {
  showCircle(150, 150, 100)
  .then(
    div => {
    div.classList.add('message-ball');
    div.append("Hello, world!");
  });
}

function showCircle(cx, cy, radius) {
  //div태그를 추가한다 
  let div = document.createElement('div');
  div.style.width = 0;
  div.style.height = 0;
  div.style.left = cx + 'px';
  div.style.top = cy + 'px';
  div.className = 'circle';
  document.body.append(div);

  //함수 수행후 Promise 객체를 반환한다 
  return new Promise(resolve => {
    //시간이 가면서 원의 넓이와높이를 키운다 
    setTimeout(() => {
          div.style.width = radius * 2 + 'px';
          div.style.height = radius * 2 + 'px';

          div.addEventListener('transitionend', function handler() {
              //수행완료후 콜백함수를 호출한다 
              div.removeEventListener('transitionend', handler);
              resolve(div);
          });
      }, 0);
  })
}