/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
  var cache = []; 
  for(let i = 0 ; i <= word1.length ; i++){
      cache[i] = [];
      for(let j = 0; j <= word2.length ; j++){
          cache[i][j] = -1;
      }
  } 
  return minDistanceHelper(word1 , word1.length - 1 , word2 , word2.length - 1 , cache);
};

var minDistanceHelper = function(word1 , word1_idx , word2 , word2_idx , cache){

    if(word1_idx < 0){
        return word2_idx + 1;
    }

    if(word2_idx < 0){
        return word1_idx + 1;
    }

    if( cache[word1_idx][word2_idx] === -1){
        if(word1.charAt(word1_idx) === word2.charAt(word2_idx)){
            cache[word1_idx][word2_idx] = minDistanceHelper(word1 , word1_idx - 1 , word2 , word2_idx - 1 , cache);
        } else {
            let subsituteLast = minDistanceHelper(word1 , word1_idx - 1 , word2 , word2_idx - 1, cache);
            let addLast = minDistanceHelper(word1 , word1_idx , word2 , word2_idx - 1 , cache);
            let deleteLast = minDistanceHelper(word1 , word1_idx - 1 , word2 , word2_idx , cache);
            cache[word1_idx][word2_idx] = 1 + Math.min(subsituteLast , Math.min(addLast , deleteLast));
        }
    }
    return cache[word1_idx][word2_idx];
};

/*let word1 = 'Carthorse' , word2 = 'Orchestra';
let result = minDistance(word1 , word2);
console.log(result);

word1 = 'DalaD' , word2 = 'DalaD';
result = minDistance(word1 , word2);
console.log(result); */

/* Without Recursion */

var minDistanceNonRecursive = function(word1 , word2){
    let cache = []; 
    for(let i = 0 ; i <= word1.length ; i++){
      cache[i] = [];
      for(let j = 0; j <= word2.length ; j++){
          if( i === 0 )
             cache[i][j] = j;
          else if( j === 0 )   
            cache[i][j] = i;
          else 
            cache[i][j] = 0;  

        }
    }
    for( let i = 1; i <= word1.length ; i++){
      for( let j = 1; j <= word2.length ; j++){
          let  substitutionCost = 0;
          if(word1.charAt(i - 1) !== word2.charAt( j - 1) )
             substitutionCost = 1;
           cache[i][j] = Math.min(cache[i-1][j] + 1,                  // deletion
                             cache[i][j-1] + 1,                   // insertion
                             cache[i-1][j-1] + substitutionCost)  // substitution
          
      }
    }
  return cache[word1.length][word2.length];
};

word1 = 'Carthorse' , word2 = 'Orchestra';
result = minDistanceNonRecursive(word1 , word2);
console.log(result);

word1 = 'DalaD' , word2 = 'DalaD';
result = minDistanceNonRecursive(word1 , word2);
console.log(result);

