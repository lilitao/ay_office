package com.ay.erp.dao.repository;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Run run = new Run();
        Thread thread = new Thread(run);
        thread.start();
        Thread.sleep(1000);
        run.is = false;
        thread.join();
    }
    public static class Run implements  Runnable{
        public static boolean is = true;
        @Override
        public void run() {
            int i = 0;
            while (is) {
                System.out.println(i++ + "-----------------");
            }
            if (!is) {
                System.out.println(i++ + "退出");
            }
        }
    }
}
