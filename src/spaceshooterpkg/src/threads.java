package spaceshooterpkg.src;

class sd implements Runnable{
	 private Thread t;
	 private String threadName;
	 
	 sd(String threadName){
		 this.threadName=threadName;
	 }
	 public void run()
	 {
		 while(true)
			  System.out.print(threadName);
	 }
	 public void start()
	 {
		 if(t==null)
		 {
			 t=new Thread(this,threadName);
			 t.start();
		 }
	 }
}
public class threads {
	public static void main(String[] args) {
		sd A=new sd("a");
		sd B=new sd("b");
		
		B.start();
		A.start();
	}
}