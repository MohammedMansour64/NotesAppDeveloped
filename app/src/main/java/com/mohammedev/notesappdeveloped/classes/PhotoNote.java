package com.mohammedev.notesappdeveloped.classes;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.Entity;

@Entity(tableName = "photoNotesTable")
public class PhotoNote extends Note implements Parcelable {
    public long NoteId;
    private Uri image;


    public PhotoNote(int noteColor, String note, Uri image) {
        super(noteColor, note);
        this.image = image;
    }

    public PhotoNote(Uri image){
        this.image = image;
    }


    protected PhotoNote(Parcel in) {
        note = in.readString();
        color = in.readInt();
        image = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<PhotoNote> CREATOR = new Creator<PhotoNote>() {
        @Override
        public PhotoNote createFromParcel(Parcel in) {
            return new PhotoNote(in);
        }

        @Override
        public PhotoNote[] newArray(int size) {
            return new PhotoNote[size];
        }
    };

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(note);
        parcel.writeInt(color);
        parcel.writeParcelable(image, i);
    }

    @BindingAdapter("android:imageUri")
    public static void loadImage(ImageView imageView, Uri image){
        imageView.setImageURI(image);
    }

}
