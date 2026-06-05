// ====================================================================================
//                           ARRAY PATTERNS COMPLETE REVISION
// ====================================================================================
//
// NOTE:
//
// Interview Flow:
//
// Step 1 -> Question me keyword identify karo
// Step 2 -> Pattern identify karo
// Step 3 -> Syntax yaad karo
// Step 4 -> Logic lagao
//
// ====================================================================================



// ====================================================================================
// 1. TRAVERSAL PATTERN
// ====================================================================================

/*

USE:

Jab array ke har element ko ek baar dekhna ho.

KEYWORDS:

- Largest Element
- Smallest Element
- Sum
- Average
- Count
- Search Element

SYNTAX:

for(int i=0;i<arr.length;i++){

    // process arr[i]

}

EXAMPLE:

int max = arr[0];

for(int i=1;i<arr.length;i++){

    if(arr[i] > max){
        max = arr[i];
    }
}

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Agar sirf dekhna hai ya calculate karna hai
to Traversal Pattern lagta hai.

*/


// ====================================================================================
// 2. TWO POINTER PATTERN
// ====================================================================================

/*

USE:

Jab do elements compare karne ho.

KEYWORDS:

- Pair Sum
- Reverse Array
- Sorted Array
- Palindrome
- Remove Duplicates

SYNTAX:

int left = 0;
int right = arr.length-1;

while(left < right){

    compare

    left++;
    right--;
}

REVERSE ARRAY:

while(left < right){

    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    left++;
    right--;
}

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Question me pair ya sorted array likha ho
to Two Pointer socho.

*/


// ====================================================================================
// 3. HASHMAP FREQUENCY COUNTING
// ====================================================================================

/*

USE:

Frequency Count nikalna.

KEYWORDS:

- Frequency
- Occurrence
- Repeating Element
- Most Frequent
- Count Elements

SYNTAX:

HashMap<Integer,Integer> map =
new HashMap<>();

for(int num : arr){

    map.put(
        num,
        map.getOrDefault(num,0)+1
    );
}

EXAMPLE:

1 2 2 3 3 3

OUTPUT:

1 -> 1
2 -> 2
3 -> 3

IMPORTANT:

getOrDefault(num,0)

Agar key hai
-> value return

Agar key nahi hai
-> 0 return

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(n)

INTERVIEW TRICK:

Frequency word dikhe
to HashMap lagao.

*/


// ====================================================================================
// 4. HASHSET PATTERN
// ====================================================================================

/*

USE:

Duplicate detect karna.

KEYWORDS:

- Duplicate
- Distinct
- Unique

SYNTAX:

HashSet<Integer> set =
new HashSet<>();

for(int num : arr){

    if(set.contains(num)){

        System.out.println(
        "Duplicate Found");
    }

    set.add(num);
}

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(n)

INTERVIEW TRICK:

Duplicate dikha
=> HashSet socho.

*/


// ====================================================================================
// 5. SLIDING WINDOW (FIXED SIZE)
// ====================================================================================

/*

USE:

Subarray of size K

KEYWORDS:

- Maximum Sum Subarray
- Window Size K
- Continuous Elements

SYNTAX:

int sum = 0;

for(int i=0;i<k;i++){

    sum += arr[i];
}

for(int i=k;i<arr.length;i++){

    sum =
    sum
    - arr[i-k]
    + arr[i];
}

GOLDEN FORMULA:

Current Window

=

Previous Window

- Old Element

+ New Element

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Subarray + Fixed K

=> Sliding Window

*/


// ====================================================================================
// 6. SLIDING WINDOW (VARIABLE SIZE)
// ====================================================================================

/*

USE:

Longest Subarray
Shortest Subarray

KEYWORDS:

- Longest
- Smallest
- At Most K
- At Least K

SYNTAX:

int left = 0;

for(int right=0;
right<arr.length;
right++){

    // expand window

    while(condition invalid){

        left++;
    }
}

INTERVIEW TRICK:

right => expand

left => shrink

*/


// ====================================================================================
// 7. PREFIX SUM
// ====================================================================================

/*

USE:

Range Sum Query

KEYWORDS:

- Sum from L to R
- Multiple Queries
- Range Sum

SYNTAX:

int[] prefix =
new int[arr.length];

prefix[0] = arr[0];

for(int i=1;i<arr.length;i++){

    prefix[i]
    =
    prefix[i-1]
    +
    arr[i];
}

RANGE SUM:

prefix[r]
-
prefix[l-1]

TIME COMPLEXITY:

Build = O(n)

Query = O(1)

INTERVIEW TRICK:

Multiple Sum Queries

=> Prefix Sum

*/


// ====================================================================================
// 8. KADANE ALGORITHM
// ====================================================================================

