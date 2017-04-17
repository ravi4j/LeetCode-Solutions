/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    if (s === null || s.length === 0)
        return 0;
    var stack = [], n = s.length, longest = 0;
    for (var i = 0; i < n; i++) {
        var ch = s.charAt(i);
        if ("(" === ch)
            stack.push(i);
        else {
            if (stack.length !== 0) {
            	 var top = stack[stack.length - 1];
                if (s.charAt(top) === "(" ){
 		             stack.pop();
 		         }   
                else
                    stack.push(i);
            } else
            		stack.push(i);
        }
    }
    console.log(" [ " + stack.join(" , ") + " ]");
    if (stack.length === 0)
        longest = n;
    else{
     var a = n , b = 0;		
     	while(stack.length !== 0){
     		b = stack.pop();
     		longest = Math.max(longest , a - b - 1);
     		a = b;
     	}
     	longest = Math.max(longest , a);
    }
    return longest;
};

var s = ")()())";
var result = longestValidParentheses(s);
console.log(result);

/*s = "()()()";
result = longestValidParentheses(s);
console.log(result);

s = "()(()((()))"
result = longestValidParentheses(s);
console.log(result); */