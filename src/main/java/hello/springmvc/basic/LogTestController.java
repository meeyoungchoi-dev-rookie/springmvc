package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    // @Slf4j 어노테이션을 사용하면 Logger 객체를 직접 생성하지 않아도 된다
   //  private  final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "spring";

        log.trace("trace log= " + name);
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}" , name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }

}
