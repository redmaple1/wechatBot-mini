package com.wechat.remindBot.configuration;

import com.avos.avoscloud.AVOSCloud;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LearnCloudConfiguration implements ApplicationRunner {

    @Value("${learnCloud.appId}")
    private String learnCloudAppId;

    @Value("${learnCloud.appKey}")
    private String learnCloudAppKey;

    @Value("${learnCloud.masterKey}")
    private String masterKey;

    @Value("${learnCloud.debug}")
    private boolean debugEnabled;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AVOSCloud.initialize(learnCloudAppId,learnCloudAppKey,masterKey);
        AVOSCloud.setDebugLogEnabled(debugEnabled);

    }
}
