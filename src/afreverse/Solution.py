class Solution:
   def isMatch(self,s,p):
      ref = [[False]*(len(s)+1) for _ in xrange(len(p)+1)]
      ref[0][0] = True
      
      for i in xrange(2,len(p)+1):
          ref[i][0] = ref[i-2][0] and p[i-1] == '*'
    
      for i in xrange(1,len(p)+1):
          for j in xrange(1,len(s)+1):
              if p[i-1] != '*':
                  ref[i][j] = (s[j-1] == p[i-1] or p[i-1] == '.') and ref[i-1][j-1]
              else:
                  ref[i][j] == ref[i-2][j] or ref[i-1][j]
                  if s[j-1] == p[i-2] or p[i-2] == '.':
                        ref[i][j] |= ref[i][j-1]
      return ref[-1][-1]
test = Solution()
test.isMatch("aaa","ac*ad*a")