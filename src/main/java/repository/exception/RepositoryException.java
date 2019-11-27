package repository.exception;

public class RepositoryException extends Exception {
    public RepositoryException(Exception exception) {
        super(exception);
    }
    public RepositoryException(String text) {
        super(text);
    }
}
