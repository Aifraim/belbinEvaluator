package com.rf2.belbineval.model;

public enum BelbinRole {

    // Social Roles
    RESOURCE_INVESTIGATOR("Resource Investigator", RoleCategory.SOCIAL),
    TEAMWORKER("Teamworker",                       RoleCategory.SOCIAL),
    COORDINATOR("Co-ordinator",                    RoleCategory.SOCIAL),

    // Thinking Roles
    PLANT("Plant",                                 RoleCategory.THINKING),
    MONITOR_EVALUATOR("Monitor Evaluator",         RoleCategory.THINKING),
    SPECIALIST("Specialist",                       RoleCategory.THINKING),

    // Task Roles
    SHAPER("Shaper",                               RoleCategory.TASK),
    IMPLEMENTER("Implementer",                     RoleCategory.TASK),
    COMPLETER_FINISHER("Completer Finisher",       RoleCategory.TASK);

    private final String displayName;
    private final RoleCategory category;

    BelbinRole(String displayName, RoleCategory category) {
        this.displayName = displayName;
        this.category = category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public RoleCategory getCategory() {
        return category;
    }
}