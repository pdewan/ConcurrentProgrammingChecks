package gradingTools.javaThreads.hello.execution.extra;

import java.beans.PropertyChangeEvent;

import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChange;
import gradingTools.shared.testcases.concurrency.propertyChanges.ConcurrentPropertyChangeSupport;
import gradingTools.shared.testcases.concurrency.propertyChanges.Selector;

public class HelloMainWaitSelector implements Selector<ConcurrentPropertyChangeSupport> {

	@Override
	public boolean selects(ConcurrentPropertyChangeSupport aSupport) {
		ConcurrentPropertyChange aConcurrentEvent = aSupport.getLastConcurrentPropertyChange();
		return aConcurrentEvent.getEvent().getNewValue().toString().contains("main");
	}

}
