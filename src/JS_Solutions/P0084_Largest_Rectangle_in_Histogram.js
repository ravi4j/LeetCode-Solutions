/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    if (heights === null || heights.length === 0)
        return 0;
    let stack = new Stack();
    let left = [];
    for (var i = 0; i < heights.length; i++) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            stack.pop();
        }
        let l = stack.isEmpty() ? -1 : stack.peek();
        left.push(l);
        stack.push(i)
    }
    console.log("left", left);
    // clear stack
    stack.clear();
    let right = [];
    for (let i = heights.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            stack.pop();
        }
        right[i] = stack.isEmpty() ? heights.length : stack.peek();
        stack.push(i);
    }
    console.log("right", right);
    let area = 0;
    for (let i = 0; i < heights.length; i++) {
        let area_i = heights[i] * (right[i] - left[i] - 1);
        area = Math.max(area, area_i)
    }

    return area;
};

class Stack {
    constructor() {
        this.items = [];
        this.count = 0;
    }

    getLength() {
        return this.count;
    }

    push(item) {
        this.items.push(item);
        this.count = this.count + 1;
    }

    pop() {
        if (this.count > 0) {
            this.count = this.count - 1;
        }

        return this.items.pop();
    }

    peek() {
        return this.items.slice(-1)[0];
    }

    isEmpty() {
        return this.count === 0 ? true : false;
    }

    clear() {
        while (!this.isEmpty()) {
            this.pop();
        }
    }
}

var heights = [2, 1, 5, 6, 2, 3];
var result = largestRectangleArea(heights);
console.log(result);

heights = [];
result = largestRectangleArea(heights);
console.log(result);

heights = [2, 2, 2, 2];
result = largestRectangleArea(heights);
console.log(result);

heights = [2, 3, 2, 1];
result = largestRectangleArea(heights);
console.log(result);