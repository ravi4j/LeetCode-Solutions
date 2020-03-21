/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
var merge = function(intervals) {
	if(intervals === null || intervals.length === 0)
		return intervals;
	var stack = [] , i = 0 , n = intervals.length;
	intervals = intervals.sort(sortByStartVal);
	while(i < n){
		if(stack.length === 0){
			stack.push(intervals[i++]);
			continue;
		}
		var current = intervals[i];
		var top = stack[stack.length - 1];
		if(top.end >= current.start ){
			top.end = (top.end > current.end) ? top.end : current.end ;
		} else {
			stack.push(current);
		}
		i++;
	}
    return stack;
};

var Interval = function(start , end){
	this.start = start;
	this.end = end;
};

var sortByStartVal = function(interval1 , interval2){
	return interval1.start - interval2.start;
}

var intervals = [new Interval(1,3) , new Interval(2,6) , new Interval(15 , 18) , new Interval(8 , 10)];
var results = merge(intervals);
console.log(results);

var intervals = [new Interval(1,3) , new Interval(3,3)];
var results = merge(intervals);
console.log(results);

var intervals = [new Interval(1,4),new Interval(4,5)];
var results = merge(intervals);
console.log(results);