/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
	var seq = [];
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
			tempSeq.push(candidates[i]);
			//console.log("[ " + tempSeq.join(" , ") + " ]" , target - candidates[i]);
			combinationSumHelper(candidates , seq , tempSeq , target - candidates[i], i);
			tempSeq.pop();
		}	
	}

};

var candidates = [2,3,6,7] , target = 7;
var result = combinationSum(candidates , target);
console.log(" [ ");
for(var i = 0 ; i < result.length ; i++){
	console.log("[ " + result[i].join(" , ") + " ]");
}
console.log(" ] ");