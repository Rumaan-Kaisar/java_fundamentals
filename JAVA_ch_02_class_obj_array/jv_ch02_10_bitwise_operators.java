
// jv_ch02_10_bitwise_operators        2.17        166.5-176.8

/* -=-=-=-=-=-=-=-=-=-=-=      Bitwise Operators      -=-=-=-=-=-=-=-=-=-=-=

// ---- rev[12-Jun-2026] ----


2.17 Bitwise Operators (Recall C/C++ 7.7)
Bitwise operators are used to test, set, or shift the individual bits that make up a value. Bitwise operations are important to a wide variety of systems-level programming tasks in which status information from a device must be interrogated or constructed. 
    The bitwise operators can be used on values of type long, int, short, char, or byte. 
    Bitwise operations cannot be used on boolean, float, or double, or class types. 

Operator    &   |   ^   >>  >>> <<  ~

Result
    Bitwise AND Bitwise OR  Bitwise XOR Shift right Unsigned shift right    Shift left  One’s complement (unary NOT)
    Bitwise AND, OR, XOR, and NOT: The bitwise operators &, |, ^, and ~ perform the same operations as their Boolean logical equivalents. The difference is that the bitwise operators work on a bit-by-bit basis. 
    You can think of the bitwise AND as a way to turn bits off (and '0' remain off), bitwise OR as a way to turn bits on (and '1' remain on). 
    The following program uses & to turn lowercase letter into uppercase by resetting the 6th bit to 0, | to turn uppercase letter into lowercase by resetting the 6th bit to 1. 

[Why 6th bit? : By Unicode/ASCII character set is definition, the lowercase letters are the same as the uppercase ones except that the lowercase ones are greater in value by exactly 32. Therefore, to transform a lowercase letter to uppercase, just turn off the 6th bit, because in binary 32 is 100 000 "only 6th digit from right is 1/on". That is in binary " a=A+100,000" ]
Bitwise AND Bitwise OR
    char ch;
    for(int i=0; i < 10; i++) { ch = (char) ('a' + i);
                       System.out.print(ch);
    // This statement turns off the 6th bit.
                       ch = (char) ((int) ch & 65503); 
                       System.out.print(ch + " ");  }       char ch;
    for(int i=0; i < 10; i++) {ch = (char) ('A' + i);
                       System.out.print(ch);
    // This statement turns on the 6th bit.
                       ch = (char) ((int) ch | 32); 
                       System.out.print(ch + " ");  }
Output:     aA bB cC dD eE fF gG hH iI jJ   Output:     Aa Bb Cc Dd Ee Ff Gg Hh Ii Jj
65,503 is 1111 1111 1101 1111 in binary. Thus, the AND operation leaves all bits in ch unchanged except for the 6th one, which is set to 0. 32 is 0000 0000 0010 0000 in binary. Thus, the OR operation leaves all bits in ch unchanged except for the 6th one, which is set to 1.

    Other usage of bitwise AND:     The AND operator is also useful when you want to determine whether a bit is on or off. For example, following determines whether bit 4 in status is set:
if((status & 8)!= 0) System.out.println("bit 4 is on");
The number 8 is used because in binary it is "1000" has only the 4th bit on/set. Therefore, the if statement can succeed only when bit 4 of status is also on. 
        An interesting use of above concept is to show the bits of a byte value in binary format.
    int t;
    byte val;
    val = 123;
for(t=128; t>0; t = t/2){ if((val & t) != 0) System.out.print("1 ");
                  else System.out.print("0 "); }

    output:  0 1 1 1 1 0 1 1
         
[The for loop successively tests each bit in val, using the bitwise AND, to determine whether it is on or off. If the bit is on, the digit 1 is displayed; otherwise, 0 is displayed.]

    XOR will set a bit on iff the bits being compared are different (i.e. 1^1=1, 0^0=0, 1^1=0 ):
    XOR operator makes it a simple way to encode a message. When some value X is XORed with another value Y, and then that result is XORed with Y again, X is produced. That is, given the sequence R1 = X ^ Y; R2 = R1 ^ Y; i.e. X=(X^Y)^Y
    We can create simple CIPHER program in which some integer is the key that is used to both encode and decode a message by XORing the characters in that message. To encode, the XOR operation is applied the first time, yielding the cipher text. To decode, the XOR is applied a second time, yielding the plain text. 
[Of course, such a cipher has no practical value, being trivially easy to break. It does, however, provide an interesting way to demonstrate the XOR.]

String msg = "This is a test";   String encmsg = "";   String decmsg = "";
int key = 88;
// encode the message, create string with charAt()
for(int i=0; i < msg.length(); i++) encmsg = encmsg + (char)(msg.charAt(i) ^ key);

// decode the message, create string with charAt()
for(int i=0; i < msg.length(); i++) decmsg = decmsg + (char)(encmsg.charAt(i) ^ key);
    The unary one’s complement (NOT) operator reverses the state of all the bits of the operand. For example, if some integer called A has the bit pattern 1001 0110, then ~A produces a result with the bit pattern 0110 1001.
    The Shift Operators: Shift operators "<<" and ">>" are similar to C/C++ but the unsigned right shift ">>>" is new in Java.

operators   Meaning General form    Descriptions
<<  Left shift  value << num-bits   value is the value being shifted by the number of bit positions specified by num-bits.
Each left shift causes all bits within the specified value to be shifted left one position and a 0 bit to be brought in on the right. Each right shift shifts all bits to the right one position and preserves the sign bit. 
>>  Right shift value >> num-bits   
>>> Unsigned right shift    value >>> num-bits  
    Right shifting ">>" –ve/negative value: Negative numbers are usually represented by setting the high-order bit of an integer value to 1, it is MSB representation for example "8" in binary is "0000 1000" and "-8" in binary is "1000 1000"(Here –ve value is represented as MSB : most significant bit representation, where leftmost bit is reserved for sign, 0 for +ve and 1 for –ve). Java do not use the MSB Representation,  here two’s complement is used.
    Java uses two’s complement to represent negative values. In this approach negative values are stored by first reversing the bits in the value (one's compliment) and then adding 1. Thus, the byte value for –1 in binary is 1111 1111. Right shifting this value will always produce –1! In two's complement, if we want to represent "-8" for 8 bit field (2^8 )_2-8_2=1 0000 0000-1000=1111 1000 for detail see 2.19 Signed binary numbers), and this is the approach used by Java.  If the value being shifted is negative, each right shift brings in a 1 on the left (i.e. -8>>1 brings "1111 1100").
    Note: In C/C++ also two's complement is used to represent –ve binary value. (Also in shifting operation)
    If the value is positive, each right shift brings in a 0 on the left.
    Unsigned right shift: To remove sign bit when shifting right, you can use an unsigned right shift ( >>> ), which always brings in a 0 on the left. For this reason, the >>> is also called the zero-fill right shift. (Eg:<<< is used when shifting bit patterns, such as status codes, that do not represent integers.)
    Lose of bits due to shift: For all of the shifts, the bits shifted out are lost. Thus, a shift is not a rotate, and there is no way to retrieve a bit that has been shifted out.
    Example 1: Here, an integer is given an initial value of 1, which means that its low-order bit is set. Then, a series of eight shifts are performed on the integer. After each shift, the lower 8 bits of the value are shown. The process is then repeated, except that a 1 is put in the 8th bit position, and right shifts are performed.
class ShiftDemo { public static void main(String args[]) {  int val = 1;
for(int i = 0; i < 8; i++) {    for(int t=128; t > 0; t = t/2) {          if((val & t) != 0) System.out.print("1 ");
          else System.out.print("0 ");  }   System.out.println();
val = val << 1; }  System.out.println();    // left shift
val = 128;
for(int i = 0; i < 8; i++) {    for(int t=128; t > 0; t = t/2) {           if((val & t) != 0) System.out.print("1 ");
          else System.out.print("0 "); }System.out.println();
val = val >> 1;}    }}          // right shift
    Be careful when shifting byte and short values because Java will automatically promote these types to int when evaluating an expression. For example, if you right shift a byte value, it will first be promoted to int and then shifted. The result of the shift will also be of type int. Often this conversion is of no consequence. 
    If you shift a negative byte or short value, it will be sign-extended when it is promoted to int. Thus, the high-order bits of the resulting integer value will be filled with ones. This is fine when performing a normal right shift. But when you perform a zero-fill right shift, there are 24 ones to be shifted before the byte value begins to see zeros.
    Bitwise Shorthand Assignments: All of the binary bitwise operators have a shorthand form that combines an assignment with the bitwise operation. For example, the following two statements both assign to x the outcome of an XOR of x with the value 127.
x = x ^ 127;            x ^= 127;
The bitwise shift operators can be used to perform very fast multiplication or division by "2":
    A shift left doubles a value.       A shift right halves it.






--------  Qwen  --------

Here is the text organized into a clear, pointwise structure with properly formatted code snippets and corrected minor typographical errors (such as the XOR truth table) for better readability.

# 2.17 Bitwise Operators (Recall C/C++ 7.7)

## 1. Overview and Allowed Data Types
*   **Purpose:** Bitwise operators are used to test, set, or shift the individual bits that make up a value.
*   **Use Cases:** Crucial for systems-level programming tasks where status information from a device must be interrogated or constructed.
*   **Allowed Types:** Can be used on `long`, `int`, `short`, `char`, or `byte`.
*   **Disallowed Types:** Cannot be used on `boolean`, `float`, `double`, or class types.

## 2. List of Bitwise Operators
| Operator | Result / Name |
| :--- | :--- |
| `&` | Bitwise AND |
| `\|` | Bitwise OR |
| `^` | Bitwise XOR (Exclusive OR) |
| `~` | One’s complement (Unary NOT) |
| `<<` | Shift left |
| `>>` | Shift right |
| `>>>` | Unsigned shift right (Zero-fill right shift) |

---

## 3. Bitwise Logical Operators (`&`, `|`, `^`, `~`)

### Basic Concepts
*   Unlike Boolean logical operators, bitwise operators work on a **bit-by-bit basis**.
*   **Bitwise AND (`&`):** Acts as a way to turn bits *off* (0 remains 0).
*   **Bitwise OR (`|`):** Acts as a way to turn bits *on* (1 remains 1).
*   **Bitwise NOT (`~`):** The unary one’s complement operator reverses the state of all bits in the operand (e.g., `1001 0110` becomes `0110 1001`).

### Practical Example: Case Conversion (Using AND & OR)
*   **Why the 6th bit?** In the ASCII/Unicode character set, a lowercase letter is exactly 32 greater in value than its uppercase equivalent. In binary, 32 is `100000` (only the 6th digit from the right is 1). Therefore, `a = A + 100000`.
*   **Lowercase to Uppercase:** Turn *off* the 6th bit using AND with `65503` (binary `1111 1111 1101 1111`).
*   **Uppercase to Lowercase:** Turn *on* the 6th bit using OR with `32` (binary `0000 0000 0010 0000`).

```java
// Lowercase to Uppercase
char ch;
for(int i = 0; i < 10; i++) { 
    ch = (char) ('a' + i);
    System.out.print(ch);
    // Turns off the 6th bit
    ch = (char) ((int) ch & 65503); 
    System.out.print(ch + " ");  
}
// Output: aA bB cC dD eE fF gG hH iI jJ 

// Uppercase to Lowercase
for(int i = 0; i < 10; i++) {
    ch = (char) ('A' + i);
    System.out.print(ch);
    // Turns on the 6th bit
    ch = (char) ((int) ch | 32); 
    System.out.print(ch + " ");  
}
// Output: Aa Bb Cc Dd Ee Ff Gg Hh Ii Jj 
```

### Other Uses of Bitwise AND
*   **Checking if a specific bit is on:** Use AND with a mask. For example, to check if bit 4 is set in a `status` variable, use `if((status & 8) != 0)`. (8 is used because its binary is `1000`, meaning only the 4th bit is on).
*   **Displaying a byte in binary format:** Successively test each bit using a loop and bitwise AND.

```java
int t;
byte val = 123;
for(t = 128; t > 0; t = t / 2) { 
    if((val & t) != 0) System.out.print("1 ");
    else System.out.print("0 "); 
}
// Output: 0 1 1 1 1 0 1 1
```

### Practical Example: Simple Cipher (Using XOR)
*   **XOR Logic:** Sets a bit on *if and only if* the bits being compared are different (i.e., `1^0=1`, `0^1=1`, `1^1=0`, `0^0=0`).
*   **Reversibility:** If `X` is XORed with `Y`, and the result is XORed with `Y` again, the original `X` is produced: `(X ^ Y) ^ Y = X`.
*   **Cipher Application:** Apply XOR with an integer key to encode (yielding ciphertext). Apply XOR with the same key again to decode (yielding plaintext). *(Note: This is a trivial cipher with no practical security value, but demonstrates the concept).*

```java
String msg = "This is a test";   
String encmsg = "";   
String decmsg = "";
int key = 88;

// Encode the message
for(int i = 0; i < msg.length(); i++) {
    encmsg = encmsg + (char)(msg.charAt(i) ^ key);
}

// Decode the message
for(int i = 0; i < msg.length(); i++) {
    decmsg = decmsg + (char)(encmsg.charAt(i) ^ key);
}
```

---

## 4. Shift Operators (`<<`, `>>`, `>>>`)

### Definitions
*   **Left Shift (`<<`):** Shifts all bits left by `num-bits`. A `0` is brought in on the right. *Effectively doubles the value.*
*   **Right Shift (`>>`):** Shifts all bits right by `num-bits`. Preserves the sign bit (brings in a `1` on the left if negative, `0` if positive). *Effectively halves the value.*
*   **Unsigned Right Shift (`>>>`):** Always brings in a `0` on the left (zero-fill right shift). Used for shifting bit patterns (like status codes) that do not represent signed integers.

### Negative Numbers and Two's Complement
*   Java (like C/C++) uses **Two's Complement** to represent negative values, *not* simple MSB (Most Significant Bit) representation.
*   **Two's Complement Rule:** Reverse the bits (one's complement) and add 1. 
    *   Example: Byte value `-1` is `1111 1111`. Right shifting `-1` will always produce `-1`.
    *   Example: `-8` in an 8-bit field is `1111 1000`. Right shifting it (`-8 >> 1`) brings in a 1 on the left, resulting in `1111 1100`.

### Important Caveats for Shifting
*   **Lost Bits:** Bits shifted out are permanently lost. A shift is *not* a rotate; you cannot retrieve shifted-out bits.
*   **Type Promotion:** Java automatically promotes `byte` and `short` to `int` before evaluating expressions. The result of the shift will also be an `int`.
*   **Sign-Extension Issue:** If you shift a negative `byte` or `short`, it is sign-extended to `int` (filled with 24 ones). This is fine for `>>`, but problematic for `>>>` because you must shift through those 24 ones before the actual byte value begins to see zeros.

### Shift Example Code
```java
class ShiftDemo { 
    public static void main(String args[]) {  
        int val = 1;
        
        // Left shift demo
        for(int i = 0; i < 8; i++) {    
            for(int t = 128; t > 0; t = t / 2) {          
                if((val & t) != 0) System.out.print("1 ");
                else System.out.print("0 ");  
            }   
            System.out.println();
            val = val << 1; 
        }  
        System.out.println();    
        
        // Right shift demo
        val = 128;
        for(int i = 0; i < 8; i++) {    
            for(int t = 128; t > 0; t = t / 2) {           
                if((val & t) != 0) System.out.print("1 ");
                else System.out.print("0 "); 
            }
            System.out.println();
            val = val >> 1;
        }    
    }
}
```

---

## 5. Shorthand Assignments and Mathematical Uses

*   **Bitwise Shorthand:** All binary bitwise operators have a shorthand form combining assignment and operation.
    *   *Example:* `x = x ^ 127;` is identical to `x ^= 127;`
*   **Fast Math:** Bitwise shift operators can perform very fast multiplication or division by 2.
    *   A **left shift** (`<<`) doubles a value.
    *   A **right shift** (`>>`) halves a value.








--------  GPT  --------


# 2.17 Bitwise Operators (Recall C/C++ 7.7)

## 1. Introduction

Bitwise operators are used to **test, set, clear, or shift individual bits** within a value.

### Applications

* Systems-level programming
* Device status checking
* Hardware control
* Data encoding/decoding
* Performance optimization

### Supported Data Types

Bitwise operators can be used with:

* `long`
* `int`
* `short`
* `char`
* `byte`

### Not Supported

Bitwise operations **cannot** be used with:

* `boolean`
* `float`
* `double`
* Class/Object types

---

## 2. Bitwise Operators

| Operator | Meaning                |
| -------- | ---------------------- |
| `&`      | Bitwise AND            |
| `\|`     | Bitwise OR             |
| `^`      | Bitwise XOR            |
| `~`      | One's Complement (NOT) |
| `<<`     | Left Shift             |
| `>>`     | Right Shift            |
| `>>>`    | Unsigned Right Shift   |

---

# 3. Bitwise AND (`&`)

### Purpose

Used to **turn bits OFF** or test whether specific bits are set.

### Rule

| A | B | A & B |
| - | - | ----- |
| 0 | 0 | 0     |
| 0 | 1 | 0     |
| 1 | 0 | 0     |
| 1 | 1 | 1     |

### Example: Convert Lowercase to Uppercase

```java
char ch;

for(int i=0; i<10; i++) {
    ch = (char)('a' + i);
    System.out.print(ch);

    ch = (char)((int)ch & 65503);
    System.out.print(ch + " ");
}
```

**Output**

```text
aA bB cC dD eE fF gG hH iI jJ
```

### Why does it work?

ASCII/Unicode values:

```text
A = 65
a = 97

Difference = 32
```

Binary of 32:

```text
0010 0000
```

Only the **6th bit** is ON.

To convert lowercase to uppercase:

* Turn OFF the 6th bit.
* AND operation achieves this.

### Mask Used

```text
65503 = 1111 1111 1101 1111
```

This clears only the 6th bit.

---

## 4. Bitwise OR (`|`)

### Purpose

Used to **turn bits ON**.

### Rule

| A | B | A | B |
| - | - | ----- |
| 0 | 0 | 0     |
| 0 | 1 | 1     |
| 1 | 0 | 1     |
| 1 | 1 | 1     |

### Example: Convert Uppercase to Lowercase

```java
char ch;

for(int i=0; i<10; i++) {
    ch = (char)('A' + i);
    System.out.print(ch);

    ch = (char)((int)ch | 32);
    System.out.print(ch + " ");
}
```

**Output**

```text
Aa Bb Cc Dd Ee Ff Gg Hh Ii Jj
```

### Why does it work?

```text
32 = 0000 0000 0010 0000
```

OR operation turns the 6th bit ON, converting uppercase letters to lowercase.

---

## 5. Using AND to Test a Bit

### Example

```java
if((status & 8) != 0)
    System.out.println("Bit 4 is ON");
```

### Explanation

```text
8 = 1000
```

Only the 4th bit is ON.

The condition succeeds only if bit 4 in `status` is also ON.

---

## 6. Displaying Binary Representation of a Byte

### Program

```java
int t;
byte val = 123;

for(t = 128; t > 0; t = t/2) {
    if((val & t) != 0)
        System.out.print("1 ");
    else
        System.out.print("0 ");
}
```

### Output

```text
0 1 1 1 1 0 1 1
```

### Explanation

The loop checks each bit from left to right using the AND operator and prints:

* `1` if the bit is ON
* `0` if the bit is OFF

---

# 7. Bitwise XOR (`^`)

### Purpose

Produces `1` only when the compared bits are different.

### Truth Table

| A | B | A ^ B |
| - | - | ----- |
| 0 | 0 | 0     |
| 0 | 1 | 1     |
| 1 | 0 | 1     |
| 1 | 1 | 0     |

### Important Property

```text
(X ^ Y) ^ Y = X
```

This makes XOR useful for simple encoding and decoding.

---

## 8. XOR Cipher Example

```java
String msg = "This is a test";
String encmsg = "";
String decmsg = "";

int key = 88;

// Encode
for(int i=0; i<msg.length(); i++)
    encmsg += (char)(msg.charAt(i) ^ key);

// Decode
for(int i=0; i<msg.length(); i++)
    decmsg += (char)(encmsg.charAt(i) ^ key);
```

### Working

```text
Original Message
      ↓ XOR key
Encrypted Message
      ↓ XOR same key
Original Message
```

> Note: This cipher is very weak and used only for demonstration purposes.

---

# 9. One's Complement (`~`)

### Purpose

Reverses every bit.

### Example

```text
A      = 1001 0110
~A     = 0110 1001
```

Every `1` becomes `0`, and every `0` becomes `1`.

---

# 10. Shift Operators

## Overview

| Operator | Meaning              | General Form |
| -------- | -------------------- | ------------ |
| `<<`     | Left Shift           | value << n   |
| `>>`     | Right Shift          | value >> n   |
| `>>>`    | Unsigned Right Shift | value >>> n  |

---

## 11. Left Shift (`<<`)

### Syntax

```java
value << numBits
```

### Effect

* Shifts all bits left.
* Inserts `0` on the right.

### Example

```text
0000 0001 << 1
=
0000 0010
```

### Shortcut

```text
Left shift by 1 = Multiply by 2
```

---

## 12. Right Shift (`>>`)

### Syntax

```java
value >> numBits
```

### Effect

* Shifts bits right.
* Preserves sign bit.

### Example

```text
0000 1000 >> 1
=
0000 0100
```

### Shortcut

```text
Right shift by 1 = Divide by 2
```

---

# 13. Negative Numbers and Two's Complement

### Java Representation

Java uses **Two's Complement** for negative numbers.

### Steps

1. Take positive binary number.
2. Reverse all bits (One's Complement).
3. Add 1.

### Example: -8 (8-bit)

```text
8      = 0000 1000

Invert = 1111 0111

Add 1  = 1111 1000
```

Thus,

```text
-8 = 1111 1000
```

### Right Shift of Negative Numbers

```text
-8 >> 1

1111 1000
→
1111 1100
```

A `1` enters from the left because the sign is preserved.

---

## 14. Unsigned Right Shift (`>>>`)

### Purpose

Removes sign extension.

### Effect

* Always inserts `0` from the left.
* Also called **Zero-Fill Right Shift**.

### Example

```java
value >>> n
```

Useful when shifting:

* Bit patterns
* Status codes
* Raw binary data

instead of signed integers.

---

## 15. Loss of Bits During Shifting

Bits shifted out of either side are permanently lost.

```text
1000 0001 << 1

→ 0000 0010
```

The leftmost `1` is discarded.

### Note

A shift is **not** a rotate operation.

---

## 16. Shift Demonstration Program

```java
class ShiftDemo {
    public static void main(String args[]) {

        int val = 1;

        // Left Shift
        for(int i=0; i<8; i++) {
            for(int t=128; t>0; t=t/2) {
                if((val & t) != 0)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
            val = val << 1;
        }

        System.out.println();

        val = 128;

        // Right Shift
        for(int i=0; i<8; i++) {
            for(int t=128; t>0; t=t/2) {
                if((val & t) != 0)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
            val = val >> 1;
        }
    }
}
```

---

# 17. Byte and Short Shifting Warning

### Automatic Promotion

Before shifting:

```java
byte
short
```

are automatically promoted to:

```java
int
```

### Consequences

* Result type becomes `int`.
* Negative values are sign-extended.

Example:

```text
byte b = -1

11111111
```

After promotion:

```text
11111111 11111111 11111111 11111111
```

Extra `1`s are added at the left.

This affects zero-fill right shifts (`>>>`).

---

# 18. Bitwise Shorthand Assignment Operators

| Standard Form | Shorthand  |
| ------------- | ---------- |
| `x = x & y`   | `x &= y`   |
| `x = x \| y`  | `x \|= y`  |
| `x = x ^ y`   | `x ^= y`   |
| `x = x << n`  | `x <<= n`  |
| `x = x >> n`  | `x >>= n`  |
| `x = x >>> n` | `x >>>= n` |

### Example

```java
x = x ^ 127;
```

Equivalent to:

```java
x ^= 127;
```

---

# 19. Quick Summary

### AND (`&`)

* Turn bits OFF
* Test bits

### OR (`|`)

* Turn bits ON

### XOR (`^`)

* Toggle bits
* Encoding/Decoding

### NOT (`~`)

* Reverse all bits

### Left Shift (`<<`)

* Shift left
* Multiply by 2

### Right Shift (`>>`)

* Shift right
* Divide by 2
* Preserves sign

### Unsigned Right Shift (`>>>`)

* Shift right
* Fills with zeros
* Ignores sign bit



 */
