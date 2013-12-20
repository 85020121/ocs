package com.hesong.ocs;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hesong.ocs.factories.CallInfoFactory;
import com.hesong.ocs.managers.CallManager;
import com.hesong.ocs.pojo.CallInfo;
import com.hesong.ocs.rules.IRule;
import com.hesong.ocs.utilities.TimeCalculator;

public class TimerTest {

    @SuppressWarnings("deprecation")
    @Test
    public void test() {
        Date start = new Date(113, 12, 20, 14, 10, 00);
        Date end = new Date(113, 12, 20, 14, 11, 00);
        int d = TimeCalculator.duration(start, end);
        assertTrue(d == 60);
        
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_beans.xml");
        IRule rule = (IRule) context.getBean("TollCallRule");
        CallInfo c = CallInfoFactory.getCallInfo(1, 1, 1, 1, start, end);
        double p = CallManager.getPrice(c, rule);
        System.out.println("price = "+p);
        assertTrue(p == 0.3);
        
        ((AbstractApplicationContext)context).registerShutdownHook();
    }

}
