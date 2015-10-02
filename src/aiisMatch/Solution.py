class Solution:
    # @return a boolean
    # This works, but time complexity is high
    # This solution takes the advantage of python string slicing.
   def isMatch(self,s,p):
      if len(p) == 0:
          return len(s) == 0
      if len(p) == 1 or p[-1] != '*':
          if s and (p[-1] == s[-1] or p[-1] == '.'):
              return self.isMatch(s[:-1],p[:-1])
      else:
          if self.isMatch(s,p[:-2]): return True
          if s and (s[-1]==p[-2] or p[-2]=='.'):
              return self.isMatch(s[:-1],p)
      return False
