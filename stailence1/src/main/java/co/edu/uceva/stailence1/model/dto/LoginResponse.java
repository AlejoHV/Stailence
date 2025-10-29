package co.edu.uceva.stailence1.model.dto;

public class LoginResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private String nombre;
    private String correo;

    public LoginResponse(String accessToken, String nombre, String correo) {
        this.accessToken = accessToken;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
