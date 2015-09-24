class Solution:
    # @return a boolean
    # What's different from backtracksolution1 is a reference dictionary is introduced.
    # However, I didn't see much reduction in time consumption, and I'm not sure if this
    # really works for Leetcode testing.
    dic = {}
    def isMatch(self, s, p):
        if (s,p) in self.dic: return True
        if not p: return not s
        if p[-1] == '*':
            if self.isMatch(s,p[:-2]):
                self.dic[(s,p)] = True
                return True
            if s and (s[-1] == p[-2] or p[-2] == '.') and self.isMatch(s[:-1],p):
                self.dic[(s,p)] = True
                return True
        elif s and (s[-1] == p[-1] or p[-1] == '.') and self.isMatch(s[:-1],p[:-1]):
            self.dic[(s,p)] = True
            return True
        
        return False