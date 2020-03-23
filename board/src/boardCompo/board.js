import React, { Component, useState } from "react";

function WriteForm() {
  return (
    <div>
      <div>
        <h1>게시판 폼</h1>
      </div>
      <div>
        <h3>제목</h3>
      </div>

      <div>
        <input type="text" placeholder="제목을 입력하세요" name="title"></input>
      </div>
    </div>
  );
}

function InputBox(placeholder) {
  const [isLengthOver, setIsLengthOver] = useState(false);
  const [textValue, setTextValue] = usesate("");

  let placeholderName = placeholder;

  return (
    <div>
      <div>
        <input type="text" placeholder={placeholderName}></input>
      </div>
    </div>
  );
}

export default WriteForm;
