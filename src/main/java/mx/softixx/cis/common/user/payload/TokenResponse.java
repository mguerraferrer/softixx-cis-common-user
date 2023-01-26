package mx.softixx.cis.common.user.payload;

import java.time.Instant;

public record TokenResponse(String accessToken, Instant expireAt) {
}