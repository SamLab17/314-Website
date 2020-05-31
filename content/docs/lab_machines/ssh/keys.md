---
title: SSH Keys
weight: 30
---

# SSH Keys

Setting up SSH Keys will allow us to connect to the lab machines
from off-campus without needing to use the VPN.

{{<hint>}}
SSH Keys are also a more secure form of authentication than just
passwords. So, if you ever set up a server which is accessible over
the internet (say, for a website) in the future, make sure to use
SSH Keys for authentication.
{{</hint>}}

## Prerequisites

* Make sure you can connect to a lab machine over SSH. This
  may require using the UT VPN if off-campus.

## Creating a Key Pair

First, we need to create a public/private key pair on our local
machine. The public key will be sent to the lab machine whereas the
private key should remain on your personal computer and never be
shared with anyone.

To create a key, run the following command in your terminal
or command prompt:

```bash
ssh-keygen -t rsa -b 4096
```

You will then be prompted to choose a location to store the
keys. It is recommended to use the default location, so just
press Enter without entering anything at the prompt.

You will then be prompted to enter a passphrase for this key.
The CS Department strongly recommends using a passphrase
alongside your keys, although it is not necessary. If you
choose to enter a passphrase, you will be prompted to enter it
anytime you log into the lab machines from off campus. If you
do not want to use a passphrase, press Enter without entering
one.

You will then be prompted to confirm your passphrase.

The output should look similar to below.

![SSH Key output](Images/SSHKey.png)

By default, the public key is stored in a file called `id_rsa.pub`.
On macOS/Linux this file is in the hidden directory called `.ssh` in
your home directory. On Windows it is located in
`C:\Users\<YOUR_USERNAME>\.ssh\` by default.

The private key is stored in the same directory but named `id_rsa`.
**This file should never be moved off of your computer or
shared with anyone.**

## Sending your key to the Lab Machine

Now, we need to send a copy of our public key to a lab machine
Once your key has been copied to one lab machine, it can be used to log in to _any other_ lab machine.
Follow the instructions for your operating system:

{{< tabs "key-transfer-tabs" >}}
{{< tab "macOS/Linux" >}}
Type the following command into your terminal. Be sure to replace
`CS_USER` with your CS username.
```
ssh-copy-id CS_USER@linux.cs.utexas.edu
```
If prompted "Are you sure you want to continue connecting?" type
`yes` and press Enter. You may need to enter your CS password.
{{< /tab >}}

{{< tab "Windows" >}} 
Type the following command into your command prompt. Be sure to
replace `CS_USER` with your CS username.
```
 type .ssh\id_rsa.pub | ssh CS_USER@linux.cs.utexas.edu "umask 0077 && mkdir -p ~/.ssh && cat >> ~/.ssh/authorized_keys"
```
If prompted "Are you sure you want to continue connecting?" type
`yes` and press Enter. You may need to enter your CS password.
{{< /tab >}}
{{< /tabs >}}

If everything was done successfully, you should now be able to log
into the lab machines from off-campus (without using the VPN)!

## Sources

This guide is based on UTCS's guide found [here](https://www.cs.utexas.edu/ssh-keys).
