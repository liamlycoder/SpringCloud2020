package cn.liamcoder.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > 0x7fffffff ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));  // 调用CAS，进行自旋锁，每次next+1
        System.out.println("next的当前值：" + next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> servicesInstances) {
        int index = getAndIncrement() % servicesInstances.size();
        return servicesInstances.get(index);
    }
}
