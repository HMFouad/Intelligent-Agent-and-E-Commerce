// les threads ne s'exécutent pas en même temps !


public class TestThread extends Thread {
 
        Thread t;
                
        public TestThread(String name){
                super(name);
                System.out.println("statut du thread " + name + " = " +this.getState());
                this.start();
                System.out.println("statut du thread " + name + " = " +this.getState());
        }
        
        public TestThread(String name, Thread t){
                super(name);
                this.t = t;
                System.out.println("statut du thread " + name + " = " +this.getState());
                this.start();
                System.out.println("statut du thread " + name + " = " +this.getState());
        }
        
        
        
        public void run(){
                for(int i = 0; i < 10; i++){
                        System.out.println("statut " + this.getName() + " = " +this.getState());
                        if(t != null)System.out.println("statut de " + t.getName() + " pendant le thread " + this.getName() +" = " +t.getState());
                }
        }
//        public class Test {
        
        public static void main(String[] args) {
                
                TestThread t = new TestThread("A");
                TestThread t2 = new TestThread("  B", t);
                                
                try {
                        Thread.sleep(1000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                System.out.println("statut du thread " + t.getName() + " = " + t.getState());
                System.out.println("statut du thread " + t2.getName() + " = " +t2.getState());
                
        }
//}


        
        public void setThread(Thread t){
                this.t = t;
        }
        


}
