package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by root on 2/11/17.
 */
public class SampleRequest2 {

    @NotNull
    private String xyz ;

    @NotNull
    private String def ;

    @NotNull
    private Integer qwe;

    public String getXyz() {
        return xyz;
    }

    public void setXyz(String xyz) {
        this.xyz = xyz;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public int getQwe() {
        return qwe;
    }

    public void setQwe(int qwe) {
        this.qwe = qwe;
    }
}
