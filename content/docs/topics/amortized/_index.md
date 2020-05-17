---
title: "Amortized Analysis"
date: 2020-05-16T19:31:31-05:00
draft: false
mykatex: true
weight: 10
---


# Amortized Analysis

Sometimes, using best/worst/average case Big O to describe a function's runtime
complexity is misleading or confusing. For example, there are some functions
which have a short run time the vast majority of the time but occasionally take
longer. Should we describe that function's Big O based on the common runtime
complexity or the longer, rarer runtime? Or should both contribute to our
description of the function's runtime?

This is the motivation for _amortized analyis_, which essentially describes
the "average" runtime for the function after it is executed some number of times.
We can define amortized cost in the same way we think about averages: the sum
of the costs for each time we execute the function divided by the number of times
we run it. So, if we execute the function \\( n \\) times and 
define \\(c_i\\) to be the cost of running the function the
\\(i^{th} \\) time, then:

$$
\text{Amortized Cost} = \frac{\sum_{i=1}^{n}{c_i}}{n}
$$

We can think of the "cost" of a function as being proportional to its \\( O(N)\\).
Although, keep in mind, that this \\(N\\) might be changing with different calls
to the function. So, we could also write the definition as:

$$
\text{Amortized } O(N) = \frac{\sum_{i=1}^{n}{O(N_i)}}{n}
$$




{{<katex>}}
{{</katex>}}
