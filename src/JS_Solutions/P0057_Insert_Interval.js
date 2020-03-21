/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @param {Interval} newInterval
 * @return {Interval[]}
 */
var insert = function(intervals, newInterval) {
    var indexAt = insertAt(intervals , newInterval);
    insertIntervalAt(intervals , newInterval , indexAt);
    return merge(intervals);
};

var insertIntervalAt = function(intervals, newInterval , indexAt){
	var size = intervals.length , start = indexAt;
	for(var i = size ; i > start ; i--){
		intervals[i] = intervals[i - 1];
	}
	intervals[indexAt] = newInterval;
};

var insertAt = function(intervals, newInterval){
	for(var i = 0 ; i < intervals.length ; i++){
		if(intervals[i].start >= newInterval.start){
			return i;
		}
	}
	return i;
};


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

var intervals = [ new Interval(1,3), new Interval(6,9)] , newInterval = new Interval(2,5);
var result = insert(intervals , newInterval);
console.log(result);

intervals = [ new Interval(1,2), new Interval(3,5) , new Interval(6,7) , new Interval(8,10) , new Interval(12,16)] , newInterval = new Interval(4,9);
result = insert(intervals , newInterval);
console.log(result);

intervals = [] , newInterval = new Interval(4,9);
result = insert(intervals , newInterval);
console.log(result);

intervals = [new Interval(4,9)] , newInterval = new Interval(3,9);
result = insert(intervals , newInterval);
console.log(result);