package com.rf2.belbineval.seeder;

import com.rf2.belbineval.model.BelbinRole;
import com.rf2.belbineval.model.Question;
import com.rf2.belbineval.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    @Override
    public void run(String... args) {
        if (questionRepository.existsBySectionNumber(1)) return; // already seeded

        questionRepository.saveAll(List.of(

                // ── SECTION 1 ──────────────────────────────────────────────
                Question.builder().sectionNumber(1).statementIndex(1).role(BelbinRole.IMPLEMENTER)
                        .text("I think I can quickly see and take advantage of new opportunities.").build(),
                Question.builder().sectionNumber(1).statementIndex(2).role(BelbinRole.TEAMWORKER)
                        .text("I can work well with a very wide range of people.").build(),
                Question.builder().sectionNumber(1).statementIndex(3).role(BelbinRole.COORDINATOR)
                        .text("Producing ideas is one of my natural assets.").build(),
                Question.builder().sectionNumber(1).statementIndex(4).role(BelbinRole.PLANT)
                        .text("My ability rests in being able to draw people out whenever I detect they have something of value to contribute.").build(),
                Question.builder().sectionNumber(1).statementIndex(5).role(BelbinRole.MONITOR_EVALUATOR)
                        .text("My ability to follow through has made me an effective finisher.").build(),
                Question.builder().sectionNumber(1).statementIndex(6).role(BelbinRole.SHAPER)
                        .text("I am ready to face temporary unpopularity if it leads to worthwhile results in the end.").build(),
                Question.builder().sectionNumber(1).statementIndex(7).role(BelbinRole.RESOURCE_INVESTIGATOR)
                        .text("I can usually sense what is realistic and likely to work.").build(),
                Question.builder().sectionNumber(1).statementIndex(8).role(BelbinRole.COMPLETER_FINISHER)
                        .text("I can offer a reasoned case for alternative courses of action without introducing bias or prejudice.").build(),

                // ── SECTION 2 ──────────────────────────────────────────────
                Question.builder().sectionNumber(2).statementIndex(1).role(BelbinRole.TEAMWORKER)
                        .text("I feel uncomfortable in meetings and feel inadequate at presenting my views.").build(),
                Question.builder().sectionNumber(2).statementIndex(2).role(BelbinRole.MONITOR_EVALUATOR)
                        .text("I sometimes strongly dislike people who take a casual attitude to work that could turn out to be important.").build(),
                Question.builder().sectionNumber(2).statementIndex(3).role(BelbinRole.PLANT)
                        .text("I tend to talk too much once the group gets on to new ideas.").build(),
                Question.builder().sectionNumber(2).statementIndex(4).role(BelbinRole.RESOURCE_INVESTIGATOR)
                        .text("My objective outlook makes it difficult for me to join in readily with colleagues.").build(),
                Question.builder().sectionNumber(2).statementIndex(5).role(BelbinRole.COORDINATOR)
                        .text("I am sometimes seen as forceful and authoritarian where there is a need to get things done.").build(),
                Question.builder().sectionNumber(2).statementIndex(6).role(BelbinRole.SHAPER)
                        .text("I find it hard to take the lead, perhaps because I am over-responsive to group atmosphere.").build(),
                Question.builder().sectionNumber(2).statementIndex(7).role(BelbinRole.IMPLEMENTER)
                        .text("I tend to get too caught up in ideas that occur to me and so lose track of what is happening.").build(),
                Question.builder().sectionNumber(2).statementIndex(8).role(BelbinRole.COMPLETER_FINISHER)
                        .text("My colleagues tend to see me as worrying unnecessarily over detail.").build(),

                // ── SECTION 3 ──────────────────────────────────────────────
                Question.builder().sectionNumber(3).statementIndex(1).role(BelbinRole.SHAPER)
                        .text("I can influence people without pressuring them.").build(),
                Question.builder().sectionNumber(3).statementIndex(2).role(BelbinRole.IMPLEMENTER)
                        .text("My general vigilance prevents careless mistakes and omissions being made.").build(),
                Question.builder().sectionNumber(3).statementIndex(3).role(BelbinRole.RESOURCE_INVESTIGATOR)
                        .text("I am ready to press for action to make sure that the meeting does not waste time or lose sight of the main objective.").build(),
                Question.builder().sectionNumber(3).statementIndex(4).role(BelbinRole.PLANT)
                        .text("I can be relied upon to contribute something original.").build(),
                Question.builder().sectionNumber(3).statementIndex(5).role(BelbinRole.MONITOR_EVALUATOR)
                        .text("I am always ready to support a good suggestion in the common interest.").build(),
                Question.builder().sectionNumber(3).statementIndex(6).role(BelbinRole.COORDINATOR)
                        .text("I keep a watchful eye out for the latest ideas and developments.").build(),
                Question.builder().sectionNumber(3).statementIndex(7).role(BelbinRole.COMPLETER_FINISHER)
                        .text("I think my capacity for cool judgment is appreciated by others.").build(),
                Question.builder().sectionNumber(3).statementIndex(8).role(BelbinRole.TEAMWORKER)
                        .text("I can be relied upon to get essential work organised.").build(),

                // ── SECTION 4 ──────────────────────────────────────────────
                Question.builder().sectionNumber(4).statementIndex(1).role(BelbinRole.PLANT)
                        .text("I am keen to find out the latest ideas and developments.").build(),
                Question.builder().sectionNumber(4).statementIndex(2).role(BelbinRole.TEAMWORKER)
                        .text("I am good at ensuring that other people's views are taken into account.").build(),
                Question.builder().sectionNumber(4).statementIndex(3).role(BelbinRole.COORDINATOR)
                        .text("I have a natural inclination to bring people together.").build(),
                Question.builder().sectionNumber(4).statementIndex(4).role(BelbinRole.COMPLETER_FINISHER)
                        .text("I have a tendency to be a perfectionist.").build(),
                Question.builder().sectionNumber(4).statementIndex(5).role(BelbinRole.RESOURCE_INVESTIGATOR)
                        .text("I am ready to exploit any opportunity that presents itself.").build(),
                Question.builder().sectionNumber(4).statementIndex(6).role(BelbinRole.SHAPER)
                        .text("I like to think carefully before committing myself to a course of action.").build(),
                Question.builder().sectionNumber(4).statementIndex(7).role(BelbinRole.MONITOR_EVALUATOR)
                        .text("I can analyse the factors of a situation from a variety of angles.").build(),
                Question.builder().sectionNumber(4).statementIndex(8).role(BelbinRole.IMPLEMENTER)
                        .text("I enjoy practical work that has a visible outcome.").build(),

                // ── SECTION 5 ──────────────────────────────────────────────
                Question.builder().sectionNumber(5).statementIndex(1).role(BelbinRole.MONITOR_EVALUATOR)
                        .text("I am always ready to challenge or modify a decision if it seems wrong.").build(),
                Question.builder().sectionNumber(5).statementIndex(2).role(BelbinRole.IMPLEMENTER)
                        .text("I try to make my responses predictable so that people know what to expect.").build(),
                Question.builder().sectionNumber(5).statementIndex(3).role(BelbinRole.PLANT)
                        .text("I like to find original approaches to problems.").build(),
                Question.builder().sectionNumber(5).statementIndex(4).role(BelbinRole.RESOURCE_INVESTIGATOR)
                        .text("I enjoy negotiating and think I am good at it.").build(),
                Question.builder().sectionNumber(5).statementIndex(5).role(BelbinRole.COMPLETER_FINISHER)
                        .text("I can be very demanding of people if they fail to deliver.").build(),
                Question.builder().sectionNumber(5).statementIndex(6).role(BelbinRole.COORDINATOR)
                        .text("I tend to take a back seat and am good at enabling others to shine.").build(),
                Question.builder().sectionNumber(5).statementIndex(7).role(BelbinRole.SHAPER)
                        .text("I am well-organised and systematic; I take pleasure in efficient working.").build(),
                Question.builder().sectionNumber(5).statementIndex(8).role(BelbinRole.TEAMWORKER)
                        .text("I have a particular aptitude for sensing atmosphere in a group.").build(),

                // ── SECTION 6 ──────────────────────────────────────────────
                Question.builder().sectionNumber(6).statementIndex(1).role(BelbinRole.TEAMWORKER)
                        .text("I have the capacity to take the lead in discussions.").build(),
                Question.builder().sectionNumber(6).statementIndex(2).role(BelbinRole.PLANT)
                        .text("I can get on with people and listen to what they have to say.").build(),
                Question.builder().sectionNumber(6).statementIndex(3).role(BelbinRole.COMPLETER_FINISHER)
                        .text("I can produce a flow of original proposals and suggestions.").build(),
                Question.builder().sectionNumber(6).statementIndex(4).role(BelbinRole.COORDINATOR)
                        .text("I can spot the need for improving the way a group works.").build(),
                Question.builder().sectionNumber(6).statementIndex(5).role(BelbinRole.SHAPER)
                        .text("I believe I can inspire people by identifying what matters and what doesn't.").build(),
                Question.builder().sectionNumber(6).statementIndex(6).role(BelbinRole.IMPLEMENTER)
                        .text("I know how to organise and use resources efficiently.").build(),
                Question.builder().sectionNumber(6).statementIndex(7).role(BelbinRole.RESOURCE_INVESTIGATOR)
                        .text("I am good at spotting and grasping new opportunities.").build(),
                Question.builder().sectionNumber(6).statementIndex(8).role(BelbinRole.MONITOR_EVALUATOR)
                        .text("I have an aptitude for seeing all sides of a problem.").build(),

                // ── SECTION 7 ──────────────────────────────────────────────
                Question.builder().sectionNumber(7).statementIndex(1).role(BelbinRole.PLANT)
                        .text("I think I have a talent for sorting out concrete steps that need to be taken.").build(),
                Question.builder().sectionNumber(7).statementIndex(2).role(BelbinRole.RESOURCE_INVESTIGATOR)
                        .text("My inclination to be direct sometimes causes offence to others.").build(),
                Question.builder().sectionNumber(7).statementIndex(3).role(BelbinRole.SHAPER)
                        .text("I like to weigh up the available options carefully before making a choice.").build(),
                Question.builder().sectionNumber(7).statementIndex(4).role(BelbinRole.COORDINATOR)
                        .text("I am best at working with people who are competent and dedicated.").build(),
                Question.builder().sectionNumber(7).statementIndex(5).role(BelbinRole.IMPLEMENTER)
                        .text("I am well-suited to take charge and get things moving.").build(),
                Question.builder().sectionNumber(7).statementIndex(6).role(BelbinRole.TEAMWORKER)
                        .text("I have something of a perfectionist streak that I find hard to abandon.").build(),
                Question.builder().sectionNumber(7).statementIndex(7).role(BelbinRole.MONITOR_EVALUATOR)
                        .text("I find it easy to create a lively atmosphere at work.").build(),
                Question.builder().sectionNumber(7).statementIndex(8).role(BelbinRole.COMPLETER_FINISHER)
                        .text("I can offer a reasoned case for alternative courses of action.").build()
        ));
    }
}
