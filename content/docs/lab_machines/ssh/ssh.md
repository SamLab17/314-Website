---
title: Connecting with SSH
weight: 20
---

# Connecting with SSH

We will connect to the Lab Machines using a protocol called
SSH (for **S**ecure **Sh**ell). SSH allows us to use a computer
remotely by sending commands to it and then receiving the resulting
output. For CS314, this means you will be able to run and test your assignments
on the lab machines.

## Prerequisites

* Make sure you know your CS account username and password
* Find an available CS machine to connect to with [this link](https://apps.cs.utexas.edu/unixlabstatus/)
* If off-campus, make sure you are connected to the [VPN](../vpn) or have set up your [SSH keys](../keys/)

## The SSH Command

Firstly, you'll need to open your terminal application of
choice. On macOS, the default pre-installed terminal is called 
`Terminal`. On Windows, the pre-installed `Command Prompt`
will work, too.

You should now have a blank prompt which looks something like
this:

![Empty Terminal](/~slaberge/ssh_images/Terminal0.png)

Now, we can issue the SSH command to open a connection with
one of the UTCS Lab machines:

```bash
ssh <CS Username>@<Machine Name>.cs.utexas.edu
```

My username is `slaberge` and I'll be connecting to the
`aggravation` machine. So the command I'll use looks like:

```bash
ssh slaberge@aggravation.cs.utexas.edu
```

![SSH Command](/~slaberge/ssh_images/Terminal1.png)

Press enter to issue the command. You will be asked to enter
your CS account password. If you do not remember it, use 
[this link](https://www.cs.utexas.edu/faq/68688). If you set
up SSH keys, you may be asked for your key's passphrase.

{{<hint>}}

If you are on Windows and the `ssh` command could not be found,
you may need to enable it. Try following 
[this tutorial](https://ittutorials.net/microsoft/windows-10/enable-ssh-windows-10-command-prompt/).

{{</hint>}}

![Linux Prompt](/~slaberge/ssh_images/Terminal2.png)

The prompt you see will not look exactly like the one above, but if you see the name 
of the machine you connected to in the prompt, then you successfully connected!

## Once Connected

**All commands that you run from now on are actually being executed on the lab machine, not your personal computer.**
The output of the commands is then sent back to your computer for you to see them.

To disconnect and end the SSH session, simply enter the following command:
```
logout
```
