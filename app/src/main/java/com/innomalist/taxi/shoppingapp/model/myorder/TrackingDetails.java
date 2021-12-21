package com.innomalist.taxi.shoppingapp.model.myorder;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackingDetails implements Parcelable {
    public static final Parcelable.Creator<TrackingDetails> CREATOR = new Parcelable.Creator<TrackingDetails>() {
        public TrackingDetails createFromParcel(Parcel parcel) {
            return new TrackingDetails(parcel);
        }

        public TrackingDetails[] newArray(int i) {
            return new TrackingDetails[i];
        }
    };
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("title")
    @Expose
    private String title;

    public int describeContents() {
        return 0;
    }

    protected TrackingDetails(Parcel parcel) {
        Boolean bool;
        this.title = parcel.readString();
        byte readByte = parcel.readByte();
        if (readByte == 0) {
            bool = null;
        } else {
            bool = Boolean.valueOf(readByte != 1 ? false : true);
        }
        this.status = bool;
        this.time = parcel.readString();
        this.desc = parcel.readString();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean bool) {
        this.status = bool;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        Boolean bool = this.status;
        parcel.writeByte((byte) (bool == null ? 0 : bool.booleanValue() ? 1 : 2));
        parcel.writeString(this.time);
        parcel.writeString(this.desc);
    }
}
