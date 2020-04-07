/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    var i = 0 , j = height.length - 1;
    var lmax = 0 , rmax = 0 , max = 0;
    while(i <= j){
    	lmax = Math.max(lmax , height[i]);
    	rmax = Math.max(rmax , height[j]);
    	console.log(lmax , rmax);
    	if(lmax < rmax){
    		max += (lmax - height[i]);
    		i++;
    	} else {
    		max += (rmax - height[j]);
    		j--;
    	}
    }
    return max;
};

var height = [0,1,0,2,1,0,1,3,2,1,2,1];
var result = trap(height);
console.log(result);

 height = [4,2,3];
 result = trap(height);
console.log(result);