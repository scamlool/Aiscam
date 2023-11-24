% Recommendation system for programming languages
recommend_language :-
    write("What is your experience level in programming? (beginner, intermediate, advanced): "),
    read(ExperienceLevel),
    inquire_experience_level(ExperienceLevel),
    undo.

% Predicates to determine experience level
inquire_experience_level(beginner) :-
    inquire_projects(beginner, Projects),
    inquire_domain(Domain),
    inquire_learning_style(LearningStyle),
    inquire_platform(Platform),
    inquire_project_type(ProjectType),
    inquire_favourite_paradigm(Paradigm),
    inquire_community_support(CommunitySupport),
    inquire_industry_demand(IndustryDemand),
    recommend(beginner, Projects, Domain, LearningStyle, Platform, ProjectType, Paradigm, CommunitySupport, IndustryDemand, Language),
    write("Based on your preferences, I recommend the following programming language: "), write(Language), nl,
    write("Happy coding!").

inquire_experience_level(intermediate) :-
    inquire_projects(intermediate, Projects),
    inquire_domain(Domain),
    inquire_learning_style(LearningStyle),
    inquire_platform(Platform),
    inquire_project_type(ProjectType),
    inquire_favourite_paradigm(Paradigm),
    inquire_community_support(CommunitySupport),
    inquire_industry_demand(IndustryDemand),
    recommend(intermediate, Projects, Domain, LearningStyle, Platform, ProjectType, Paradigm, CommunitySupport, IndustryDemand, Language),
    write("Based on your preferences, I recommend the following programming language: "), write(Language), nl,
    write("Happy coding!").

inquire_experience_level(advanced) :-
    inquire_projects(advanced, Projects),
    inquire_domain(Domain),
    inquire_learning_style(LearningStyle),
    inquire_platform(Platform),
    inquire_project_type(ProjectType),
    inquire_favourite_paradigm(Paradigm),
    inquire_community_support(CommunitySupport),
    inquire_industry_demand(IndustryDemand),
    recommend(advanced, Projects, Domain, LearningStyle, Platform, ProjectType, Paradigm, CommunitySupport, IndustryDemand, Language),
    write("Based on your preferences, I recommend the following programming language: "), write(Language), nl,
    write("Happy coding!").

% Predicates for determining beginner project preference
inquire_projects(beginner, Projects) :-
    write("Are you planning to work on beginner-friendly projects? (yes/no): "),
    read(ProjectsAnswer),
    determine_beginner_projects(ProjectsAnswer, Projects), nl.

inquire_projects(intermediate, Projects) :-
    write("Do you plan to work on complex software projects? (yes/no): "),
    read(IntermediateProjectsAnswer),
    determine_intermediate_projects(IntermediateProjectsAnswer, Projects), nl.

inquire_projects(advanced, Projects) :-
    write("Are you planning to work on cutting-edge technology projects? (yes/no): "),
    read(AdvancedProjectsAnswer),
    determine_advanced_projects(AdvancedProjectsAnswer, Projects), nl.

determine_beginner_projects(yes, yes).
determine_beginner_projects(no, no).

determine_intermediate_projects(yes, yes).
determine_intermediate_projects(no, no).

determine_advanced_projects(yes, yes).
determine_advanced_projects(no, no).

% Predicate for inquiring the programming domain
inquire_domain(Domain) :-
    write("In which domain do you plan to work? (web development, data science, AI, game development): "),
    read(Domain), nl.

% Predicate for inquiring learning style
inquire_learning_style(LearningStyle) :-
    write("Do you prefer hands-on learning or theoretical study? (hands-on, theoretical): "),
    read(LearningStyle), nl.

% Predicate for inquiring preferred platform
inquire_platform(Platform) :-
    write("Which platform or operating system will you primarily use? (Windows, macOS, Linux): "),
    read(Platform), nl.

% Predicate for inquiring project type
inquire_project_type(ProjectType) :-
    write("What type of project do you plan to work on? (mobile app, web app, desktop app, data analysis, game): "),
    read(ProjectType), nl.

% Predicate for inquiring favorite programming paradigm
inquire_favourite_paradigm(Paradigm) :-
    write("Do you have a favorite programming paradigm? (procedural, object-oriented, functional): "),
    read(Paradigm), nl.

% Predicate for inquiring importance of community support
inquire_community_support(CommunitySupport) :-
    write("How important is a strong programming community for you? (not important, somewhat important, very important): "),
    read(CommunitySupport), nl.

% Predicate for inquiring importance of industry demand
inquire_industry_demand(IndustryDemand) :-
    write("How important is the demand for the language in the industry? (not important, somewhat important, very important): "),
    read(IndustryDemand), nl.

