package net.luvina;

import java.io.IOException;
import java.io.UncheckedIOException;

public class PostException extends UncheckedIOException {

    public PostException(String message, IOException cause) {
        super(message, cause);
    }
}
