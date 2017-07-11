/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if( s === null || t === null || s === '' || t === '')
        return '';
   let target = buildTargetMap(t) , source = new Map();
   let start = 0 , end = 0 , min = Number.MAX_VALUE , count = 0, minWindow = '';
   while( end < s.length) {
     let ch = s.charAt(end);
     if(target.has(ch)){
        if(source.has(ch)){
            if(source.get(ch) < target.get(ch)){
                count++;
            }
            source.set(ch , source.get(ch) + 1);
        } else {
             source.set(ch , 1);
             count++;
        }
     }
     if(count === t.length){
         let ch = s.charAt(start);
         while(!source.has(ch) || source.get(ch) > target.get(ch)){
             if(source.has(ch) && source.get(ch) > target.get(ch)){
                 source.set(ch , source.get(ch) - 1);
             }
             start++; 
             ch = s.charAt(start);  
         }
         if(end - start + 1< min){
             min = end - start + 1;
             minWindow = s.substring(start , end + 1);
         }
     }
     end++;
   }
   return minWindow;
};

var buildTargetMap = function(t){
 let map = new Map();
    for(let i = 0 ; i < t.length ; i++){
        let ch = t.charAt(i);
        if(map.has(ch)){
            map.set(ch , map.get(ch) + 1);    
        } else {
            map.set(ch , 1);
        }
    }
    return map;
};

let S = "ADOBECODEBANC";
let T = "ADOBECODEBANC";
let result = minWindow(S , T);
console.log(result);

S = "abc";
T = "ab";
result = minWindow(S , T);
console.log(result);