% Recommendations for beginners
recommend(beginner, Projects, _, LearningStyle, Platform, ProjectType, Paradigm, CommunitySupport, IndustryDemand, Language) :-
    (
        Projects = yes,
        Language = 'Python'
    ;
        Projects = no,
        Language = 'JavaScript'
    ;
        LearningStyle = hands-on,
        Language = 'JavaScript'
    ;
        LearningStyle = theoretical,
        Language = 'Python'
    ;
        Platform = 'Windows',
        Language = 'C#'
    ;
        Platform = 'macOS',
        Language = 'Swift'
    ;
        Platform = 'Linux',
        Language = 'C++'
    ;
        ProjectType = 'mobile app',
        Language = 'Java'
    ;
        ProjectType = 'web app',
        Language = 'JavaScript'
    ;
        ProjectType = 'desktop app',
        Language = 'C#'
    ;
        ProjectType = 'data analysis',
        Language = 'Python'
    ;
        ProjectType = 'game',
        Language = 'C#'
    ;
        Paradigm = 'procedural',
        Language = 'C'
    ;
        Paradigm = 'object-oriented',
        Language = 'Java'
    ;
        Paradigm = 'functional',
        Language = 'Haskell'
    ;
        CommunitySupport = 'not important',
        Language = 'Rust'
    ;
        CommunitySupport = 'somewhat important',
        Language = 'Ruby'
    ;
        CommunitySupport = 'very important',
        Language = 'JavaScript'
    ;
        IndustryDemand = 'not important',
        Language = 'Elixir'
    ;
        IndustryDemand = 'somewhat important',
        Language = 'Go'
    ;
        IndustryDemand = 'very important',
        Language = 'Python'
    ;
        Language = 'Python'
    ).

% Recommendations for intermediate
recommend(intermediate, Projects, Domain, LearningStyle, Platform, ProjectType, Paradigm, CommunitySupport, IndustryDemand, Language) :-
    (
        Projects = yes,
        Language = 'Java'
    ;
        Projects = no,
        Language = 'C#'
    ;
        LearningStyle = hands-on,
        Language = 'C++'
    ;
        LearningStyle = theoretical,
        Language = 'Python'
    ;
        Platform = 'Windows',
        Language = 'C#'
    ;
        Platform = 'macOS',
        Language = 'Swift'
    ;
        Platform = 'Linux',
        Language = 'C++'
    ;
        ProjectType = 'mobile app',
        Language = 'Java'
    ;
        ProjectType = 'web app',
        Language = 'JavaScript'
    ;
        ProjectType = 'desktop app',
        Language = 'C#'
    ;
        ProjectType = 'data analysis',
        Language = 'Python'
    ;
        ProjectType = 'game',
        Language = 'C#'
    ;
        Paradigm = 'procedural',
        Language = 'C'
    ;
        Paradigm = 'object-oriented',
        Language = 'Java'
    ;
        Paradigm = 'functional',
        Language = 'Haskell'
    ;
        CommunitySupport = 'not important',
        Language = 'Rust'
    ;
        CommunitySupport = 'somewhat important',
        Language = 'Ruby'
    ;
        CommunitySupport = 'very important',
        Language = 'JavaScript'
    ;
        IndustryDemand = 'not important',
        Language = 'Elixir'
    ;
        IndustryDemand = 'somewhat important',
        Language = 'Go'
    ;
        IndustryDemand = 'very important',
        Language = 'Python'
    ;
        Language = 'Java'
    ).

% Recommendations for advanced
recommend(advanced, Projects, Domain, LearningStyle, Platform, ProjectType, Paradigm, CommunitySupport, IndustryDemand, Language) :-
    (
        Projects = yes,
        Language = 'C++'
    ;
        Projects = no,
        Language = 'Python'
    ;
        LearningStyle = hands-on,
        Language = 'C#'
    ;
        LearningStyle = theoretical,
        Language = 'Java'
    ;
        Platform = 'Windows',
        Language = 'C#'
    ;
        Platform = 'macOS',
        Language = 'Swift'
    ;
        Platform = 'Linux',
        Language = 'C++'
    ;
        ProjectType = 'mobile app',
        Language = 'Kotlin'
    ;
        ProjectType = 'web app',
        Language = 'JavaScript'
    ;
        ProjectType = 'desktop app',
        Language = 'C#'
    ;
        ProjectType = 'data analysis',
        Language = 'Python'
    ;
        ProjectType = 'game',
        Language = 'C#'
    ;
        Paradigm = 'procedural',
        Language = 'C'
    ;
        Paradigm = 'object-oriented',
        Language = 'Java'
    ;
        Paradigm = 'functional',
        Language = 'Haskell'
    ;
        CommunitySupport = 'not important',
        Language = 'Rust'
    ;
        CommunitySupport = 'somewhat important',
        Language = 'Ruby'
    ;
        CommunitySupport = 'very important',
        Language = 'JavaScript'
    ;
        IndustryDemand = 'not important',
        Language = 'Elixir'
    ;
        IndustryDemand = 'somewhat important',
        Language = 'Go'
    ;
        IndustryDemand = 'very important',
        Language = 'Python'
    ;
        Language = 'C++'
    ).

% Predicates for other experience levels...
% Define recommendations and predicates for other experience levels as needed...

% Predicates for asking yes/no questions
ask(Q) :-
    write("Do you prioritize this feature? "),
    write(Q), write('? (yes/no) '),
    read(Answer),
    ((Answer == yes; Answer == y) -> assert(yes(Q)); assert(no(Q))), nl.

% Dynamic predicates for user responses
:- dynamic yes/1, no/1.

% Predicate to undo stored responses
undo :- retractall(yes(_)), retractall(no(_)).



