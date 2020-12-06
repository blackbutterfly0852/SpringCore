package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    //private final MyLogger myLogger;
    // 1. ObjectProvider 활용
    //private final ObjectProvider<MyLogger> myLoggerProvider;
    // 2. 프록시 활용
    private final MyLogger myLogger;

    // 1. ObjectProvider 활용
//    @RequestMapping("log-demo")
//    @ResponseBody
//    public String logDemo(HttpServletRequest request) throws InterruptedException {
//        MyLogger myLogger = myLoggerProvider.getObject();
//        String requestURL = request.getRequestURL().toString();
//        myLogger.setRequestURL(requestURL);
//
//        myLogger.log("controller test");
//        Thread.sleep(1000);
//        logDemoService.logic("testId");
//        return "OK";
//    }

    // 2. 프록시 활용
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }




}
