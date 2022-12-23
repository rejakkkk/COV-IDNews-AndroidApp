package com.example.cov_idnews.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Berita implements Parcelable {
    private String id;
    private String judul;
    private String penulis;
    private String isiBerita;
    private String tanggal;
    private String idKategori;

//    private byte[] image;

    public Berita() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsiBerita() {
        return isiBerita;
    }

    public void setIsiBerita(String isiBerita) {
        this.isiBerita = isiBerita;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
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
        dest.writeString(this.judul);
        dest.writeString(this.isiBerita);
    }


    protected Berita(Parcel in) {
        this.id = in.readString();
        this.judul = in.readString();
        this.isiBerita = in.readString();
//        image = new byte[in.readInt()];
//        in.readByteArray(image); // this will read the byte array from Parcel object(in) and store the value in mImage member variable.
//        id = in.readString();

    }

    public static final Parcelable.Creator<Berita> CREATOR = new Parcelable.Creator<Berita>() {
        @Override
        public Berita createFromParcel(Parcel source) {
            return new Berita(source);
        }

        @Override
        public Berita[] newArray(int size) {
            return new Berita[size];
        }
    };



}

