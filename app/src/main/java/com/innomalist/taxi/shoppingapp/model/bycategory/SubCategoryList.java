package com.innomalist.taxi.shoppingapp.model.bycategory;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SubCategoryList implements Parcelable {
    public static final Parcelable.Creator<SubCategoryList> CREATOR = new Parcelable.Creator<SubCategoryList>() {
        public SubCategoryList createFromParcel(Parcel parcel) {
            return new SubCategoryList(parcel);
        }

        public SubCategoryList[] newArray(int i) {
            return new SubCategoryList[i];
        }
    };
    @SerializedName("secSubMainCategoryId")
    @Expose
    private Integer secSubMainCategoryId;
    @SerializedName("subCategoryId")
    @Expose
    private Integer subCategoryId;
    @SerializedName("subCategoryImage")
    @Expose
    private String subCategoryImage;
    @SerializedName("subCategoryName")
    @Expose
    private String subCategoryName;
    @SerializedName("subCategoryStatus")
    @Expose
    private Integer subCategoryStatus;
    @SerializedName("subMainCategoryId")
    @Expose
    private Integer subMainCategoryId;
    @SerializedName("subSecCategoryList")
    @Expose
    private List<SubCategoryList> subSecCategoryList = null;

    public int describeContents() {
        return 0;
    }

    protected SubCategoryList(Parcel parcel) {
        if (parcel.readByte() == 0) {
            this.subCategoryId = null;
        } else {
            this.subCategoryId = Integer.valueOf(parcel.readInt());
        }
        this.subCategoryName = parcel.readString();
        this.subCategoryImage = parcel.readString();
        if (parcel.readByte() == 0) {
            this.subMainCategoryId = null;
        } else {
            this.subMainCategoryId = Integer.valueOf(parcel.readInt());
        }
        if (parcel.readByte() == 0) {
            this.secSubMainCategoryId = null;
        } else {
            this.secSubMainCategoryId = Integer.valueOf(parcel.readInt());
        }
        if (parcel.readByte() == 0) {
            this.subCategoryStatus = null;
        } else {
            this.subCategoryStatus = Integer.valueOf(parcel.readInt());
        }
    }

    public Integer getSubCategoryId() {
        return this.subCategoryId;
    }

    public void setSubCategoryId(Integer num) {
        this.subCategoryId = num;
    }

    public String getSubCategoryName() {
        return this.subCategoryName;
    }

    public void setSubCategoryName(String str) {
        this.subCategoryName = str;
    }

    public String getSubCategoryImage() {
        return this.subCategoryImage;
    }

    public void setSubCategoryImage(String str) {
        this.subCategoryImage = str;
    }

    public Integer getSubMainCategoryId() {
        return this.subMainCategoryId;
    }

    public void setSubMainCategoryId(Integer num) {
        this.subMainCategoryId = num;
    }

    public Integer getSecSubMainCategoryId() {
        return this.secSubMainCategoryId;
    }

    public void setSecSubMainCategoryId(Integer num) {
        this.secSubMainCategoryId = num;
    }

    public Integer getSubCategoryStatus() {
        return this.subCategoryStatus;
    }

    public void setSubCategoryStatus(Integer num) {
        this.subCategoryStatus = num;
    }

    public List<SubCategoryList> getSubSecCategoryList() {
        return this.subSecCategoryList;
    }

    public void setSubSecCategoryList(List<SubCategoryList> list) {
        this.subSecCategoryList = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.subCategoryId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.subCategoryId.intValue());
        }
        parcel.writeString(this.subCategoryName);
        parcel.writeString(this.subCategoryImage);
        if (this.subMainCategoryId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.subMainCategoryId.intValue());
        }
        if (this.secSubMainCategoryId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.secSubMainCategoryId.intValue());
        }
        if (this.subCategoryStatus == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(this.subCategoryStatus.intValue());
    }
}
