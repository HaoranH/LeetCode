class Solution:
    # @return a boolean
    # This works, but time complexity is high
    # This solution takes the advantage of python string slicing.
    def isMatch(self, s, p):
        if p[-1] == '*':
            '''
            When the last charcter of p is '*', to prevent '*' from over matching 
            two situations need to be considered.
            1. It's an exact match with *
            2. There are extra characters that need to be matched with *
            '''
            if self.isMatch(s,p[:-2]):
                return True
            if s and (s[-1] == p[-2] or p[-2] == '.') and self.isMatch(s[:-1],p):
                return True
        '''
        The general case where only current characters need to be considered
        '''
        elif s and (s[-1] == p[-1] or p[-1] == '.') and self.isMatch(s[:-1],p[:-1]):
            return True
        return False