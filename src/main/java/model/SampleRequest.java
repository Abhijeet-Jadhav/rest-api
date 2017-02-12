package model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by root on 1/12/17.
 */

public class SampleRequest {
    //@NotNull(message = "{firstName cannot be empty}")
    @NotNull
    private String firstName;

    //@NotNull(message = "{lastName cannot be empty}")
    @NotNull
    private String lastName;

    @Valid
    @NotNull
    private SampleRequest2 sampleRequest2;

    /*@NotNull
    @NotEmpty
    Integer age;*/

    //@ValidateOnExecution
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@ValidateOnExecution
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SampleRequest2 getSampleRequest2() {
        return sampleRequest2;
    }

    public void setSampleRequest2(SampleRequest2 sampleRequest2) {
        this.sampleRequest2 = sampleRequest2;
    }

    /*public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/
}
