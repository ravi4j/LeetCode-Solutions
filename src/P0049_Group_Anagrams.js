/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
	var retValues = [];
	var results = {};
	var str , temp;
	for(var i = 0 ; i < strs.length ;i++){
		str = strs[i];
		temp = str.split('');
		temp = temp.sort();
		temp = temp.join('');
		if(!results.hasOwnProperty(temp)){
			results[temp] = [str];
		} else {
			results[temp].push(str);
		}
	}
    //console.log(JSON.stringify(results));
    for(var key in results){
    	retValues.push([].concat(results[key]));
    }
    return retValues;
};

var strs = ["eat", "tea", "tan", "ate", "nat", "bat"];
var results = groupAnagrams(strs);
for(var i = 0 ; i < results.length;i++)
	console.log(results[i]);