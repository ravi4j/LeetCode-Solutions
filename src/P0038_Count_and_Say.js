/**
 * @param {number} n
 * @return {string}
 */
var countAndSay = function(n) {
	var result = "1";
	if( n === 1)
		return result;
	while(n > 1) {
		result = say(result);
		n--;
	}	
	return result	
};

var say = function(s){
   var result = "" ; p = s.charAt(0) , idx = 1 , count = 1;
   while(idx < s.length){
   	var ch = s.charAt(idx); 
   	if(p != ch){
   		result += count + p;
   		p = ch;
   		count = 1;	
   	} else{
   		count++;	
   	}	
   	idx++;
   }
   return result += count + p;
};

var n = 10;
var result = countAndSay(n);
console.log(result);
