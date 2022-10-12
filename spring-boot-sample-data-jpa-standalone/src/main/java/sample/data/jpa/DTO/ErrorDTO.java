package sample.data.jpa.DTO;

public class ErrorDTO implements DTO {
    private Exception ex;

    public ErrorDTO(Exception ex) {
        this.ex = ex;
    }

    public ErrorDTO() {
    }

    public Exception getEx() {
        return ex;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }
}
