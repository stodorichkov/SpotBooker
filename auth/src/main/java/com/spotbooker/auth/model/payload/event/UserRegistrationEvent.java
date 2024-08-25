package com.spotbooker.auth.model.payload.event;

import com.spotbooker.auth.annotation.KafkaPayload;

@KafkaPayload
public record UserRegistrationEvent(Long id, String firstName, String lastName) {
}