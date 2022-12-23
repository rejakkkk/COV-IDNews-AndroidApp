package com.example.cov_idnews.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class RumahSakit implements Parcelable {
    private String id;
    private String nama;
    private String alamat;
    private String kontak;
//    private byte[] image;

    public RumahSakit() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
    }


    protected RumahSakit(Parcel in) {
        this.id = in.readString();
        this.nama = in.readString();
        this.alamat = in.readString();
//        image = new byte[in.readInt()];
//        in.readByteArray(image); // this will read the byte array from Parcel object(in) and store the value in mImage member variable.
//        id = in.readString();

    }

    public static final Parcelable.Creator<RumahSakit> CREATOR = new Parcelable.Creator<RumahSakit>() {
        @Override
        public RumahSakit createFromParcel(Parcel source) {
            return new RumahSakit(source);
        }

        @Override
        public RumahSakit[] newArray(int size) {
            return new RumahSakit[size];
        }
    };
}

