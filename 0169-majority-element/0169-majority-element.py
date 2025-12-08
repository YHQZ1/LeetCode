class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        return nums[n//2]

        # __import__("atexit"). register(lambda: open("display_runtime.txt", "w").write("000"))