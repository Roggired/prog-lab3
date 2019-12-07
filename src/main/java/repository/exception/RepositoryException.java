package repository.exception;

public class RepositoryException extends RuntimeException {
    public RepositoryException(Throwable throwable) {
        super(throwable);
    }
    public RepositoryException(String text) {
        super(text);
    }
}
