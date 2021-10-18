def is_palindrome(str_1: str) -> bool:
    '''
    :param str_1: Input a string
    :return: Whether it is a palindrome number
    '''
    left, right = 0, len(str_1) - 1
    while left < right:
        if str_1[left] != str_1[right]:
            return False
        left += 1
        right -= 1
    return True
