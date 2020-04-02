import React, { Component, useState } from "react";
import TextField from "@material-ui/core/TextField";
import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
const textInputProps = {
  textNotE: {
    label: "제목",
    id: "margin-dense",
    margin: "dense",
    variant: "outlined",
    fullWidth: true
  },
  textE: {
    error: true,
    label: "길이초과",
    id: "margin-dense",
    margin: "dense",
    helperText: "25자 이내로 해주세요",
    variant: "outlined",
    fullWidth: true
  },
  textArea: {
    id: "outlined-multiline-static",
    label: "본문",
    multiline: true,
    rows: "4",
    variant: "outlined",
    fullWidth: true
  }
};

// props = > 사이즈
const WriteForm = props => {
  return (
    <div>
      <Box>
        <Textinput />
      </Box>
      <Box>
        <TextField {...textInputProps.textArea} />
      </Box>
      <Box display="flex" justifyContent="flex-end" bgcolor="background.paper" marginTop="5px">
        <Button variant="contained">제출</Button>
      </Box>
    </div>
  );
};

const Textinput = props => {
  // todo = x버튼 누르면 에러 표시 없애기 이벤트가 밸류체인지만 있네 ㅡㅡ
  const [error, setError] = useState(false);
  const onTextChange = event => {
    let textLength = event.target.value.length;
    let isTextLenOver = textLength >= 25;
    if (isTextLenOver && !error) {
      setError(x => true);
    } else if (!isTextLenOver && error) {
      setError(x => false);
    }
  };

  return error ? (
    <TextField {...textInputProps.textE} onChange={onTextChange} />
  ) : (
    <TextField {...textInputProps.textNotE} onChange={onTextChange} />
  );
};

export default WriteForm;
