
var reverse = function(x) {
    var sign =  false;
    if(x < 0) sign = true;
    x = sign ? -1 * x : x;
    var rnum = 0;
    while(x > 0) {
    	rnum *=10;
    	rnum += (x % 10)
    	x = parseInt(x / 10);
    }
    return sign ? -1 * rnum : rnum;
};

var INPUT = 123;
var result = reverse(INPUT);
console.log(result);


var INPUT2 = -123;
var result2 = reverse(INPUT2);
console.log(result2);

var INPUT2 = 1534236469;
var result2 = reverse(INPUT2);
console.log(result2);
