/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
	var seq = [];
	candidates.sort(function(a ,b) { return a -b;});
	combinationSumHelper(candidates , seq , [] , target, 0);
	return seq;
};

var combinationSumHelper = function(candidates , seq , tempSeq , target , start){
	if( target < 0)
		return;
	else if(target === 0){
		seq.push([].concat(tempSeq));
	} else  if( target > 0 ){
		for(var i = start ; i < candidates.length ; i++){
			if(i>start && candidates[i] === candidates[i-1])
				continue;
			tempSeq.push(candidates[i]);
			//console.log("[ " + tempSeq.join(" , ") + " ]" , target - candidates[i]);
			combinationSumHelper(candidates , seq , tempSeq , target - candidates[i], i + 1);
			tempSeq.pop();
		}	
	}

};

var candidates = [10, 1, 2, 7, 6, 1, 5] , target = 8;
var result = combinationSum2(candidates , target);
console.log(" [ ");
for(var i = 0 ; i < result.length ; i++){
	console.log("[ " + result[i].join(" , ") + " ]");
}
console.log(" ] ");