import java.util.ArrayList;

public class CarQueue {




	private ArrayList<Integer> daQueue;



	public CarQueue() {
		daQueue = new ArrayList<Integer>();
		daQueue.add(0);
		daQueue.add(1);
		daQueue.add(2);
		daQueue.add(3);
		daQueue.add(1);
		daQueue.add(0);

	}

	public void addToQueue() {


		class throod implements Runnable{


			public void run() {
				for(;;) {
					int toadd =(int) (Math.random()*4);
					daQueue.add(toadd);
					

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}

				}
			}

		}
		Runnable r = new throod();
		Thread t = new Thread(r);
		t.start();



	}

	public int deleteQueue() {
		synchronized(daQueue) {
			int y = daQueue.remove(0);
			//System.out.println(y);
			return y;

		}

	}
}
