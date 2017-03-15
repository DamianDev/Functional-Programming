package zad2;

public class StringTask implements Runnable {

	private String word;
	private volatile String result = "";
	private int num;
	private volatile TaskState state = TaskState.CREATED;
	//private boolean isAborted = false;
	private Thread t;
	
	public StringTask(String word, int num){ 
		this.word = word;
		this.num = num;
	}
	
	public String getResult() {
		return result;
	}
	
	public TaskState getState() {
		return this.state;
	}
	
	public void start() {
		t = new Thread(this);
		this.state = TaskState.RUNNING;
		t.start();
	}
	
	public void abort() {
		this.state = TaskState.ABORTED;
		t.interrupt();
	}
	
	public boolean isDone() {
		if(this.state == TaskState.READY || this.state == TaskState.ABORTED)
			return true;
		else
			return false;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= num; i++) {
			if(!Thread.interrupted())
				result += word;
			else
				return;
		}
		this.state = TaskState.READY;
	}
}
