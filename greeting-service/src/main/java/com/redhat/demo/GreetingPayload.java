package com.redhat.demo;

import java.time.Instant;

public record GreetingPayload(String userName, Instant timestamp, String greetingText) {
}
