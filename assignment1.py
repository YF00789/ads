def printDigits(n):
    if n<10:
        print(n)
        return
    printDigits(n//10)
    print(n%10)
def sumOfNums(arr, n):
    if n==0:
        return 0
    return arr[n-1]+sumOfNums(arr, n-1)
def isPrimeRec(n, div=2):
    if n<=1:
        return False
    if div*div>n:
        return True
    if n%div==0:
        return False
    return isPrimeRec(n, div+1)
def checkPrime(n):
    if isPrimeRec(n):
        return "Prime"
    else:
        return "Composite"
def fact(n):
    if n<=1:
        return 1
    return n*fact(n-1)
def fib(n):
    if n==0:
        return 0
    if n==1:
        return 1
    return fib(n-1)+fib(n-2)
def power(a, n):
    if n==0:
        return 1
    return a*power(a, n-1)
def reverseOut(n, input):
    if n==0:
        return
    cur_num=next(input)
    reverseOut(n-1, input)
    print(cur_num, end=' ')
def digitsOnly(s, i=0):
    if i==len(s):
        return "Yes"
    if not ('0'<=s[i]<='9'):
        return "No"
    return digitsOnly(s, i+1)
def charCount(s):
    if s=="":
        return 0
    return 1+charCount(s[1:])
def gcd(a, b):
    if b==0:
        return a
    return gcd(b, a%b)


if __name__ == "__main__":
    print("Task 1:")
    n1 = int(input("Number: "))
    print("Output:")
    printDigits(n1)

    print("\nTask 2:")
    n2 = int(input("Number of elements: "))
    arr2 = list(map(int, input(f"{n2} separated numbers: ").split()))
    print("Output:")
    sum = sumOfNums(arr2, n2)
    print(sum/n2)

    print("\nTask 3:")
    n3 = int(input("Number: "))
    print("Output:")
    print(checkPrime(n3))

    print("\nTask 4:")
    n4 = int(input("Number: "))
    print("Output:")
    print(fact(n4))

    print("\nTask 5:")
    n5 = int(input("Number: "))
    print("Output:")
    print(fib(n5))

    print("\nTask 6:")
    a6, n6 = map(int, input("Separated numbers: ").split())
    print("Output:")
    print(power(a6, n6))

    print("\nTask 7:")
    n7 = int(input("Number of elements: "))
    stream7 = iter(input(f"{n7} separated numebrs: ").split())
    print("Output:")
    reverseOut(n7, stream7)
    print()

    print("\nTask 8:")
    s8 = input("String: ")
    print("Output:")
    print(digitsOnly(s8))

    print("\nTask 9:")
    s9 = input("String: ")
    print("Output:")
    print(charCount(s9))

    print("\nTask 10:")
    a10, b10 = map(int, input("Separate numbers: ").split())
    print("Output:")
    print(gcd(a10, b10))