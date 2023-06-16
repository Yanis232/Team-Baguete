#Pseudocodes
Here follows all of the pseudocodes for every algorithms used in our project.

## Function closestPointToPlayer
### Input
- set, an array of 2D points
- N, length of set
- line, an equation at form a*x (linear)
### Output
The closest point to player (playerPoint at x=0, y=0)

### Pseudocode
pointsOnLine <- findPointsOnLine from set and line equation

if N == 0 then
    return null (nothing)
else
    pointsOnLineSorted <- quicksort by absolute x
    return first element of pointsOnLineSorted

## Function findPointsOnLine
### Input
- set, an array of 2D points
- N, length of set
- line, an equation at form a*x (linear)
### Output
A set of points that are on the provided line equation

### Pseudocode
pointsOnLine <- empty array of 2D points

for every point in the set do
    if y coordinate of point = a from the line equation * x coordinate of point then
    Append point to pointsOnLine
return pointsOnLine

## Function quicksort
### Input
- A, an array of 2D points
- l, left part of the array (usually the first element of the array)
- r, right part of the array (usually the last element of the array)
### Output
Array A sorted by absolute x of their points in non-decreasing order

### Pseudocode
if l < r then
    s <- lomutoPartitioning of A with its left part and right part
    quicksort(A, l, s-1)
    quicksort(A, s+1, r)
return A

## Function lomutoPartitioning
### Input
- A, an array of 2D points
- l, left part of the array
- r, right part of the array
### Output
Index of pivot. A will also be modified during this function and be partially sorted

### Pseudocode
p <- A[l]
s <- l
for i=l+1 to r+1 do
    if absolute of the x coordinate of A[i] < absolute of the x coordinate of p then
        s <- s + 1
        swap(A, s, j)
swap(A, l, s)
return s

## Function swap
### Input
- A, an array of 2D points
- index1, index of the first element to swap
- index2, index of the second element to swap
### Output
A will be modified such as the two elements provided in input will have their indexes swapped

### Pseudocode
tmp <- A[index1]
A[index1] <- A[index2]
A[index2] <- A[index1]


