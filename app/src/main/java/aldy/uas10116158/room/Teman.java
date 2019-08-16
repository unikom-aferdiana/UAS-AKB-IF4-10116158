/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 15/08/19 18:11
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 15/08/19 16:52
 */

package aldy.uas10116158.room;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Teman implements Parcelable {

    public static final Parcelable.Creator<Teman> CREATOR = new Parcelable.Creator<Teman>() {
        @Override
        public Teman createFromParcel(Parcel source) {
            return new Teman(source);
        }

        @Override
        public Teman[] newArray(int size) {
            return new Teman[size];
        }
    };
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nim")
    private String nim;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "kelas")
    private String kelas;
    @ColumnInfo(name = "telepon")
    private String telepon;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "social")
    private String social;

    public Teman() {
    }

    protected Teman(Parcel in) {
        this.nim = in.readString();
        this.nama = in.readString();
        this.kelas = in.readString();
        this.telepon = in.readString();
        this.email = in.readString();
        this.social = in.readString();
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nim);
        dest.writeString(this.nama);
        dest.writeString(this.kelas);
        dest.writeString(this.telepon);
        dest.writeString(this.email);
        dest.writeString(this.social);
    }
}
