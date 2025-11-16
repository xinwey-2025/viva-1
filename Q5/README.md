### Problem Description
The king of Cipheria want to keep the messages safe and won't be intercepted and read by the spies from the neighbouring kingdom of Crytonia.
Thus, the agents need to create a special encoding system based on binary inversion :
1. Every letter in the original message is first converted into its ASCII decimal value.
2. The decimal is then converted into an 8-bit binary.
3. To confuse enemy spies, the binary is inverted — all 0s become 1s and all 1s become
   0s.
4. The inverted binary is converted back into decimal, forming the encoded message.

So even if a spy captures the decimal numbers, without knowing the fixed 8-bit length and inversion rule , it couldn't decode the original message.

### Solution Explanation
The program starts by collecting the input message from the kingdom such as "hello world". The input call is then put into a for loop, the loop break only if the count number are larger than the messages length;
If the count are smaller than messages length, the loop continues to find the position of the character inside the message. 

The original message is first converted into its ASCII decimal value.
The original messages are put into a for loop that goes through every character in the string message.

`i = 0 `→ start from the first character

`i < message.length()` → stop when you reach the end

`i++` → move to the next character each time

So the loop visits character 0, then 1, then 2… until the last one.
`char ch = message.charAt(i)`is used to find the character at position i in the string then store that character inside ch.
After` int ascii = ch` turn the origin messages into ASCII decimal value.

The decimal is then converted into an 8-bit binary.
The fixed 8-bit length and inversion rule are as follows:

- For the 8-bit binary
  - A String
  - Use `Integer.toBinaryString()` to convert the ASCII decimal value to binary
  - `%8s` used to add 1 space on the left 
  - `.replace() `used to replace the space with "0".This is to ensure that every binary conversion uses 8-bits to prevent errors in the decoding process.

After the messages are converted into binary, the binary is inverted to confuse the enemy spies  which all 0s become 1sand all 1s become 0s. 
To flip the binary, for loop is put in with `toCharArray` to convert the binary string into a character array like{'0','1','0','0','1','0','0','0'}
So that the for loop can go one by one.Then,if else is used to go through the inversion rule.

Next,the inverted binary is converted back into decimal. `Integer.parseInt(flipped, 2) `is used to convert binary to decimal, the `(flipped,2) `means (binary number,base 2).

Lastly,the encoded message is printed out.

### Sample input and output

Sample 1

![Sample input and output 1](Sample-cases/Sample%201-input%20&%20output.png)

Sample 2

![Sample input and output 2](Sample-cases/Sample%202-input%20&%20output.png)

### Source code
See [Q5.java](Q5.java)





