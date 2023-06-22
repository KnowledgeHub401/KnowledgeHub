package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the UserQuestion type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "UserQuestions", type = Model.Type.USER, version = 1)
@Index(name = "byQuiz", fields = {"quizID"})
@Index(name = "byUser", fields = {"userID"})
public final class UserQuestion implements Model {
  public static final QueryField ID = field("UserQuestion", "id");
  public static final QueryField CATEGORY = field("UserQuestion", "category");
  public static final QueryField TYPE = field("UserQuestion", "type");
  public static final QueryField DIFFICULTY = field("UserQuestion", "difficulty");
  public static final QueryField QUESTION = field("UserQuestion", "question");
  public static final QueryField CORRECT_ANSWER = field("UserQuestion", "correct_answer");
  public static final QueryField INCORRECT_ANSWERS = field("UserQuestion", "incorrect_answers");
  public static final QueryField ANSWERED_CORRECTLY = field("UserQuestion", "answeredCorrectly");
  public static final QueryField QUIZ = field("UserQuestion", "quizID");
  public static final QueryField USER = field("UserQuestion", "userID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="CategoryEnum") CategoryEnum category;
  private final @ModelField(targetType="String") String type;
  private final @ModelField(targetType="DifficultyEnum") DifficultyEnum difficulty;
  private final @ModelField(targetType="String") String question;
  public final @ModelField(targetType="String") String correct_answer;
  private final @ModelField(targetType="String") List<String> incorrect_answers;
  public @ModelField(targetType="Boolean") Boolean answeredCorrectly;
  private final @ModelField(targetType="Quiz") @BelongsTo(targetName = "quizID", targetNames = {"quizID"}, type = Quiz.class) Quiz quiz;
  private final @ModelField(targetType="QuizzlerUser") @BelongsTo(targetName = "userID", targetNames = {"userID"}, type = QuizzlerUser.class) QuizzlerUser user;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public CategoryEnum getCategory() {
      return category;
  }
  
  public String getType() {
      return type;
  }
  
  public DifficultyEnum getDifficulty() {
      return difficulty;
  }
  
  public String getQuestion() {
      return question;
  }
  
  public String getCorrectAnswer() {
      return correct_answer;
  }
  
  public List<String> getIncorrectAnswers() {
      return incorrect_answers;
  }
  
  public Boolean getAnsweredCorrectly() {
      return answeredCorrectly;
  }
  
  public Quiz getQuiz() {
      return quiz;
  }
  
  public QuizzlerUser getUser() {
      return user;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private UserQuestion(String id, CategoryEnum category, String type, DifficultyEnum difficulty, String question, String correct_answer, List<String> incorrect_answers, Boolean answeredCorrectly, Quiz quiz, QuizzlerUser user) {
    this.id = id;
    this.category = category;
    this.type = type;
    this.difficulty = difficulty;
    this.question = question;
    this.correct_answer = correct_answer;
    this.incorrect_answers = incorrect_answers;
    this.answeredCorrectly = answeredCorrectly;
    this.quiz = quiz;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      UserQuestion userQuestion = (UserQuestion) obj;
      return ObjectsCompat.equals(getId(), userQuestion.getId()) &&
              ObjectsCompat.equals(getCategory(), userQuestion.getCategory()) &&
              ObjectsCompat.equals(getType(), userQuestion.getType()) &&
              ObjectsCompat.equals(getDifficulty(), userQuestion.getDifficulty()) &&
              ObjectsCompat.equals(getQuestion(), userQuestion.getQuestion()) &&
              ObjectsCompat.equals(getCorrectAnswer(), userQuestion.getCorrectAnswer()) &&
              ObjectsCompat.equals(getIncorrectAnswers(), userQuestion.getIncorrectAnswers()) &&
              ObjectsCompat.equals(getAnsweredCorrectly(), userQuestion.getAnsweredCorrectly()) &&
              ObjectsCompat.equals(getQuiz(), userQuestion.getQuiz()) &&
              ObjectsCompat.equals(getUser(), userQuestion.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), userQuestion.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), userQuestion.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCategory())
      .append(getType())
      .append(getDifficulty())
      .append(getQuestion())
      .append(getCorrectAnswer())
      .append(getIncorrectAnswers())
      .append(getAnsweredCorrectly())
      .append(getQuiz())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("UserQuestion {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("category=" + String.valueOf(getCategory()) + ", ")
      .append("type=" + String.valueOf(getType()) + ", ")
      .append("difficulty=" + String.valueOf(getDifficulty()) + ", ")
      .append("question=" + String.valueOf(getQuestion()) + ", ")
      .append("correct_answer=" + String.valueOf(getCorrectAnswer()) + ", ")
      .append("incorrect_answers=" + String.valueOf(getIncorrectAnswers()) + ", ")
      .append("answeredCorrectly=" + String.valueOf(getAnsweredCorrectly()) + ", ")
      .append("quiz=" + String.valueOf(getQuiz()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static UserQuestion justId(String id) {
    return new UserQuestion(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      category,
      type,
      difficulty,
      question,
      correct_answer,
      incorrect_answers,
      answeredCorrectly,
      quiz,
      user);
  }
  public interface BuildStep {
    UserQuestion build();
    BuildStep id(String id);
    BuildStep category(CategoryEnum category);
    BuildStep type(String type);
    BuildStep difficulty(DifficultyEnum difficulty);
    BuildStep question(String question);
    BuildStep correctAnswer(String correctAnswer);
    BuildStep incorrectAnswers(List<String> incorrectAnswers);
    BuildStep answeredCorrectly(Boolean answeredCorrectly);
    BuildStep quiz(Quiz quiz);
    BuildStep user(QuizzlerUser user);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private CategoryEnum category;
    private String type;
    private DifficultyEnum difficulty;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;
    private Boolean answeredCorrectly;
    private Quiz quiz;
    private QuizzlerUser user;
    @Override
     public UserQuestion build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new UserQuestion(
          id,
          category,
          type,
          difficulty,
          question,
          correct_answer,
          incorrect_answers,
          answeredCorrectly,
          quiz,
          user);
    }
    
    @Override
     public BuildStep category(CategoryEnum category) {
        this.category = category;
        return this;
    }
    
    @Override
     public BuildStep type(String type) {
        this.type = type;
        return this;
    }
    
    @Override
     public BuildStep difficulty(DifficultyEnum difficulty) {
        this.difficulty = difficulty;
        return this;
    }
    
    @Override
     public BuildStep question(String question) {
        this.question = question;
        return this;
    }
    
    @Override
     public BuildStep correctAnswer(String correctAnswer) {
        this.correct_answer = correctAnswer;
        return this;
    }
    
    @Override
     public BuildStep incorrectAnswers(List<String> incorrectAnswers) {
        this.incorrect_answers = incorrectAnswers;
        return this;
    }
    
    @Override
     public BuildStep answeredCorrectly(Boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
        return this;
    }
    
    @Override
     public BuildStep quiz(Quiz quiz) {
        this.quiz = quiz;
        return this;
    }
    
    @Override
     public BuildStep user(QuizzlerUser user) {
        this.user = user;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, CategoryEnum category, String type, DifficultyEnum difficulty, String question, String correctAnswer, List<String> incorrectAnswers, Boolean answeredCorrectly, Quiz quiz, QuizzlerUser user) {
      super.id(id);
      super.category(category)
        .type(type)
        .difficulty(difficulty)
        .question(question)
        .correctAnswer(correctAnswer)
        .incorrectAnswers(incorrectAnswers)
        .answeredCorrectly(answeredCorrectly)
        .quiz(quiz)
        .user(user);
    }
    
    @Override
     public CopyOfBuilder category(CategoryEnum category) {
      return (CopyOfBuilder) super.category(category);
    }
    
    @Override
     public CopyOfBuilder type(String type) {
      return (CopyOfBuilder) super.type(type);
    }
    
    @Override
     public CopyOfBuilder difficulty(DifficultyEnum difficulty) {
      return (CopyOfBuilder) super.difficulty(difficulty);
    }
    
    @Override
     public CopyOfBuilder question(String question) {
      return (CopyOfBuilder) super.question(question);
    }
    
    @Override
     public CopyOfBuilder correctAnswer(String correctAnswer) {
      return (CopyOfBuilder) super.correctAnswer(correctAnswer);
    }
    
    @Override
     public CopyOfBuilder incorrectAnswers(List<String> incorrectAnswers) {
      return (CopyOfBuilder) super.incorrectAnswers(incorrectAnswers);
    }
    
    @Override
     public CopyOfBuilder answeredCorrectly(Boolean answeredCorrectly) {
      return (CopyOfBuilder) super.answeredCorrectly(answeredCorrectly);
    }
    
    @Override
     public CopyOfBuilder quiz(Quiz quiz) {
      return (CopyOfBuilder) super.quiz(quiz);
    }
    
    @Override
     public CopyOfBuilder user(QuizzlerUser user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  
}