/*

USE:

Maximum Sum Subarray

KEYWORD:

Maximum Sum Subarray

SYNTAX:

int current = arr[0];
int max = arr[0];

for(int i=1;i<arr.length;i++){

    current =
    Math.max(
        arr[i],
        current + arr[i]
    );

    max =
    Math.max(max,current);
}

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Negative running sum
carry mat karo.

*/


// ====================================================================================
// 9. BINARY SEARCH
// ====================================================================================

/*

USE:

Sorted Array Search

KEYWORDS:

- Search
- Position
- Sorted Array

SYNTAX:

int low = 0;
int high = arr.length-1;

while(low <= high){

    int mid =
    low + (high-low)/2;

    if(arr[mid]==target){

        return mid;
    }

    else if(arr[mid] < target){

        low = mid+1;
    }

    else{

        high = mid-1;
    }
}

TIME COMPLEXITY:

O(log n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Sorted Array

=> Binary Search

*/


// ====================================================================================
// 10. XOR PATTERN
// ====================================================================================

/*

USE:

Single Number
Missing Number

KEYWORDS:

- One Unique
- Missing Number

RULES:

a ^ a = 0

a ^ 0 = a

SYNTAX:

int ans = 0;

for(int num : arr){

    ans ^= num;
}

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Sab duplicate cancel ho jate hain.

*/


// ====================================================================================
// 11. BOYER MOORE VOTING
// ====================================================================================

/*

USE:

Majority Element

CONDITION:

count > n/2

KEYWORD:

Majority Element

SYNTAX:

int count = 0;
int candidate = 0;

for(int num : arr){

    if(count==0){

        candidate = num;
    }

    if(num==candidate){

        count++;
    }

    else{

        count--;
    }
}

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Majority element
completely cancel nahi hota.

*/


// ====================================================================================
// 12. DUTCH NATIONAL FLAG
// ====================================================================================

/*

USE:

Sort 0 1 2

KEYWORD:

Only 0 1 2

SYNTAX:

int low = 0;
int mid = 0;
int high = arr.length-1;

while(mid <= high){

    if(arr[mid]==0){

        swap(low,mid);

        low++;
        mid++;
    }

    else if(arr[mid]==1){

        mid++;
    }

    else{

        swap(mid,high);

        high--;
    }
}

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

0 -> Left

1 -> Middle

2 -> Right

*/


// ====================================================================================
// 13. CYCLIC SORT
// ====================================================================================

/*

USE:

Numbers from 1 to N

KEYWORDS:

- Missing Number
- Duplicate Number
- First Missing Positive

SYNTAX:

int i = 0;

while(i < arr.length){

    int correct =
    arr[i]-1;

    if(arr[i] != arr[correct]){

        swap(arr,i,correct);
    }

    else{

        i++;
    }
}

TIME COMPLEXITY:

O(n)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Har element ko
uski correct position par rakho.

*/


// ====================================================================================
// 14. MATRIX TRAVERSAL
// ====================================================================================

/*

USE:

2D Arrays

KEYWORDS:

- Matrix
- Grid
- Row
- Column

SYNTAX:

for(int i=0;i<rows;i++){

    for(int j=0;j<cols;j++){

        process arr[i][j];
    }
}

TIME COMPLEXITY:

O(rows * cols)

SPACE COMPLEXITY:

O(1)

INTERVIEW TRICK:

Outer Loop -> Row

Inner Loop -> Column

*/


// ====================================================================================
// ARRAY PATTERN CHEAT SHEET
// ====================================================================================

/*

Question Keyword                 Pattern

Max / Min / Sum               -> Traversal

Frequency                     -> HashMap

Duplicate                     -> HashSet

Pair Sum                      -> Two Pointer

Reverse Array                 -> Two Pointer

Subarray Size K               -> Sliding Window

Range Sum                     -> Prefix Sum

Maximum Sum Subarray          -> Kadane

Sorted Search                 -> Binary Search

Unique Element                -> XOR

Missing Number               -> XOR / Cyclic Sort

Majority Element             -> Boyer Moore

Sort 0 1 2                   -> Dutch Flag

Matrix / Grid                -> Matrix Traversal

1 to N Numbers               -> Cyclic Sort

*/


// ====================================================================================
// GOLDEN INTERVIEW RULE
// ====================================================================================

/*

Question Padho

↓

Keyword Pakdo

↓

Pattern Identify Karo

↓

Syntax Yaad Karo

↓

Logic Lagao

↓

Code Likho

*/

public class EvenNumberofDigits{
   
    public int findNumbers(int[] nums) {

        int count = 0;

        for(int num : nums){

            int digits = 0;

            while(num > 0){
                digits++;
                num /= 10;
            }

            if(digits % 2 == 0){
                count++;
            }
        }

        return count;
    }
}

