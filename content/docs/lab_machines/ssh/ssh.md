---
title: Connecting with SSH
weight: 20
---

# Connecting with SSH

We will connect to the Lab Machines using a protocol called
SSH (for **S**ecure **Sh**ell). It will allow us to remotely
access a machine's command line.

## Prerequisites

* Make sure you know your CS account username and password
* Find an available CS machine to connect to with [this link](https://apps.cs.utexas.edu/unixlabstatus/)
* If off-campus, make sure you are connected to the VPN or have set up SSH keys

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

My username is `slaberge` and I am connecting to the
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

The prompt you see will most likely not look like the one above, but if you see the name of the machine you connected to in the prompt, then you successfully connected!

If you got an error, first make sure you entered the command correctly.
You can use the up arrow to fill in the prompt with the previous command in your history.