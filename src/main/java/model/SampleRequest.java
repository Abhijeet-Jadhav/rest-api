package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.Path;

/**
 * Created by root on 1/12/17.
 */

public class SampleRequest {
    @NotNull
    @NotEmpty
    String firstName;

    @NotNull
    @NotEmpty
    String lastName;

    /*@NotNull
    @NotEmpty
    Integer age;*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/
}
