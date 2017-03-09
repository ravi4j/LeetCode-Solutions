var longestPalindromeDP = function(s) {
    var dp = [] , max = 0, startIndex = 0 ;
	for(var i = 0 ; i < s.length ; i++)
		dp[i] = [];

    // All single length substring are polindromic
	for(i = 0 ; i < s.length ; i++){
		dp[i][i] = true;
		max = 1;
	}	
	
	for(i = 0 ; i < s.length; i++){
		if(s.charAt(i) == s.charAt(i+1)){
			dp[i][i+1] = true;
			startIndex = i;
			max = 2;
		}
	}

	for(var k = 3 ; k <= s.length; ++k){
		for(i = 0 ; i < s.length - k + 1 ; ++i){
			var j = i + k - 1;
			if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
				dp[i][j] = true;
				if( k > max){
					max = k;
					startIndex = i;
				}
			}
		}
	}


	return s.substring(startIndex , startIndex + max );
};

var longestPalindrome = function(s) {
    var start = 0 , end = 0;
	for(var i = 0 ; i < s.length ; i++) {
		var len1 = expandAroundCenter(s , i , i);
		var len2 = expandAroundCenter(s , i , i + 1);
		var len = Math.max(len1 , len2);
		if(len > (end - start)){
			start = i - parseInt((len - 1)/2) ;
			end = i + parseInt(len/2);
		}
	}
	return s.substring(start,end+1);
};

var expandAroundCenter = function(str, left, right ){
	var L = left , R = right;
	while( L >= 0 && R < str.length  && str.charAt(L) === str.charAt(R)){
		L--;
		R++;
	}
	return R - L - 1;
};

var INPUT = "BABAD";
var result = longestPalindrome(INPUT);
console.log("Longest palindrome substring of " + "[" + INPUT + " ] : "  + result);

