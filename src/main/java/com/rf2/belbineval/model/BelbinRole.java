package com.rf2.belbineval.model;

public enum BelbinRole {

    // Social Roles
    RESOURCE_INVESTIGATOR(
            "Resource Investigator",
            RoleCategory.SOCIAL,
            "Uses their inquisitive nature to find ideas to bring back to the team.",
            "Outgoing, enthusiastic. Explores opportunities and develops contacts.",
            "Might be over-optimistic, and can lose interest once the initial enthusiasm has passed."
    ),
    TEAMWORKER(
            "Teamworker",
            RoleCategory.SOCIAL,
            "Helps the team to gel, using their versatility to identify the work required and complete it on behalf of the team.",
            "Co-operative, perceptive and diplomatic. Listens and averts friction.",
            "Can be indecisive in crunch situations and tends to avoid confrontation."
    ),
    COORDINATOR(
            "Co-ordinator",
            RoleCategory.SOCIAL,
            "Needed to focus on the team's objectives, draw out team members and delegate work appropriately.",
            "Mature, confident, identifies talent. Clarifies goals.",
            "Can be seen as manipulative and might offload their own share of the work."
    ),

    // Thinking Roles
    PLANT(
            "Plant",
            RoleCategory.THINKING,
            "Tends to be highly creative and good at solving problems in unconventional ways.",
            "Creative, imaginative, free-thinking, generates ideas and solves difficult problems.",
            "Might ignore incidentals, and may be too preoccupied to communicate effectively."
    ),
    MONITOR_EVALUATOR(
            "Monitor Evaluator",
            RoleCategory.THINKING,
            "Provides a logical eye, making impartial judgements where required and weighs up the team's options in a dispassionate way.",
            "Sober, strategic and discerning. Sees all options and judges accurately.",
            "Sometimes lacks the drive and ability to inspire others and can be overly critical."
    ),
    SPECIALIST(
            "Specialist",
            RoleCategory.THINKING,
            "Brings in-depth knowledge of a key area to the team.",
            "Single-minded, self-starting and dedicated. Provides specialist knowledge and skills.",
            "Tends to contribute on a narrow front and can dwell on the technicalities."
    ),

    // Task Roles
    SHAPER(
            "Shaper",
            RoleCategory.TASK,
            "Provides the necessary drive to ensure that the team keeps moving and does not lose focus or momentum.",
            "Challenging, dynamic, thrives on pressure. Has the drive and courage to overcome obstacles.",
            "Can be prone to provocation, and may sometimes offend people's feelings."
    ),
    IMPLEMENTER(
            "Implementer",
            RoleCategory.TASK,
            "Needed to plan a workable strategy and carry it out as efficiently as possible.",
            "Practical, reliable, efficient. Turns ideas into actions and organises work that needs to be done.",
            "Can be a bit inflexible and slow to respond to new possibilities."
    ),
    COMPLETER_FINISHER(
            "Completer Finisher",
            RoleCategory.TASK,
            "Most effectively used at the end of tasks to polish and scrutinise the work for errors, subjecting it to the highest standards of quality control.",
            "Painstaking, conscientious, anxious. Searches out errors. Polishes and perfects.",
            "Can be inclined to worry unduly, and reluctant to delegate."
    );

    private final String displayName;
    private final RoleCategory category;
    private final String description;
    private final String strengths;
    private final String allowableWeaknesses;

    BelbinRole(String displayName,
               RoleCategory category,
               String description,
               String strengths,
               String allowableWeaknesses) {
        this.displayName = displayName;
        this.category = category;
        this.description = description;
        this.strengths = strengths;
        this.allowableWeaknesses = allowableWeaknesses;
    }

    public String getDisplayName() { return displayName; }
    public RoleCategory getCategory() { return category; }
    public String getDescription() { return description; }
    public String getStrengths() { return strengths; }
    public String getAllowableWeaknesses() { return allowableWeaknesses; }
}