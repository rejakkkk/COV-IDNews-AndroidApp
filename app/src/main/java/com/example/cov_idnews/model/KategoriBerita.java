package com.example.cov_idnews.model;

import android.os.Parcel;
import android.os.Parcelable;

public class KategoriBerita implements Parcelable {
    private String id;
    private String kasus;
    private String penanganan;
    private String teknologi;
//    private byte[] image;

    public KategoriBerita() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKasus() {
        return kasus;
    }

    public void setKasus(String kasus) {
        this.kasus = kasus;
    }

    public String getPenanganan() {
        return penanganan;
    }

    public void setPenanganan(String penanganan) {
        this.penanganan = penanganan;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        if(image != null) {
//            dest.writeInt(image.length);
//            dest.writeByteArray(image);
//        }
        dest.writeString(this.id);
        dest.writeString(this.kasus);
        dest.writeString(this.penanganan);
    }


    protected KategoriBerita(Parcel in) {
        this.id = in.readString();
        this.kasus = in.readString();
        this.penanganan = in.readString();
//        image = new byte[in.readInt()];
//        in.readByteArray(image); // this will read the byte array from Parcel object(in) and store the value in mImage member variable.
//        id = in.readString();

    }

    public static final Parcelable.Creator<KategoriBerita> CREATOR = new Parcelable.Creator<KategoriBerita>() {
        @Override
        public KategoriBerita createFromParcel(Parcel source) {
            return new KategoriBerita(source);
        }

        @Override
        public KategoriBerita[] newArray(int size) {
            return new KategoriBerita[size];
        }
    };
}

