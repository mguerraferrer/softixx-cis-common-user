package mx.softixx.cis.common.user.payload;

public record TokenRequest(String client, String secret, String email, String hash) {
}