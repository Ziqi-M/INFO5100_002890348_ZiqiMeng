package singleton;

/**
 * @ClassName: Singleton
 * @description: lazy load : double check
 * @author: Ziqi Meng
 **/

//for Singleton,
// most of the time is to get the already exist instance,
// that won't cause thread safe problem,
// that's why we use double check to boost up the efficiency

public class Singleton {
    private Singleton(){}

    private static volatile Singleton instance;

    public static Singleton getInstance(){
        //first check
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

}