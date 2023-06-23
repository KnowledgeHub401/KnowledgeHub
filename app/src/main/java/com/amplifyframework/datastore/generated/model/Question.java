package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Question type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Questions", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Question implements Model {
  public static final QueryField ID = field("Question", "id");
  public static final QueryField CATEGORY = field("Question", "category");
  public static final QueryField TYPE = field("Question", "type");
  public static final QueryField DIFFICULTY = field("Question", "difficulty");
  public static final QueryField QUESTION = field("Question", "question");
  public static final QueryField CORRECT_ANSWER = field("Question", "correct_answer");
  public static final QueryField INCORRECT_ANSWERS = field("Question", "incorrect_answers");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="CategoryEnum") CategoryEnum category;
  private final @ModelField(targetType="String") String type;
  private final @ModelField(targetType="DifficultyEnum") DifficultyEnum difficulty;
  private final @ModelField(targetType="String") String question;
  private final @ModelField(targetType="String") String correct_answer;
  private final @ModelField(targetType="String") List<String> incorrect_answers;
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
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Question(String id, CategoryEnum category, String type, DifficultyEnum difficulty, String question, String correct_answer, List<String> incorrect_answers) {
    this.id = id;
    this.category = category;
    this.type = type;
    this.difficulty = difficulty;
    this.question = question;
    this.correct_answer = correct_answer;
    this.incorrect_answers = incorrect_answers;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Question question = (Question) obj;
      return ObjectsCompat.equals(getId(), question.getId()) &&
              ObjectsCompat.equals(getCategory(), question.getCategory()) &&
              ObjectsCompat.equals(getType(), question.getType()) &&
              ObjectsCompat.equals(getDifficulty(), question.getDifficulty()) &&
              ObjectsCompat.equals(getQuestion(), question.getQuestion()) &&
              ObjectsCompat.equals(getCorrectAnswer(), question.getCorrectAnswer()) &&
              ObjectsCompat.equals(getIncorrectAnswers(), question.getIncorrectAnswers()) &&
              ObjectsCompat.equals(getCreatedAt(), question.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), question.getUpdatedAt());
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
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Question {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("category=" + String.valueOf(getCategory()) + ", ")
      .append("type=" + String.valueOf(getType()) + ", ")
      .append("difficulty=" + String.valueOf(getDifficulty()) + ", ")
      .append("question=" + String.valueOf(getQuestion()) + ", ")
      .append("correct_answer=" + String.valueOf(getCorrectAnswer()) + ", ")
      .append("incorrect_answers=" + String.valueOf(getIncorrectAnswers()) + ", ")
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
  public static Question justId(String id) {
    return new Question(
      id,
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
      incorrect_answers);
  }
  public interface BuildStep {
    Question build();
    BuildStep id(String id);
    BuildStep category(CategoryEnum category);
    BuildStep type(String type);
    BuildStep difficulty(DifficultyEnum difficulty);
    BuildStep question(String question);
    BuildStep correctAnswer(String correctAnswer);
    BuildStep incorrectAnswers(List<String> incorrectAnswers);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private CategoryEnum category;
    private String type;
    private DifficultyEnum difficulty;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;
    @Override
     public Question build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Question(
          id,
          category,
          type,
          difficulty,
          question,
          correct_answer,
          incorrect_answers);
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
    private CopyOfBuilder(String id, CategoryEnum category, String type, DifficultyEnum difficulty, String question, String correctAnswer, List<String> incorrectAnswers) {
      super.id(id);
      super.category(category)
        .type(type)
        .difficulty(difficulty)
        .question(question)
        .correctAnswer(correctAnswer)
        .incorrectAnswers(incorrectAnswers);
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
  }
  
}
