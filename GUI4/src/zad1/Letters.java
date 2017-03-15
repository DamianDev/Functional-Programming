package zad1;

class Letters {
    
    private String input;
    Thread[] threads;
    private boolean isFinished = false;
    
    public Letters(String input) {
        this.input = input;
        createThreads();
    }
    
    public void createThreads() {
        final char[] letters = input.toCharArray();
        threads = new Thread[letters.length];
        int i = 0;
        while( i < letters.length) {
            int j = i;
            threads[i] = new Thread( () -> {
                    while(!isFinished) {
                        try {
                        	System.out.print(letters[j]);
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            return;
                        }
                    }
            }
            ,"Thread " + letters[i]);
            i++;
        }
    }
    
    public Thread[] getThreads() {
        return threads;
    }
    
    public void finish() {
    	isFinished = true;
    }
    
}
