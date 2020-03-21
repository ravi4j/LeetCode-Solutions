/**
 * @param {string[]} words
 * @param {number} maxWidth
 * @return {string[]}
 */
var fullJustify = function(words, maxWidth) {
   var rows = allignWordsInRow(words , maxWidth);
    var rowLen = 0  , spaces = 0 , dspaces = 0 , remspaces = 0; 
   for( let i = 0 ; i < rows.length ; i++){
     rowLen = rows[i].join('').length;
   	 if(i !== rows.length -1 && rowLen < maxWidth){
   	 	spaces = (maxWidth - rowLen) ;
   	 	dspaces = Math.floor(spaces / (rows[i].length - 1));
   	 	remspaces = (spaces) % (rows[i].length - 1);
   	 //	console.log(spaces , dspaces , remspaces);
   	 	for(let j = 0 ; j < rows[i].length - 1 ; j++){
   	 		rows[i][j] = rows[i][j] + ' '.repeat(dspaces);
   	 		if(remspaces > 0){
   	 		   rows[i][j] = rows[i][j] + ' ';
   	 		   remspaces--;
   	 		}
   	 	}
      let str = rows[i].join('');
       if(str.length < maxWidth){
         let diff = maxWidth - str.length;
          str = str + ' '.repeat(diff);
       }
      rows[i] = str;
   	 } else { // last Line
       for(let j = 0 ; j < rows[i].length - 1 ; j++){
          rows[i][j] = rows[i][j] + ' ';
       }
       let str = rows[i].join('');
       if(str.length < maxWidth){
         let diff = maxWidth - str.length;
          str = str + ' '.repeat(diff);
       }
   	 	rows[i] = str;
   	 }
   }
   return rows; 
};

var  allignWordsInRow = function(words , maxWidth){
  var result = [], wlen =0 , len = 0 , line = [] , index = 0;
  for(let i = 0 ; i < words.length ; i++){
  	 wlen = words[i].length;
  	 if(len + wlen <= maxWidth){
  	 	line[index++] = words[i];
  	 	len += wlen;
  	 	if(len < maxWidth){
  	 		len += 1;
  	 	}
  	 } else{
   	 	result.push(line);
  	 	len = 0;
  	 	line = [];
  	 	index = 0;
  	 	i--;
  	 }
  }
  // LAST line
  if(line.length !== 0){
  	result.push(line);
  }
  return result;
} ;

var words = ["This", "is", "an", "example", "of", "text", "justification."] , maxWidth = 16;
var result = fullJustify(words,maxWidth);
console.log(result);

var words = [""] , maxWidth = 6;
var result = fullJustify(words,maxWidth);
console.log(result); 

var words = ["Listen","to","many,","speak","to","a","few."] , maxWidth = 6;
var result = fullJustify(words,maxWidth);
console.log(result); 

var words = ["What","must","be","shall","be."], maxWidth = 12;
var result = fullJustify(words,maxWidth);
console.log(result); 


