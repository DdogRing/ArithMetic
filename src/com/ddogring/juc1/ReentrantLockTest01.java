package com.ddogring.juc1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁
 * @author DdogRing
 *
 */
public class ReentrantLockTest01 {
    // 默认空构造函数就是非公平锁
    Lock lock1 = new ReentrantLock();

    // 公平锁
    Lock lock2 = new ReentrantLock(true);

}
