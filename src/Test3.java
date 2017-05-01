public class Test3 {
        
        public static void main(String[] args) {
                
                CompteEnBanque cb = new CompteEnBanque();
                CompteEnBanque cb2 = new CompteEnBanque();
                                
                Thread t = new Thread(new RunImpl2(cb, "Cysboy"));
                Thread t2 = new Thread(new RunImpl2(cb2, "ZérO"));
                t.start();
                t2.start();
        }

        
        public static void main2(String[] args) {
                
                CompteEnBanque cb = new CompteEnBanque();
                CompteEnBanque cb2 = new CompteEnBanque();
                                
                Thread t = new Thread(new RunImpl2(cb, "Cysboy"));
                Thread t2 = new Thread(new RunImpl2(cb2, "ZérO"));
                t.start();
                t2.start();
        }
        
        public static void main3(String[] args) {
                
                CompteEnBanque cb = new CompteEnBanque();
                CompteEnBanque cb2 = new CompteEnBanque();
                                
                Thread t = new Thread(new RunImpl2(cb, "Cysboy"));
                Thread t2 = new Thread(new RunImpl2(cb2, "ZérO"));
                t.start();
                t2.start();
        }
        
        public static void main4(String[] args) {
                
                CompteEnBanque cb = new CompteEnBanque();
                CompteEnBanque cb2 = new CompteEnBanque();
                                
                Thread t = new Thread(new RunImpl2(cb, "Cysboy"));
                Thread t2 = new Thread(new RunImpl2(cb2, "ZérO"));
                t.start();
                t2.start();
        }


}

