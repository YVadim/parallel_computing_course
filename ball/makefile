JCC = javac
JFLAGS = -g
default: BounceFrame.class BallPanel.class BallSimple.class

BounceFrame.class: BounceFrame.java
	$(JCC) $(JFLAGS) BounceFrame.java

BallPanel.class: BallPanel.java
	$(JCC) $(JFLAGS) BallPanel.java

BallSimple.class: BallSimple.java
	$(JCC) $(JFLAGS) BallSimple.java

clean:
	$(RM) *.class
