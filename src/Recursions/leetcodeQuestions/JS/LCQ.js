/**
 * Calculate the nth Fibonacci number.
 * @param {number} n - The index of the Fibonacci number to calculate.
 * @return {number} - The nth Fibonacci number.
 */
var fib = function (n) {
    if (n <= 1) {
        return n;
    } else {
        return fib(n - 1) + fib(n - 2);
    }
};

console.log(fib(10)); // Output: 55


// you can also solve it with a better time complexity using memoization

/**
 * Calculate the nth Fibonacci number using memoization.
 * @param {number} n - The index of the Fibonacci number to calculate.
 * @param {Array} memo - An array to store calculated Fibonacci numbers.
 * @return {number} - The nth Fibonacci number.
 */
var fib = function (n, memo = []) {
    if (n <= 1) {
        return n;
    } else if (memo[n] !== undefined) {
        return memo[n];
    } else {
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }
};

console.log(fib(10)); // Output: 55
