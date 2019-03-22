package eu.cwsfe.demo.statistics;

import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Radosław Osiński
 */
@Controller
public class HelloController {

    /**
     * https://micrometer.io/docs/concepts
     */
    @Timed(value = "helloController.hello1")
    @GetMapping("/hello1")
    @ResponseBody
    public String hello1 () {
        return "hello 1 test";
    }

}
