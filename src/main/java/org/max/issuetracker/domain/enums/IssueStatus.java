package org.max.issuetracker.domain.enums;

public enum IssueStatus {
    TODO,
    IN_PROGRESS,
    DONE,
    BLOCKED;

    public boolean canTransitionTo(IssueStatus target) {
        return switch (this) {
            case TODO, BLOCKED -> target == IN_PROGRESS;
            case IN_PROGRESS -> target == BLOCKED || target == DONE;
            case DONE -> false;
        };
    }
}
