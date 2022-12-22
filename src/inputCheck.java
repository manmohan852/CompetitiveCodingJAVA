public class Test implements Runnable
{
    public void run()
    {
        System.out.printf(" Thread's running ");
    }

	try
    {
		public Test()
        {
            Thread.sleep(5000);
        }
    }
	catch (InterruptedException e)
    {
        e.printStackTrace();
    }

    public static void main(String[] args)
    {
        Test obj = new Test();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.printf(" GFG ");
    }
}
