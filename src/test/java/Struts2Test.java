import com.selonj.supports.Application;
import com.selonj.supports.ApplicationDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by L.x on 16-2-18.
 */
public class Struts2Test {
    private Application application = new Application();
    private ApplicationDriver driver = new ApplicationDriver(application);

    @Before
    public void start() throws Exception {
        application.start();
    }

    @Test
    public void ping() throws Exception {
        driver.get("/");

        driver.hasSentMessageContaining("Get Started Struts2");
    }

    @Test
    public void echo() throws Exception {
        driver.get("/echo?username=Dove");

        driver.hasSentMessageContaining("{\"username\":\"Dove\"}");
    }

    @After
    public void stop() throws Exception {
        application.stop();
        driver.close();
    }
}
