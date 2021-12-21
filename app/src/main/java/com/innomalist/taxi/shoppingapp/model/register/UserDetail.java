package com.innomalist.taxi.shoppingapp.model.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDetail {
    @SerializedName("cusAddress1")
    @Expose
    private String cusAddress1;
    @SerializedName("cusAddress2")
    @Expose
    private String cusAddress2;
    @SerializedName("cusCityId")
    @Expose
    private String cusCityId;
    @SerializedName("cusCityName")
    @Expose
    private String cusCityName;
    @SerializedName("cusCountryId")
    @Expose
    private String cusCountryId;
    @SerializedName("cusCountryName")
    @Expose
    private String cusCountryName;
    @SerializedName("cusEmail")
    @Expose
    private String cusEmail;
    @SerializedName("cusId")
    @Expose
    private Integer cusId;
    @SerializedName("cusImage")
    @Expose
    private String cusImage;
    @SerializedName("cusJoindate")
    @Expose
    private String cusJoindate;
    @SerializedName("cusLogintype")
    @Expose
    private Integer cusLogintype;
    @SerializedName("cusName")
    @Expose
    private String cusName;
    @SerializedName("cusPhone")
    @Expose
    private String cusPhone;
    @SerializedName("cusStatus")
    @Expose
    private Integer cusStatus;

    public Integer getCusId() {
        return this.cusId;
    }

    public void setCusId(Integer num) {
        this.cusId = num;
    }

    public String getCusName() {
        return this.cusName;
    }

    public void setCusName(String str) {
        this.cusName = str;
    }

    public String getCusEmail() {
        return this.cusEmail;
    }

    public void setCusEmail(String str) {
        this.cusEmail = str;
    }

    public String getCusPhone() {
        return this.cusPhone;
    }

    public void setCusPhone(String str) {
        this.cusPhone = str;
    }

    public String getCusAddress1() {
        return this.cusAddress1;
    }

    public void setCusAddress1(String str) {
        this.cusAddress1 = str;
    }

    public String getCusAddress2() {
        return this.cusAddress2;
    }

    public void setCusAddress2(String str) {
        this.cusAddress2 = str;
    }

    public String getCusCountryId() {
        return this.cusCountryId;
    }

    public void setCusCountryId(String str) {
        this.cusCountryId = str;
    }

    public String getCusCountryName() {
        return this.cusCountryName;
    }

    public void setCusCountryName(String str) {
        this.cusCountryName = str;
    }

    public String getCusCityId() {
        return this.cusCityId;
    }

    public void setCusCityId(String str) {
        this.cusCityId = str;
    }

    public String getCusCityName() {
        return this.cusCityName;
    }

    public void setCusCityName(String str) {
        this.cusCityName = str;
    }

    public String getCusImage() {
        return this.cusImage;
    }

    public void setCusImage(String str) {
        this.cusImage = str;
    }

    public String getCusJoindate() {
        return this.cusJoindate;
    }

    public void setCusJoindate(String str) {
        this.cusJoindate = str;
    }

    public Integer getCusLogintype() {
        return this.cusLogintype;
    }

    public void setCusLogintype(Integer num) {
        this.cusLogintype = num;
    }

    public Integer getCusStatus() {
        return this.cusStatus;
    }

    public void setCusStatus(Integer num) {
        this.cusStatus = num;
    }
}
