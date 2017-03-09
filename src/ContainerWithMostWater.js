/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
	var maxArea = 0 , area = 0;
   	var head = 0, tail = height.length - 1;
   	while((tail - head) > 0) {
   		area = Math.min(height[head] , height[tail]) * ( tail - head);
   		maxArea = Math.max(maxArea , area);
   		if(height[head] < height[tail])
   			head++;
   		else
   			tail--;
   	}
	return maxArea;
}

var INPUT = [1,5,1,1,1,5]; //1,5,1,1,1,5
var area = maxArea(INPUT);
console.log(area);
