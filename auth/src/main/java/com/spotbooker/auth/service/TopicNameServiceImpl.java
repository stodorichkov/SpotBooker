package com.spotbooker.auth.service;

import com.spotbooker.auth.constant.TopicConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicNameServiceImpl implements TopicNameService {
    @Override
    public String getTopicName(Class<?> clazz) {
        return clazz.getSimpleName() + TopicConstants.TOPIC_SUFFIX;
    }
}