class Solution:
    # @return a boolean
    
    # Faster method. Every ref[i][j] stands for the result of the ith substring in p and jth in s matching.
    def isMatch(self,s,p):
        ref = [[False]*(len(s)+1) for _ in xrange(len(p)+1)]
        # Base case, where s and p match exactly.
        ref[0][0] = True
        # Cases where substring of p matches s and the last part is '.*' or 'A*'
        for i in xrange(2,len(p)+1):
            ref[i][0] = ref[i-2][0] and p[i-1] == '*'
                        
        for i in xrange(1,len(p)+1):
            for j in xrange(1,len(s)+1):
                if p[i-1] != '*':
                    ref[i][j] = (s[j-1] == p[i-1] or p[i-1] == '.') and ref[i-1][j-1]
                else:
                    # Where the letter before * in p either matches last letter of s or not.
                    ref[i][j] = ref[i-1][j] or ref[i-2][j]
                    # Find the max number of repeats of *.
                    if (s[j-1] == p[i-2] or p[i-2] == '.') and ref[i][j-1]:
                        ref[i][j] = True
        return ref[-1][-1]