public class TestThread2 extends Thread {
 
                
        public TestThread2(String name){
                super(name);
        }
        
        public void run(){
                
                for(int i = 0; i < 10; i++)
                                System.out.println(this.getName());
                
        }       
public static void main(String[] args) {
                
                TestThread2 t = new TestThread2("A");
                TestThread2 t2 = new TestThread2("  B");
                TestThread2 t3 = new TestThread2("  C");
                t.start();
                t2.start();
                t3.start();
        }
}