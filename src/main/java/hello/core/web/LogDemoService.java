package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    // private final MyLogger myLogger;
    // 1. ObjectProvider 활용
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    // 2. 프록시 활용
    private final MyLogger myLogger;

    public void logic(String id){
        // 1. ObjectProvider 활용
        // MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }
}
