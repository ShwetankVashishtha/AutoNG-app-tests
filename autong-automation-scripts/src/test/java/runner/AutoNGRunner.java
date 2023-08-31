package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = {"src/test/java/resources/"},
        glue = {"steps"},
        plugin = {"pretty"})
@RunWith(Cucumber.class)
public class AutoNGRunner {
}

