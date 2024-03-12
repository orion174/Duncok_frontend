package aips.duncok;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class DuncokWwwApplication {
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DuncokWwwApplication.class);

        app.setBanner((environment, sourceClass, out) -> {
            out.println();
            out.println("================================================================================================");
            out.println("================================================================================================");
            out.println("                              Duncok www application start                                      ");
            out.println("                              던콕 프론트엔드 어플리케이션 시작                                       ");
            out.println("================================================================================================");
            out.println("================================================================================================");
            out.println();
        });

        app.run(args);
    }
}