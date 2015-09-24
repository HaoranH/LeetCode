class Solution(object):
    # This solution will not work in that the time exceeds when
    # running case:
    # s = "aaaaaaaaaaaaab"
    # p = "a*a*a*a*a*a*a*a*a*a*c"
    # Looks like for python DP is required.
    def isMatch(self, s, p):
        """
            :type s: str
            :type p: str
            :rtype: bool
            """
        if len(p) == 0: return len(s) == 0
        
        if len(p) == 1 or p[1] != '*':
            if len(s) == 0 or (p[0] != s[0] and p[0]!= '.'): return False
            else: return self.isMatch(s[1:],p[1:])
        
        else:
            i = -1
            while i < len(s) and (i < 0 or p[0] == s[i] or p[0] == '.'):
                if self.isMatch(s[i+1:],p[2:]):return True
                i += 1
            return False