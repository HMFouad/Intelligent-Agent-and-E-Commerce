public class RunImpl2 implements Runnable {
 
        private CompteEnBanque cb;
        private String name;
        
        public RunImpl2(CompteEnBanque cb, String name){
                this.cb = cb;
                this.name = name;
        }
        
        public void run() {
                
                for(int i = 0; i < 50; i++){
                                                
                        if(cb.getSolde() > 0){
                                cb.retraitArgent(2);
                                System.out.println("Retrait effectué par " + this.name);                       
                        }                       
                }               
        }
 
}
