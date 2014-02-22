public int mergeSortCount(int[] nums) {
	int[] helper = new int[nums.length];
	return mergeSortCount(nums, 0, nums.length-1, helper);
}

private int mergeSortCount(int[] nums, int start, int end, int[] helper) {
	if(start >= end) return 0;
	int invCount = 0;
	int mid = start + (end-start)/2;
	invCount += mergeSortCount(nums, start, mid, helper);
	invCount += mergeSortCount(nums, mid+1, end, helper);
	invCount += mergeCount(nums, start, mid, end, helper);
	return invCount;
}

private int mergeCount(int[] nums, int start, int mid, int end, int[] helper) {
	int i = start, j = mid+1, k = start, invCount = 0;
	while(i <= mid && j <= end) {
		if(nums[i] <= nums[j]) helper[k++] = nums[i++];
		else {
			invCount += (mid-i+1);
			helper[k++] = nums[j++];
		}
	}
	while(i <= mid) {
		helper[k++] = nums[i++];
	}
	while(j <= end) {
		helper[k++] = nums[j++];
	}
	for(int i = start; i <= end; i++) {
		nums[i] = helper[i];
	}
	return invCount;
}