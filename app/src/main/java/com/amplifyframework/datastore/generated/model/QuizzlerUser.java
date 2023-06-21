package com.amplifyframework.datastore.generated.model;

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

/** This is an auto generated class representing the QuizzlerUser type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "QuizzlerUsers", type = Model.Type.USER, version = 1)
public final class QuizzlerUser implements Model {
  public static final QueryField ID = field("QuizzlerUser", "id");
  public static final QueryField USERNAME = field("QuizzlerUser", "username");
  public static final QueryField PASSWORD = field("QuizzlerUser", "password");
  public static final QueryField NAME = field("QuizzlerUser", "name");
  public static final QueryField EMAIL = field("QuizzlerUser", "email");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String username;
  private final @ModelField(targetType="String", isRequired = true) String password;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String", isRequired = true) String email;
  private final @ModelField(targetType="Quiz") @HasMany(associatedWith = "user", type = Quiz.class) List<Quiz> quizzes = null;
  private final @ModelField(targetType="Question") @HasMany(associatedWith = "user", type = Question.class) List<Question> history = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getUsername() {
      return username;
  }
  
  public String getPassword() {
      return password;
  }
  
  public String getName() {
      return name;
  }
  
  public String getEmail() {
      return email;
  }
  
  public List<Quiz> getQuizzes() {
      return quizzes;
  }
  
  public List<Question> getHistory() {
      return history;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private QuizzlerUser(String id, String username, String password, String name, String email) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.email = email;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QuizzlerUser quizzlerUser = (QuizzlerUser) obj;
      return ObjectsCompat.equals(getId(), quizzlerUser.getId()) &&
              ObjectsCompat.equals(getUsername(), quizzlerUser.getUsername()) &&
              ObjectsCompat.equals(getPassword(), quizzlerUser.getPassword()) &&
              ObjectsCompat.equals(getName(), quizzlerUser.getName()) &&
              ObjectsCompat.equals(getEmail(), quizzlerUser.getEmail()) &&
              ObjectsCompat.equals(getCreatedAt(), quizzlerUser.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), quizzlerUser.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUsername())
      .append(getPassword())
      .append(getName())
      .append(getEmail())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("QuizzlerUser {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("username=" + String.valueOf(getUsername()) + ", ")
      .append("password=" + String.valueOf(getPassword()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static UsernameStep builder() {
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
  public static QuizzlerUser justId(String id) {
    return new QuizzlerUser(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      username,
      password,
      name,
      email);
  }
  public interface UsernameStep {
    PasswordStep username(String username);
  }
  

  public interface PasswordStep {
    NameStep password(String password);
  }
  

  public interface NameStep {
    EmailStep name(String name);
  }
  

  public interface EmailStep {
    BuildStep email(String email);
  }
  

  public interface BuildStep {
    QuizzlerUser build();
    BuildStep id(String id);
  }
  

  public static class Builder implements UsernameStep, PasswordStep, NameStep, EmailStep, BuildStep {
    private String id;
    private String username;
    private String password;
    private String name;
    private String email;
    @Override
     public QuizzlerUser build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new QuizzlerUser(
          id,
          username,
          password,
          name,
          email);
    }
    
    @Override
     public PasswordStep username(String username) {
        Objects.requireNonNull(username);
        this.username = username;
        return this;
    }
    
    @Override
     public NameStep password(String password) {
        Objects.requireNonNull(password);
        this.password = password;
        return this;
    }
    
    @Override
     public EmailStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep email(String email) {
        Objects.requireNonNull(email);
        this.email = email;
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
    private CopyOfBuilder(String id, String username, String password, String name, String email) {
      super.id(id);
      super.username(username)
        .password(password)
        .name(name)
        .email(email);
    }
    
    @Override
     public CopyOfBuilder username(String username) {
      return (CopyOfBuilder) super.username(username);
    }
    
    @Override
     public CopyOfBuilder password(String password) {
      return (CopyOfBuilder) super.password(password);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
  }
  
}
