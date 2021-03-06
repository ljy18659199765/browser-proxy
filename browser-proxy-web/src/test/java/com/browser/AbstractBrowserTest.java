package com.browser;

import com.wolf.framework.context.ApplicationContext;
import com.wolf.framework.test.TestHandler;
import java.util.Properties;
import org.junit.AfterClass;

/**
 *
 * @author aladdin
 */
public class AbstractBrowserTest {

    protected final TestHandler testHandler;

    public AbstractBrowserTest() {
        Properties configProperties = new Properties();
        configProperties.setProperty("appPath", "/browser");
        configProperties.setProperty("packageName", "com.browser");
        configProperties.setProperty("hbaseZookeeperQuorum", "192.168.19.221");
//        configProperties.setProperty("fsDefaultName", "hdfs://192.168.64.50:9000/");
//        configProperties.setProperty("dataBaseType", "EMBEDDED");
//        configProperties.setProperty("dataBaseName", "/data/derby/spider");
        configProperties.setProperty("dataBaseType", "CLIENT");
        configProperties.setProperty("dataBaseName", "search");
        configProperties.setProperty("dataServerName", "192.168.19.218");
        configProperties.setProperty("dataServerPort", "1527");
        configProperties.setProperty("chromeDriver", "/home/aladdin/chromedriver");
        configProperties.setProperty("chromeBinary", "/usr/bin/chromium-browser");
        this.testHandler = new TestHandler(configProperties);
    }

    @AfterClass
    public static void tearDownClass() {
        ApplicationContext.CONTEXT.shutdownDatabase();
    }
}
