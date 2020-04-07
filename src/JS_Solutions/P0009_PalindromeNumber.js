var isPalindrome = function(x) {
    if( x < 0) return false;
    return x == reverse(x);
};

var reverse = function(x) {
    var rnum = 0;
    while(x > 0) {
    	rnum *=10;
    	rnum += (x % 10)
    	x = parseInt(x / 10);
    }
    return rnum;
};

var INPUT = 1221;
var result = isPalindrome(INPUT);
if(result)
	console.log(INPUT + " is a Palindrome Number");
else 
	console.log(INPUT + " is not a Palindrome Number");

var INPUT2 = 1222;
var result2 = isPalindrome(INPUT2);
if(result2)
	console.log(INPUT2 + " is a Palindrome Number");
else 
	console.log(INPUT2 + " is not a Palindrome Number");