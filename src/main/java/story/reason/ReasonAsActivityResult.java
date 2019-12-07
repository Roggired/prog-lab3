package story.reason;


public final class ReasonAsActivityResult extends Reason {
    private String text;


    public ReasonAsActivityResult(String text) {
        this.text = text;
    }

    @Override
    public String getDescription() {
        return text;
    }
}
