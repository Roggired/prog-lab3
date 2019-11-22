package story.characteristic.reason;

import java.util.List;

public abstract class Reason {
    protected String preposition;

    protected List<? extends IReasonProducer> reasonProducers;


    public Reason(List<? extends IReasonProducer> reasonProducers,
                  String preposition) {
        this.reasonProducers = reasonProducers;
        this.preposition = preposition;
    }


    public abstract String getDescription();
}
