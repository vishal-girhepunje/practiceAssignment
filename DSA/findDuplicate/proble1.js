/*Check duplicate Ended
Description

Given an array of integers, check if it contains duplicate element. If present then print YES else print NO.
Input
1<=T<=10

1<=N<=100000

1<=Ai<=100000


Output
output YES or NO as described for each test case.

Sample Input 1 

3
1
1
2
1 1
3
1 2 3
Sample Output 1

NO
YES
NO */

function runProgram(input) {
  // Write code here
  let x = input.split("\n");
  let tc = +x[0];
  let line = 1;
  while (tc--) {
    let n = +x[line++];
    let arr = x[line++].split(" ").map(Number);
    checkDuplicate(n, arr);
  }
}

function checkDuplicate(n, arr) {
  let flag = "NO";
  if (n == 1) {
    flag = "NO";
  } else {
    arr.sort(function (a, b) {
      return a - b;
    });
    for (let i = 0; i < n - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        flag = "YES";
      }
    }
  }
  console.log(flag);
  console.log("f1");
}
function checkDuplicate(n, arr) {
  // console.log(n,arr);
  let obj = {};
  for (let i = 0; i < n; i++) {
    if (obj[arr[i]] == undefined) {
      obj[arr[i]] = 1;
    } else {
      obj[arr[i]]++;
    }
  }
  // console.log(obj);
  let count = 0;
  for (let key in obj) {
    if (obj[key] > 1) {
      count++;
    } else {
      continue;
    }
  }
  // console.log(count)
  if (count >= 1) {
    console.log("YES");
  } else {
    console.log("NO");
  }
  // console.log("f2");
}
if (process.env.USER === "") {
  runProgram(``);
} else {
  process.stdin.resume();
  process.stdin.setEncoding("ascii");
  let read = "";
  process.stdin.on("data", function (input) {
    read += input;
  });
  process.stdin.on("end", function () {
    read = read.replace(/\n$/, "");
    read = read.replace(/\n$/, "");
    runProgram(read);
  });
  process.on("SIGINT", function () {
    read = read.replace(/\n$/, "");
    runProgram(read);
    process.exit(0);
  });
}
  