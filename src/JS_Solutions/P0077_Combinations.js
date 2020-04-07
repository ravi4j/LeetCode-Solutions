/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    let results = [];
    combineHelper(n , k , 1, [] , results);
    return results;
};

var combineHelper = function(n , k , index , combination , results){
    if(combination.length === k){
        results.push([].concat(combination));
    }
    for(let i = index ; i <= n; i++){
        if(combination.indexOf(i) === -1){
            combination.push(i);
            combineHelper(n , k , i + 1 , combination , results);
            combination.pop();
        }    
    }
};

let n = 4 , k = 1;
let result = combine(n , k);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}

 n = 4 , k = 2;
result = combine(n , k);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}

n = 4 , k = 3;
result = combine(n , k);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}

n = 4 , k = 4;
result = combine(n , k);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}


n = 3 , k = 1;
 result = combine(n , k);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}

n = 3 , k = 2;
result = combine(n , k);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}

n = 3 , k = 3;
result = combine(n , k);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}
