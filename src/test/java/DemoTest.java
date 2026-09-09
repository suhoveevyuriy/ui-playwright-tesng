
import org.testng.annotations.Test;
import com.microsoft.playwright.CLI;
import java.io.IOException;
import java.net.URISyntaxException;


public class DemoTest {

        @Test
        public void verifyDemoTest () throws InterruptedException, IOException, URISyntaxException {
            CLI.main( new String[] {"codegen", "https://demowebshop.tricentis.com/"});
        }



    }

