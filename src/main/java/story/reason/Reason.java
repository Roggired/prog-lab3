package story.reason;

import java.util.ArrayList;
import java.util.List;

public abstract class Reason {
    protected String preposition;

    protected List<? extends IReasonProducer> reasonProducers;


    public Reason(List<? extends IReasonProducer> reasonProducers,
                  String preposition) {
        if (reasonProducers == null) {
            this.reasonProducers = new ArrayList<>();
        } else {
            this.reasonProducers = reasonProducers;
        }

        this.preposition = preposition;
    }


    public abstract String getDescription();

    protected String createReasonProducersDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < reasonProducers.size(); index++) {
            stringBuilder.append(reasonProducers.get(index).getName());

            if (index != reasonProducers.size() - 1) {
                stringBuilder.append(" и ");
            }
        }

        return stringBuilder.toString();
    }
}
