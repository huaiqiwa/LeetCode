int count = 0; 
while(n > 0) { 
	//n-1 will set the right most set bit to zero. 
	//AND with the same number will sustain the remaining bits 
	n &= n-1; 
	count++; 
} 
