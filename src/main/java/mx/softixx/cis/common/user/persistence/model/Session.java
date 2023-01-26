package mx.softixx.cis.common.user.persistence.model;

import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

@Entity
@Table(name = "sessions", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.session_seq_id", allocationSize = 1)
public class Session extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "session_key", nullable = false, unique = true)
	private String sessionKey;
	
	@Column(name="session_date", nullable = false)
	private LocalDateTime sessionDate;
	
	@Column(name = "access_token", nullable = false, unique = true)
	private String accessToken;

	@Column(name="access_token_expiry", nullable = false)
	private Instant accessTokenExpiry;

	@Column(name = "url", nullable = false, unique = true)
	private String url;
	
	@Column(name = "ip", nullable = false, unique = true)
	private String ip;
	
	/* Getters and Setters */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	
	public LocalDateTime getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(LocalDateTime sessionDate) {
		this.sessionDate = sessionDate;
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Instant getAccessTokenExpiry() {
		return accessTokenExpiry;
	}

	public void setAccessTokenExpiry(Instant accessTokenExpiry) {
		this.accessTokenExpiry = accessTokenExpiry;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Session [user=" + user.getEmail() + ", sessionKey=" + sessionKey + ", sessionDate=" + sessionDate
				+ ", accessToken=" + accessToken + ", accessTokenExpiry=" + accessTokenExpiry + ", url=" + url + ", ip="
				+ ip + "]";
	}

}