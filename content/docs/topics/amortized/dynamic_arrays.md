---
title: Dynamic Arrays
weight: 1
---

# Amortized Analysis of Dynamic Arrays

The classic example of amortized analysis is appending to the end of a dynamic
array. In Java, this would be the `add()` method as part of the `ArrayList`
class. When we insert into a dynamic array there are two possible behaviors:

* There is still room in the array and we can simply add the value into the array.
* There is no more room in the array so we need to make a new, larger array, copy
over all the elements into the new array, and then finally add the new value.

The first situation is \\(O(1)\\) whereas the second is \\(O(N)\\) (where \\(N\\)
is the number of elements in the `ArrayList`<sup>1</sup>). The average, or amortized order
of appending to a dynamic array will depend on how often we have to resize. When
we resize, we have two options for large to make the new internal array:

* We could increase the size of the internal array by a constant \\(k\\)
* We could increase the size of the internal array by a constant **factor** \\(k\\)

Let's do an amortized analysis for both cases. We will add \\( N + 1 \\) elements
to the lists (it makes the math a bit nicer than adding \\( N \\)).
For both cases we assume \\(N \gg k \\).

## Increase by a Constant \\( k \\)

Suppose we start with an array of size \\( k \\). Once we try to add the \\(k + 1^{th}\\)
element to the list, we will need to resize. In this case we will add another \\( k \\)
spots to our internal array, creating a new array of size \\(2k\\) and copy our \\(k\\)
elements over into the new array. When we try to add the \\(2k + 1^{th}\\) element, 
we'll resize again and copy over \\(2k\\) elements.

Let's add up how many copies we'll need to make in the process of adding \\(N+1\\)
elements to the array. In the very worst case, we'll need to copy over a maximum
of \\(N\\) elements before we can add the \\(N + 1^{th}\\) element; let's assume
that worst case:

\\[
\text{Number of copies} = k + 2k + 3k + ... + N = k \left ( 1 + 2 + 3 + ... + \frac{N}{k} \right )
\\]

By factoring out the \\(k\\), we can evaluate the sum on the right hand side:

\\[
k \left( 1 + 2 + 3 + ... + \frac{N}{k} \right ) = k \left ( \frac{(\frac{N}{k})(\frac{N}{k} + 1)}{2} \right ) \approx O(N^2)
\\]

Thus, the process of copying over all of the elements while resizing takes
\\(O(N^2)\\) time. Dividing this by the \\(N + 1\\) insertions, the amortized cost
for each call to `add()` would be:

\\[
\frac{O(N^2)}{N+1} \approx O(N)
\\]

## Increase by a Constant Factor \\(k\\)

If we increase the size by a constant factor, we say that the length of the
internal array grows geometrically (as in a geometric series).
For simplicity, let's first consider the case where \\(k = 2 \\), then we can
look at the more general case (although both will have the same conclusion).

### Doubling the Size (\\(k = 2\\))

Suppose we started with an internal array of size 1 (really ridiculous, I know, but it makes
the math more apparent). Once we try to add the second element to the list, we'll need
to resize our array to a size of 2 and copy our one element over. When we try to add the third
element, our array will grow to a size of 4 and we'll copy over the 2 elements from
before. etc. Let's again look at how many elements we'll need to copy over during the
course of adding \\(N + 1\\) elements:

\\[
1 + 2 + 4 + ... + N = 2N - 1 \approx O(N)
\\]

{{<hint>}}
Had we started with an array of size \\( > 1 \\), we could just factor it out in
the sum above and get the same answer.
{{</hint>}}

Thus, the copying over of elements when we resize only takes \\( O(N)\\) time.
Dividing this by the \\(N+1\\) insertions, the amortized cost for each call to 
`add()` would be:

\\[
\frac{O(N)}{N+1} \approx O(1)
\\]

### Generalized to Any Factor \\( (k > 1)\\)

If we generalize to any factor \\(k\\), the logic from above stays about the same.
However, the sum will change:

\\[
k^0 + k^1 + k^2 + ... + N = \sum_{i=0}^{\log_{k}{N}}{k^i}
\\]

This is a geometric sum and the formula for a partial geometric sum is:

\\[
\sum_{i=0}^{\log_{k}{N}}{k^i} = \frac{k^{\log_k{N}+1}-1}{k-1} = 
\frac{k^{\log_k{N}}k + 1}{k-1} = \frac{Nk + 1}{k-1} \approx O(N)
\\]

Thus, resizing by any factor \\(k\\) also results in \\(O(N)\\) time for resizing.

## Conculsion

The Big O of adding to the end of a dynamic array, `ArrayList` in Java, depends
on the resize behavior. If we simply add a constant \\(k\\) to the size every time,
then adding to the end of the array is on average \\(O(N)\\). If we increase the size
by a factor (we multiply the size), adding to then end is on average \\(O(1)\\).

## Footnotes

<sup>1</sup> In Java, \\(N\\) would actually be the size of the new array container
because Java will initialize all elements in the array to `null`. However, in other
languages this initialization is not done and it will be simpler to use this
definition of \\(N\\) when doing the amortized analysis.

{{<katex>}}
{{</katex>}}
