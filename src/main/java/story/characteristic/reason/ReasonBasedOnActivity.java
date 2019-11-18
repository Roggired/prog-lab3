package story.characteristic.reason;

import java.util.List;

public final class ReasonBasedOnActivity extends Reason {
    private List<String> activityNames;


    public ReasonBasedOnActivity(List<IReasonProducer> reasonSupliers,
                                 List<String> activityNames) {
        super(reasonSupliers);
        this.activityNames = activityNames;
    }

    @Override
    public String getDescription() {
        return "потому что " + createReasonSupliersDescription() + " " + createActivitiesDescription();
    }

    private String createReasonSupliersDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < reasonSupliers.size(); index++) {
            stringBuilder.append(reasonSupliers.get(index).getName());

            if (index != reasonSupliers.size() - 1) {
                stringBuilder.append(" и ");
            }
        }

        return stringBuilder.toString();
    }

    private String createActivitiesDescription() {
        StringBuilder stringBuilder = new StringBuilder("выполнили");
        for (int index = 0; index < activityNames.size(); index++) {
            stringBuilder.append(activityNames.get(index));

            if (index != activityNames.size() - 1) {
                stringBuilder.append(" и ");
            }
        }

        return stringBuilder.toString();
    }
}
