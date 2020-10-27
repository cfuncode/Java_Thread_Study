package com.cjz.state;

//线程状态
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000); //TIMED_WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////");
        });

        //观察线程状态
        Thread.State state = thread.getState();
        System.out.println(state);  //NEW

        //观察线程启动后
        thread.start(); //启动线程
        state = thread.getState();
        System.out.println(state);  //RUNNABLE

        while (state != Thread.State.TERMINATED){//只要线程不终止，就一直输出状态
            Thread.sleep(100);
            state = thread.getState();  //更新线程状态
            System.out.println(state);  //输出线程状态
        }

    }

}
