public class SumUpExample {
    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumUpExample(long startRange, long endRange){
        startRange = startRange;
        endRange = endRange;
    }

    public void add(){
        for(long i = startRange; i <= endRange){
            counter += 1;
        }
    }

    public static void twoThreads() throws InterruptedException{
        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM/2);
        SumUpExample s2 = new SumUpExample(1 + (MAX_NUM /2), MAX_NUM);

        Thread t1 = new Thread(()->{
            s1.add();
        });


        Thread t2 = new Thread(()->{
            s2.add();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
    }
}
