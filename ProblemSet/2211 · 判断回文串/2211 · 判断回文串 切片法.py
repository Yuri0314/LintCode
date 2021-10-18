def is_palindrome(str_1: str) -> bool:
    '''
    :param str_1: Input a string
    :return: Whether it is a palindrome number
    '''
    return str_1 == str_1[::-1]
