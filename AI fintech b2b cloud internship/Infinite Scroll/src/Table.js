import React, { useState, useEffect } from "react";
import { CircularProgress } from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import axios from "axios";
import InfiniteScroll from "react-infinite-scroll-component";

const useStyles = makeStyles({
  table: {
    minWidth: 650
  }
});

export default function BasicTable() {
  const classes = useStyles();
  const [limiting, setlimit] = useState(1);
  let [isNext, isNextFunc] = React.useState(false);
  const APi =
    "https://picsum.photos/v2/list?_page={page-number}&_limit={count}";
  const [rows, setrows] = useState([]);
  const Apii = () => {
    axios
      .get(`https://picsum.photos/v2/list?page=${limiting}&limit=10`)
      .then((res) => {
        setrows([...rows, ...res.data]);
        isNextFunc(true);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    setlimit(limiting + 1);
    Apii();
  }, []);
  return (
    <TableContainer component={Paper}>
      <InfiniteScroll
        dataLength={rows.length}
        next={Apii}
        hasMore={isNext}
        loader={
          <div
            style={{ height: "80%", paddingLeft: "35%", overflow: "hidden" }}
          >
            <CircularProgress />
          </div>
        }
      >
        <Table className={classes.table} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell align="right">Author</TableCell>
              <TableCell align="right">width</TableCell>
              <TableCell align="right">Height</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row, index) => (
              <TableRow key={index.toString()}>
                <TableCell component="th" scope="row">
                  {row.id}
                </TableCell>
                <TableCell align="right">{row.author}</TableCell>
                <TableCell align="right">{row.width}</TableCell>
                <TableCell align="right">{row.height}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </InfiniteScroll>
    </TableContainer>
  );
}
