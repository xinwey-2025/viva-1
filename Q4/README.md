### Problem description
During the Hari Merdeka, the Malaysian government decides to reward lucky citizens based
on their MyKad (IC) numbers. Your mission is to analyze the IC number and determine
whether a citizen qualifies as a “Lucky Winner.”
Your task:
1. Extract the birth year, month, and day from the IC (YYMMDD) and display in full format.
   • Assume: 00–25 → 2000–2025, 26–99 → 1926–1999.
2. Determine gender from the last digit:
   
   • Odd → Male

   • Even → Female
3. Classify the birth month as Long Month or Short Month:
   
   • Long Months (31 days): Jan, Mar, May, Jul, Aug, Oct, Dec

   • Short Months (28/30 days): Feb, Apr, Jun, Sep, Nov
4. Calculate the sum of all digits in the IC.
5. Determine “Lucky Winner” using these rules:

   • Male:

   o If sum of all IC digits is divisible by 5 AND born in a Short Month → Lucky
   
   o Otherwise → Not Lucky
   
   • Female:

   o If sum of all IC digits is divisible by 7 AND born in a Long Month → Lucky
   
   o Otherwise → Not Lucky

### Solution explanation
- Import Scanner for user input
- Prompt user to enter his/her ic number in the format YYMMDD-##-####
- A `while` loop is repeatedly until a valid ic is entered. If invalid ic, print invalid ic number message. If `ic.length() == 14`, the loop breaks.

**Determination of birth day**

Digits of ic are extracted using charAt() and the characters are converted into integer by subtracting '0'.
- y1(index 0), y2(index 1) -> year 
- m1(index 2), m2(index 3) -> month 
- d1(index 4), d2(index 5) -> date 

Then, the two digits are combined. To determine full year, for yy between 0-25, year = yy + 2000. Otherwise, year = yy + 1900.

**Determination of gender**

Using charAt(ic.length() - 1) to extract last digit of ic. A `if` statement is used.
- If (g % 2 == 0), this means the last digit is even -> female. Else, the user is male.

**Determination long month or short month**

A `switch(month)` is used.
- case 1,3,5,7,8,10,12 -> dayMonth = 31 (long month) 
- case 2 -> dayMonth = 28 (short month)
- default -> dayMonth = 30 (short month).

**Sum of digits**

A `for` loop is used to read the value of each digit in the ic. `(ch != '-')` used to ignore dashes. The characters are converted into integer and add to sum.

**Determine Lucky Winner**

A boolean `isWinner` is initialized as false. 
- Male: if(sum % 5 == 0) and is short month, `isWinner = true`
- Female: if(sum % 7 == 0) and is long month, `isWinner = true`

**Print:** 
- Birth date: day/month/year
- Gender: Male/Female
- Sum of Digits: sum
- Lucky Winner: Yes/No

### Sample input and output

Sample 1

![sample-input-output-1.png](sample%20cases/sample-input-output-1.png)

Sample 2

![sample-input-output-2.png](sample%20cases/sample-input-output-2.png)

### Source code
See [Q4.java](Q4.java)