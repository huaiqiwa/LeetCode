//java solution
//not handle s == null, let NullPointerException throw
//allow white space before or/and after the real long,
//for example: "  123  " is legal and will be covert to 123
//also "0123" is legal and will be covert to 123
//however, "  1 23" is considered illegal input
//all illegal inputs(including overflow) will throw IllegalArgumentException
//"a123" "12e2" "12.2" are all considered illegal
//limitations: cannot handle when the long = Long.MIN_VALUE, will be considered
//illegal input
long stringToLong(String s) {
	int len = s.length();
	if(len == 0) throw new IllegalArgumentException();
	//remove white space before and after
	int start = 0, end = s.length()-1;
	while(start <= end && (s.charAt(start) == ' ' || s.charAt(end) == ' ')) {
		if(s.charAt(start) == ' ') start++;
		if(s.charAt(end) == ' ') end--;
	}
	//input are all white space
	if(start > end) throw new IllegalArgumentException();
	//get sign of the long
	boolean neg = false;
	if(str.charAt(start) == '-' || str.charAt(start) == '+') {
		if(str.charAt(start) == '-') neg = true;
		start++;
	}
	//only contains a sign '-' or '+'
	if(start > end) throw new IllegalArgumentException();
	
	long result = 0;
	while(start <= end) {
		int d = str.charAt(start)-'0';
		if(d < 0 || d > 9) throw new IllegalArgumentException();
		if((Long.MAX_VALUE-d)/10 < result) throw new IllegalArgumentException();
		result = result*10 + d;
		start++;
	}
	return neg ? -result : result;
}

