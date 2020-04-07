
var convert = function(s , numRows){
	var lines = [] , idx = 0;

	for(var k = 0 ; k < numRows ; k++)
		lines[k] = "";

	while(idx < s.length){
		for(var i = 0 ; i < numRows; i++){
			if(idx < s.length)
				lines[i] += s.charAt(idx++);
		}

		for(var j = numRows - 2 ; j > 0; j--){
			if(idx < s.length)
				lines[j] += s.charAt(idx++);
		}
	}

	return lines.join("");
}


var INPUT = "PAYPALISHIRING" , ROW = 3;
var lines = convert(INPUT, ROW);
console.log(lines);
for(var i = 0 ; i < lines.length ; i++){
	console.log(lines[i]);
}
