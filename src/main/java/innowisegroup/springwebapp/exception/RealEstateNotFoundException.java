package innowisegroup.springwebapp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RealEstateNotFoundException extends RuntimeException{

    public RealEstateNotFoundException(String message) {
        super(message);
    }
}
