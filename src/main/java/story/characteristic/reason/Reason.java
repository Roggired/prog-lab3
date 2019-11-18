package story.characteristic.reason;

import java.util.List;

public abstract class Reason {
    protected List<IReasonProducer> reasonSupliers;


    public Reason(List<IReasonProducer> reasonSupliers) {
        this.reasonSupliers = reasonSupliers;
    }


    public List<IReasonProducer> getReasonSupliers() {
        return reasonSupliers;
    }

    public abstract String getDescription();
}
