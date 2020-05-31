---
title: Running GUI Programs
---

# Running Graphical Programs Over SSH

Although SSH connections are done through a command line interface,
it is actually possible to run graphical applications over
SSH using X-forwarding.

This trick can be useful for CS314 because some of our assignments
use a GUI window. If you want to test one of these graphical
programs on the lab machines, you'll need to use X-forwarding.
If you do not have X-forwarding enabled, you'll get an
exception which looks similar to this:

```
Exception in thread "main" java.awt.HeadlessException:
No X11 DISPLAY variable was set, but this program performed an operation which requires it.
	at java.desktop/java.awt.GraphicsEnvironment.checkHeadless(GraphicsEnvironment.java:208)
	at java.desktop/java.awt.Window.<init>(Window.java:548)
	at java.desktop/java.awt.Frame.<init>(Frame.java:423)
	at java.desktop/javax.swing.JFrame.<init>(JFrame.java:224)
	at DrawingPanel.<init>(DrawingPanel.java:87)
	at Recursive.drawCarpet(Recursive.java:188)
	at RecursiveTester.doCarpetTest(RecursiveTester.java:33)
	at RecursiveTester.main(RecursiveTester.java:27)
```

{{<tabs "xforwarding">}}

{{<tab "Windows">}}
## One-Time Setup
Windows does not have a built-in X-Windows server so we'll need to 
install one. Xming is a free and popular choice.
You can download the installer [here](https://sourceforge.net/projects/xming/).

Open a command prompt and type the following commands:
```
set DISPLAY=localhost:0
mkdir \dev
echo x > \dev\tty
```

## Every-Time Setup

Make sure that Xming is running (it will be in the system tray when running).
Then, when connecting to the lab machine, you'll need to add an extra argument
to the `ssh` command:

```
ssh -Y CS_USER@CS_MACHINE.cs.utexas.edu
```

{{</tab>}}

{{<tab "macOS">}}

## One-Time Setup

macOS does not have a built-in X-Windows server so we'll need to 
install one. XQuartz is free, open source and a popular option for macOS.
You can download the installer [here](https://www.xquartz.org).

## Every-Time Setup

Once that is complete, you need to add an extra argument to the
`ssh` command you use to connect to the lab machine:

```
ssh -X CS_USER@CS_MACHINE.cs.utexas.edu
```

{{</tab>}}

{{<tab "Linux">}}

## One-Time Setup
None! Linux is by far the easiest platform for using X-Forwarding
because it has XWindows built in!

## Every-Time Setup
All you need to do is add an extra argument to the `ssh` command
you use to connect to the lab machine:

```
ssh -X CS_USER@CS_MACHINE.cs.utexas.edu
```

{{</tab>}}

{{</tabs>}}

To test if enabling X-forwarding worked, try running this command
on the lab machine over SSH:
```
xcowsay "Hello, World\!"
```

If you see the message on your screen, it worked! You 
should now be able to run your graphical Java programs.