package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("userName={} , age={}", userName , age);

        response.getWriter().write("OK");
    }


    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("userName") String userName ,
                                 @RequestParam("age") int memberAge) {

        log.info("userName={} , aage={}", userName , memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String userName ,
                                 @RequestParam int age) {
        log.info("userName={} , age={}", userName , age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String userName , int age) {

        log.info("userName={} , age={}", userName , age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String userName ,
                                       @RequestParam(required = false) Integer age) {

        log.info("userName={} , age={}", userName , age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String userName ,
                                       @RequestParam(defaultValue = "-1") int age) {

        log.info("userName={} , age={}", userName , age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        log.info("userName={} , age={}", paramMap.get("userName") , paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("helloData={}" , helloData.toString());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("helloData={}" , helloData.toString());
        return "ok";
    }

}
