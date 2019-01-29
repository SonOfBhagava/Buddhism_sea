package com.bhagava.common.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/25 15:22
 * @Description: 存放获取一些系统信息如内存使用情况，线程使用情况的类
 */
public class SystemUtil {
    /**
     * 获取当前已经使用的内存
     */
    public static String getMemory(){
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //椎内存使用情
//        long totalMemorySize = 0; //初始的总内存
//        long maxMemorySize = 0; //最大可用内存
        long usedMemorySize = memoryUsage.getUsed(); //已使用的内存
        return usedMemorySize/(1024 * 1024) + "M";
    }

    /**
     * 通过线程Id获得线程对象，若ID不存在则返回空
     * @param threadId
     * @return
     */
    public static Thread getThreadById(long threadId) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while(group != null) {
            Thread[] threads = new Thread[(int)(group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for(int i = 0; i < count; i++) {
                if(threadId == threads[i].getId()) {
                    return threads[i];
                }
            }
            group = group.getParent();
        }
        return null;
    }

    /**
     * 获得当前活跃的java程序线程的总数量
     * @return
     */
    public static int getCurrentThreadCount(){
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while(threadGroup.getParent() != null){
            threadGroup = threadGroup.getParent();
        }
        return threadGroup.activeCount();
    }

}
