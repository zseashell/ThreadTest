package chap4.seperate_launch_and_result_processing_in_executor;

import java.util.concurrent.CompletionService;

public class ReportRequest implements Runnable {

	private String name;

	private CompletionService<String> service;

	public ReportRequest(String name, CompletionService<String> service) {
		this.name = name;
		this.service = service;
	}

	@Override
	public void run() {
		ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
		service.submit(reportGenerator);
	}

}
