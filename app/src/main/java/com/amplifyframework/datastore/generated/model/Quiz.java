package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.annotations.HasMany;
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

/** This is an auto generated class representing the Quiz type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Quizzes", type = Model.Type.USER, version = 1)
@Index(name = "byUser", fields = {"userID"})
public final class Quiz implements Model {
  public static final QueryField ID = field("Quiz", "id");
  public static final QueryField NUMBER_QUESTIONS = field("Quiz", "numberQuestions");
  public static final QueryField DIFFICULTY = field("Quiz", "difficulty");
  public static final QueryField CATEGORY = field("Quiz", "category");
  public static final QueryField USER = field("Quiz", "userID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Int") Integer numberQuestions;
  private final @ModelField(targetType="DifficultyEnum") DifficultyEnum difficulty;
  private final @ModelField(targetType="CategoryEnum") CategoryEnum category;
  private final @ModelField(targetType="QuizzlerUser") @BelongsTo(targetName = "userID", targetNames = {"userID"}, type = QuizzlerUser.class) QuizzlerUser user;
  private final @ModelField(targetType="UserQuestion") @HasMany(associatedWith = "quiz", type = UserQuestion.class) List<UserQuestion> questions = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public Integer getNumberQuestions() {
      return numberQuestions;
  }
  
  public DifficultyEnum getDifficulty() {
      return difficulty;
  }
  
  public CategoryEnum getCategory() {
      return category;
  }
  
  public QuizzlerUser getUser() {
      return user;
  }
  
  public List<UserQuestion> getQuestions() {
      return questions;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Quiz(String id, Integer numberQuestions, DifficultyEnum difficulty, CategoryEnum category, QuizzlerUser user) {
    this.id = id;
    this.numberQuestions = numberQuestions;
    this.difficulty = difficulty;
    this.category = category;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Quiz quiz = (Quiz) obj;
      return ObjectsCompat.equals(getId(), quiz.getId()) &&
              ObjectsCompat.equals(getNumberQuestions(), quiz.getNumberQuestions()) &&
              ObjectsCompat.equals(getDifficulty(), quiz.getDifficulty()) &&
              ObjectsCompat.equals(getCategory(), quiz.getCategory()) &&
              ObjectsCompat.equals(getUser(), quiz.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), quiz.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), quiz.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getNumberQuestions())
      .append(getDifficulty())
      .append(getCategory())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Quiz {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("numberQuestions=" + String.valueOf(getNumberQuestions()) + ", ")
      .append("difficulty=" + String.valueOf(getDifficulty()) + ", ")
      .append("category=" + String.valueOf(getCategory()) + ", ")
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
  public static Quiz justId(String id) {
    return new Quiz(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      numberQuestions,
      difficulty,
      category,
      user);
  }
  public interface BuildStep {
    Quiz build();
    BuildStep id(String id);
    BuildStep numberQuestions(Integer numberQuestions);
    BuildStep difficulty(DifficultyEnum difficulty);
    BuildStep category(CategoryEnum category);
    BuildStep user(QuizzlerUser user);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private Integer numberQuestions;
    private DifficultyEnum difficulty;
    private CategoryEnum category;
    private QuizzlerUser user;
    @Override
     public Quiz build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Quiz(
          id,
          numberQuestions,
          difficulty,
          category,
          user);
    }
    
    @Override
     public BuildStep numberQuestions(Integer numberQuestions) {
        this.numberQuestions = numberQuestions;
        return this;
    }
    
    @Override
     public BuildStep difficulty(DifficultyEnum difficulty) {
        this.difficulty = difficulty;
        return this;
    }
    
    @Override
     public BuildStep category(CategoryEnum category) {
        this.category = category;
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
    private CopyOfBuilder(String id, Integer numberQuestions, DifficultyEnum difficulty, CategoryEnum category, QuizzlerUser user) {
      super.id(id);
      super.numberQuestions(numberQuestions)
        .difficulty(difficulty)
        .category(category)
        .user(user);
    }
    
    @Override
     public CopyOfBuilder numberQuestions(Integer numberQuestions) {
      return (CopyOfBuilder) super.numberQuestions(numberQuestions);
    }
    
    @Override
     public CopyOfBuilder difficulty(DifficultyEnum difficulty) {
      return (CopyOfBuilder) super.difficulty(difficulty);
    }
    
    @Override
     public CopyOfBuilder category(CategoryEnum category) {
      return (CopyOfBuilder) super.category(category);
    }
    
    @Override
     public CopyOfBuilder user(QuizzlerUser user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  
}
