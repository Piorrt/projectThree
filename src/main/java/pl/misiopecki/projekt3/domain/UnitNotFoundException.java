package pl.misiopecki.projekt3.domain;

public class UnitNotFoundException extends RuntimeException {

    public UnitNotFoundException(String message) {
        super(message);
    }
}