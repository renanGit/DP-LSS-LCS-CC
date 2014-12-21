DP-LSS-LCS-CC
=============

Dynamic Programming with Longest Square Submatrix, Longest Common Subsequence, and Coin Change.


Longest Square Matrix:

Given a binary matrix, find out the maximum size square sub-matrix with all 1s or 0s.

For example, consider the below binary matrix.

   0  1  1  0  1
   
   1  1  0  1  0
   
   0  1  1  1  0
   
   1  1  1  1  0
   
   1  1  1  1  1
   
   0  0  0  0  0
   
The maximum square sub-matrix with all set bits is

    1  1  1
    1  1  1
    1  1  1

	
Longest Common Subsequence:

Given two sequences, find the length of longest subsequence present in both of them. 
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.


Coin Change

Given a currency set find the optimal coin change for X cents.

Ex. the currency set is 1, 5, 10, 18, and 25. Find the optimal coin change for 58 cents.

Ammount of change for 58 cents: 4
Change in return: 25, 18, 10, 5