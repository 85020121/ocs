package com.hesong.ocs;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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

    private static ApplicationContext context;

    public TimerTest() {
        super();
    }

    @BeforeClass
    public static void testSetup() {
        context = new ClassPathXmlApplicationContext("spring_beans.xml");
    }

    @AfterClass
    public static void testCleanup() {
        // Teardown for data used by the unit tests
        ((AbstractApplicationContext) context).registerShutdownHook();

    }

    /**
     * assert1：测试跨度为一天的时长，返回值单位为秒 assert2：测试返回格式为XX小时YY分ZZ秒格式的时长
     * assert3：测试计费规则为长途通话的话费
     */
    @SuppressWarnings("deprecation")
    @Test
    public void test() {
        Date start = new Date(113, 12, 20, 14, 10, 00);
        Date end = new Date(113, 12, 21, 14, 10, 00);
        int d = TimeCalculator.duration(start, end);
        assertTrue(d == 86400);
        assertEquals("24小时0分0秒", TimeCalculator.HMSFormatDuration(start, end));
        IRule rule = (IRule) context.getBean("TollCallRule");
        CallInfo c = CallInfoFactory.getCallInfo(1, 1, 1, 1, start, end);
        double p = CallManager.getPrice(c, rule);
        assertTrue(p == 432);
    }

}
