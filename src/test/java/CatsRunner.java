import com.intuit.karate.Results;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CatsRunner {

    private static final String REPORT_PATH = "target/";

    @Test
    public void testParallel() throws IOException {
        Results results = com.intuit.karate.Runner.parallel(this.getClass(), 1, REPORT_PATH);
        generateReport();
        assert results.getFailCount() == 0;
    }

    private static void generateReport() throws IOException {
        List<String> jsons = Files.walk(Paths.get(REPORT_PATH)).map(Path::toString).filter(path -> path.endsWith("json")).collect(Collectors.toList());
        Configuration config = new Configuration(new File(REPORT_PATH), "CatsApi");

        new ReportBuilder(jsons, config).generateReports();
    }
}