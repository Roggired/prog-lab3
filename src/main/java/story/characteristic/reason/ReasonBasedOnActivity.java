package story.characteristic.reason;


import java.util.List;

public final class ReasonBasedOnActivity extends Reason {
    private List<String> activityNames;


    public ReasonBasedOnActivity(List<IReasonProducer> reasonProducers,
                                 String preposition,
                                 List<String> activityNames) {
        super(reasonProducers, preposition);
        this.activityNames = activityNames;
    }

    @Override
    public String getDescription() {
        return preposition + " " + createReasonProducersDescription() + " " + createActivitiesDescription();
    }

    private String createReasonProducersDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < reasonProducers.size(); index++) {
            stringBuilder.append(reasonProducers.get(index).getName());

            if (index != reasonProducers.size() - 1) {
                stringBuilder.append(" и ");
            }
        }

        return stringBuilder.toString();
    }

    private String createActivitiesDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < activityNames.size(); index++) {
            stringBuilder.append(activityNames.get(index));

            if (index != activityNames.size() - 1) {
                stringBuilder.append(" и ");
            }
        }

        return stringBuilder.toString();
    }
}
