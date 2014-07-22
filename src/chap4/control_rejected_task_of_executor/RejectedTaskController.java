package chap4.control_rejected_task_of_executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		System.out.printf(
				"RejectedTaskController: The task %s has been rejected\n",
				runnable.toString());
		System.out.printf("RejectedTaskController: Executor %s\n",
				executor.toString());
		System.out.printf("RejectedTaskController: Terminating? %s\n",
				executor.isTerminating());
		System.out.printf("RejectedTaskController: Terminated? %s\n",
				executor.isTerminated());
	}

}
