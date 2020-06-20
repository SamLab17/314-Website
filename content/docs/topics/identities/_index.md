---
title: Identities to Know
weight: 10
---

# Identities to Know

Here is a list of some important identities and properties to know for 
CS314 (especially for exams).

## Powers of 2 Approximations

$$
\begin{aligned}
\log_2{(1,000)} &\approx 10 & 2^{10} & \approx 1,000 \\\\ \log_2{(1,000,000)} &\approx 20 & 2^{20} & \approx 1,000,000
\end{aligned}
$$

## Logarithm Product & Quotient Rules

$$
\log{(ab)} = \log{a} + \log{b}
$$
$$
\log{\left(\frac{a}{b}\right)} = \log{a} - \log{b}
$$

## Sum of Consecutive Integers

$$
1 + 2 + 3 + 4 + ... + N = \frac{N(N+1)}{2}
$$

{{<details "Proof by Induction">}}

Let's prove \\( \sum_{i = 1}^{N}{i} = \frac{N(N+1)}{2} \\) by induction.

First, let's ensure the property holds for the base case \\( N = 1 \\):

$$
1 \stackrel{?}{=} \frac{1(1 + 1)}{2} = \frac{2}{2} = 1
$$

Now, let's assume that the property when \\(N = k\\) where \\(k \\) is some
integer \\( \geq 1 \\). This our inductive hypothesis:

$$
\sum_{i = 1}^{k}{i} = \frac{k(k+1)}{2}
$$

Now, let's see if the property also holds for \\(k+1\\). From the property,
we would expect to see that \\( \sum_{i=1}^{k+1}{i} = \frac{(k+1)(k+2)}{2} \\).

$$
1 + 2 + 3 + ... + k + (k+1) = \sum_{i = 1}^{k}{i} + (k+1) = \frac{k(k+1)}{2} + (k+1)
$$

$$
= \frac{k^2 + k}{2} + \frac{2(k+1)}{2} = \frac{k^2 + 3k + 2}{2} 
= \frac{(k+1)(k+2)}{2} \quad \square
$$

Which is the answer we would expect from the property.

{{</details>}}


{{<details "Geomteric Visualization">}}
{{< vimeo id="431085110" title="Visualization" >}}
{{</details>}}


## Sum of Powers of Two

$$
1 + 2 + 4 + 8 + ... + N = 2N - 1
$$

(Where \\( N \\) is a power of \\(2 \\))

{{<details "Proof by Induction">}}

To prove this property, I'm going to rewrite the sum slightly. Let
\\( n = \log_2{N} \\), i.e. \\( 2^n = N \\).

$$
1 + 2 + 4 + 8 + ... + 2^n = 2N - 1 = 2(2^n) - 1 = 2^{n+1} - 1
$$

Let's ensure that the property holds for the base case where \\( n = 0 \\):

$$
1 \stackrel{?}{=} 2^{0 + 1} - 1 = 1
$$

Now, we make our inductive hypothesis. Let's assume the property holds for
\\(n = k\\) where \\(k \\) is an integer \\( \geq 0\\). We take the following
to be true:

$$
1 + 2 + 4 + ... + 2^k = 2^{k+1} - 1
$$

Now, let's see if, given that the inductive hypothesis is true, the property holds
for \\(n = k+1\\). Based on the property, we would expect the sum up to 
\\(2^{k+1}\\) to equal \\(2^{k+2} - 1 \\).

$$
1 + 2 + 4 + ... + 2^k + 2^{k+1} = \left( 2^{k+1} - 1\right) + 2^{k+1}
$$

$$
= 2 \left(2^{k+1} \right) - 1 = 2^{k+2} - 1 \quad \square
$$

{{</details>}}

{{<katex>}}
{{</katex>}}
