/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function(s, words) {
    var result = [];

    if( s === null || s.length === 0 || words === null || words.lenght === 0)
    	return result;
    var wordFreqMap = {} , size = words[0].length;
    for(var i = 0 ; i < words.length ; i++){

    	if(wordFreqMap.hasOwnProperty(words[i])){
    		wordFreqMap[words[i]] += 1; 
    	} else {
    		wordFreqMap[words[i]] = 1;
    	}
    }
    //console.log(JSON.stringify(wordFreqMap));
    for(var j = 0 ; j < size ; j++){
    	var current = {} , start = j , count = 0;
    	for(i = j ; i <= (s.length - size) ; i = i + size){
    		var sub = s.substring(i , i + size);
    		console.log(s, i , i + size , sub);
    		if(wordFreqMap.hasOwnProperty(sub)){
    			if(current.hasOwnProperty(sub)){
    				current[sub] +=1;
    			} else {
    				current[sub] = 1;
    			}
   				count++;
   				 console.log(JSON.stringify(current));
   				while(current[sub] > wordFreqMap[sub]){
   					var left = s.substring(start, start+size);
                    current[left] -= 1;
                    count--;
                    start = start + size;
   				}

   				if(count === words.length){
   					result.push(start);
   					left = s.substring(start, start+size);
                    current[left] -=1;
                    count--;
                    start = start + size;
   				}	
    		}else{
    			current = {};
    			start = i + size;
    			count = 0;
    		}
    	}
    }
    return result;
};

var s = "barfoothefoobarman", words = ["foo", "bar"];
var result = findSubstring(s,words);
console.log(" [ " + result.join(" , ") + " ] ");