import React, { Component, useState } from "react";
import TextField from "@material-ui/core/TextField";
import Box from "@material-ui/core/Box";
import Button from "@material-ui/core/Button";
import { makeStyles } from "@material-ui/core/styles";
import Avatar from "@material-ui/core/Avatar";

const useStyles = makeStyles(theme => ({
  root: {
    display: "flex",
    "& > *": {
      margin: theme.spacing(1)
    }
  },
  small: {
    width: theme.spacing(3),
    height: theme.spacing(3)
  },
  large: {
    width: 150,
    height: 150
  },
  profileFontSize: {
    fontSize: 5
  },
  introduceFSize: {
    marginTop: 10,
    fontSize: 8
  },
  bt:{
    maxWidth: "10px",
    maxHeight: "10px",
    minWidth: "10px",
    minHeight: "10px",
    fontSize: 1,
    textTransform: 'lowercase',
    lineHeight : 0
  }
}));

const props = {
  dFjS: {
    display: "flex",
    justifyContent: "flex-start"
  },
  dFjC: {
    display: "flex",
    justifyContent: "center"
  },
  dFjE:{
    display: "flex",
    justifyContent:"flex-end"
  },
  bt: {
 
    variant:"contained"
  }
};

const Main = () => {
  let authorName = "정윤성";
  let introduce = "안녕하세요 연습중인데 져낸 힘드네여";
  const classes = useStyles();
  return (
    <div>
      <Box display="flex" p={1} bgcolor="background.paper" width="100%">
        {/*프로필박스 여기는 버튼누르면 애니메이션 사이드바가 가림.*/}
        <Box width={"10%"}>
          <Avatar
            variant="square"
            className={classes.large}
            src={require("../../img/no_image_161.png")}
          />
          <Box {...props.dFjS} className={classes.profileFontSize}>
            {" "}
            {authorName}{" "}
          </Box>
          <Box {...props.dFjC} className={classes.introduceFSize}>
            {introduce}
          </Box>
          <Box {...props.dFjE}>
            <Button {...props.bt} className ={classes.bt} >edit</Button>
          </Box>
        </Box>
        {/*게시판 박스 */}
        <Box width={"70%"}></Box>
        
      </Box>
    </div>
  );
};

export default Main;
