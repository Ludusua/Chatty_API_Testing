package dto;

public class RegistrationUserResponse {
    private String accessToken;
    private String refreshToken;
    private int  expiration;
    public RegistrationUserResponse() {
    }

    public RegistrationUserResponse(String accessToken, String refreshToken, int expiration) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiration = expiration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }
}
