console.log("Tính tổng dãy số Fibonacci trong 1 số cho trước");

let sum: number = 0;
let fibonacci = (n: number): number => {
    if (n == 0 || n == 1) {
        return n;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
};

let sumFibonacci = (n: number): number => {
    console.log(n + " số đầu tiên của dãy số fibonacci");
    for (let i = 0; i < n; i++) {
        let tempFibonacci = fibonacci(i);
        console.log(tempFibonacci);
        sum += tempFibonacci;
    }
    console.log("Tổng của " + n + " số fibonacci đó là: ");
    return sum;
};

console.log(sumFibonacci(30));