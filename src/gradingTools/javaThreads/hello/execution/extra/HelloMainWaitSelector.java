package gradingTools.javaThreads.hello.execution.extra;

import java.beans.PropertyChangeEvent;

import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChange;
import grader.basics.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import grader.basics.concurrency.propertyChanges.Selector;

public class HelloMainWaitSelector implements Selector<ConcurrentPropertyChangeSupport> {

	@Override
	public boolean selects(ConcurrentPropertyChangeSupport aSupport) {
		ConcurrentPropertyChange aConcurrentEvent = aSupport.getLastConcurrentPropertyChange();
		return aConcurrentEvent.getEvent().getNewValue().toString().contains("main");
	}

}
