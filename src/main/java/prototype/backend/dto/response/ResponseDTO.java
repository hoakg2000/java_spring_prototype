package prototype.backend.dto.response;

public class ResponseDTO {

    private String error;
    public ResponseDTO(RuntimeException e){
        this.error = e.getMessage();
    }
}
