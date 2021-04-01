# [Median Sort](https://codingcompetitions.withgoogle.com/codejam/round/000000000043580a/00000000006d1284#problem)
## Problem
You want to sort **N** distinct items, *x<sub>1</sub>*, *x<sub>2</sub>*, ..., *x<sub>N</sub>*. Unfortunately, you do not have a way of comparing two of these items. You only have a way to, given three of them, find out which one is the median, that is, which one is neither the minimum nor the maximum among the three.

For example, suppose **N** = 5 and you know that:
- *x<sub>1</sub>* is the median of {*x<sub>1</sub>*, *x<sub>2</sub>*, *x<sub>3</sub>*}
- *x<sub>2</sub>* is the median of {*x<sub>2</sub>*, *x<sub>3</sub>*, *x<sub>4</sub>*}
- *x<sub>3</sub>* is the median of {*x<sub>3</sub>*, *x<sub>4</sub>*, *x<sub>5</sub>*}

Then, it is guaranteed that the sorted order of the elements is either *x<sub>4</sub>*, *x<sub>2</sub>*, *x<sub>1</sub>*, *x<sub>3</sub>*, *x<sub>5</sub>* or its reverse *x<sub>5</sub>*, *x<sub>3</sub>*, *x<sub>1</sub>*, *x<sub>2</sub>*, *x<sub>4</sub>*. Notice that by knowing only medians, it is impossible to distinguish the order of any list from its reverse, since the median question has the same result for any three elements in both cases.

Your program will have to find the order of **T** lists of **N** elements using at most **Q** median questions in total (or **Q** / **T** queries per list on average). In each case, finding either the right order or its reverse is considered correct. The order for each case is generated uniformly at random from all possible orders, and independently of any other information.

## Input and output
This is an interactive problem.

Initially, the judge will send you a single line containing three integers **T**, **N**, and **Q**: the number of test cases, the number of elements to sort within each test case, and the total number of questions you are allowed across all test cases, respectively. Then, you must process **T** test cases. Each test case consists of a series of question exchanges plus an additional exchange to provide the answer.

For a question exchange, your program must print a single line containing three distinct integers *i*, *j*, *k* all between 1 and **N**, inclusive, which corresponds to asking the judge *"which element is the median of the set {x<sub>i</sub>, x<sub>j</sub>, x<sub>k</sub>}?"* The judge will respond with a single line containing a single integer **L**, meaning that the median of that set is *x<sub>L</sub>* (**L** is always equal to one of *i*, *j*, or *k*). If you try to perform a (**Q** + 1)-th question exchange, the judge will simply output -1.

Once you are ready to state the result, print a line containing **N** integers representing the indices of the elements in sorted or reverse sorted order. The judge will respond with a single integer `1` if your answer is correct or `-1` if it is not. After receiving the judge's answer for the **T**-th case, your program must finish in time in order to not receive a Time Limit Exceeded error. In addition, if you print additional information after receiving the result for the **T**-th case, you will get a Wrong Answer judgment.

If the judge receives an invalidly formatted line or invalid values from your program at any moment, the judge will print a single number `-1`. After the judge prints `-1` for any of the reasons explained above, it will not print any further output. If your program continues to wait for the judge after receiving a `-1`, your program will time out, resulting in a Time Limit Exceeded error. Notice that it is your responsibility to have your program exit in time to receive a Wrong Answer judgment instead of a Time Limit Exceeded error. As usual, if the memory limit is exceeded, or your program gets a runtime error, you will receive the appropriate judgment.

## Limits
Time limit: 40 seconds.  
Memory limit: 1 GB.  
**T** = 100.

### Test Set 1
**N** = 10.  
**Q** = 300 ⋅ **T**.

### Test Set 2
**N** = 50.  
**Q** = 300 ⋅ **T**.

### Test Set 3
**N** = 50.  
**Q** = 170 ⋅ **T**.

## Sample interaction
<pre>
Judge:      2 5 600     [Judge provides T, N, Q]

    Case 1
Solution:   1 2 3       [Solution asks for the median of {x1,x2,x3}]
Judge:      2           [Judge responds that the median is x2]
Solution:   4 2 3       [Solution asks for the median of {x4,x2,x3}]
Judge:      3           [Judge responds that the median is x3]
Solution:   5 4 3       [Solution asks for the median of {x5,x4,x3}]
Judge:      4           [Judge responds that the median is x4]
Solution:   5 4 3 2 1   [Solution outputs the sorted list]
Judge:      1           [Judge confirms that the answer is correct]

    Case 2
Solution:   1 2 3       [Solution asks for the median of {x1,x2,x3}]
Judge:      3           [Judge responds that the median is x3]
Solution:   2 3 4       [Solution asks for the median of {x2,x3,x4}]
Judge:      4           [Judge responds that the median is x4]
Solution:   3 4 5       [Solution asks for the median of {x3,x4,x5}]
Judge:      5           [Judge responds that the median is x5]
Solution:   1 3 5 4 2   [Solution outputs the sorted list]
Judge:      1           [Judge confirms that the answer is correct]
</pre>