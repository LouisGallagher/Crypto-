from math import sqrt, ceil, floor

def main ():
    pkey_file = open("publickey.txt", "r")
    pkey = int(pkey_file.read().replace("\n", ""))

    ciphertext_file = open("ciphertext.txt", "r")
    ciphertext_input = ciphertext_file.read()
    ciphertext_input_processed = ciphertext_input.replace("\n", "")
    ciphertext_bits = [int(n) for n in
        ciphertext_input_processed.split(":")]

    factor = fermat_factorisation(pkey, 100000)
    print(factor)
    
    plaintext_bits = [gm_decrypt_bit(encrypted_bit, factor) for
        encrypted_bit in ciphertext_bits]
    
    byte_lists = [plaintext_bits[i:i+8] for i in
        [8*n for n in range(0, len(plaintext_bits) // 8)]]
    
    bytes = [''.join(byte_list[::-1]) for byte_list in byte_lists]
    
    ascii_encoded_msg = [int(byte, 2) for byte in bytes]
    
    message = ''.join([chr(ascii_code) for ascii_code in ascii_encoded_msg])
        
    print(message)

def gm_decrypt_bit (x, p):
    """Returns plaintext bit as a string.
    Parameters
        x: encrypted bit, which is a number.
        p: from private key N=p*q, p & q are primes.
    """
    return "0" if legendre_nonrecursive(x, p) == 1 else "1"
    
def legendre_symbol (m, n):
    if m >= n:
        return legendre_symbol(m % n, n)

    elif m == 0 or m == 1:
        return m
    
    elif m == 2:
        if n % 8 in [1, 7]:
            return 1
        elif n % 8 in [3, 5]:
            return -1

    elif m % 2 == 0:
        return legendre_symbol(2, n) * legendre_symbol(m // 2, n)

    else:
        if m % 4 == 3 and n % 4 == 3:
            return - legendre_symbol(n, m)
        else:
            return legendre_symbol(n, m)

def legendre_nonrecursive (m, n):
    product_parts = [(m, n)]
    answer = 1
    while product_parts:
        print(answer, product_parts)579 
        m, n = product_parts[0]
        if m >= n:
            product_parts.append((m % n, n))
        elif m == 0 or m == 1:
            answer *= m
        elif m == 2:
            if n % 8 in [1, 7]:
                answer *= 1
            elif n % 8 in [3, 5]:
                answer *= -1
        elif m % 2 == 0:
            product_parts.append((2, n))
            product_parts.append((m // 2, n))
        else:
            if m % 4 == 3 and n % 4 == 3:
                answer *= -1
            product_parts.append((n, m))
        
        product_parts = product_parts[1:]
    
    return answer
    
def get_factor (n):
    factor = trial_division(n, True)
    if factor != -1:
        return factor
    
    factor = fermat_factorisation(n)
    return factor

def fermat_factorisation (n, attempts=1000):
    t_inc = 1
    while t_inc <= attempts:
        t = floor(sqrt(n)) + t_inc
        s2 = t*t - n
        
        if is_square(s2):
            s = int(sqrt(s2))
            q = t - s
            return q
        
        t_inc += 1
        
    return -1

def trial_division (n, small_factors_only=False, small_factor_bound=1000000):
    if n % 2 == 0: return 2
    
    if small_factors_only:
        bound = min(small_factor_bound, ceil(sqrt(n)))
    else:
        bound = ceil(sqrt(n))
    
    i = 3
    while i < bound:
        if n % i == 0:
            return i
        i += 2
        
    return -1

def is_square (n):
    """Stolen from:
    http://stackoverflow.com/questions/2489435/
        how-could-i-check-if-a-number-is-a-perfect-square
    """
    x = n // 2
    seen = set([x])
    while x * x != n:
        x = (x + (n // x)) // 2
        if x in seen: return False
        seen.add(x)
    return True
    
if __name__ == "__main__":
    main()
