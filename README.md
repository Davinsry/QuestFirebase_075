# 🔥 Panduan Lengkap Setup Firebase Firestore untuk Android

Panduan ini berisi langkah-langkah menghubungkan project Android Studio dengan Firebase Firestore Database dari nol.

---

## 🚀 Langkah 1: Buat Project di Firebase Console

1. Buka [console.firebase.google.com](https://console.firebase.google.com/).
2. Klik **+ Create a project**.
3. Beri nama project (misal: `LatihanFirestore`), lalu klik **Continue**.
4. Matikan *Google Analytics* (agar lebih cepat), lalu klik **Create Project**.

![Tampilan Dashboard Firebase](path/ke/gambar-1.png)

---

## 📱 Langkah 2: Daftarkan Aplikasi Android

1. Di dashboard project, klik ikon **Android** (🤖).
2. Isi **Package Name** wajib sama persis dengan yang ada di `build.gradle.kts` (Module: app) di Android Studio.
   * Contoh: `com.davin.questfirebase_075`
3. Klik **Register App**.
4. Download file **`google-services.json`**.

### 📂 Pemasangan File Config
Pindahkan file `google-services.json` ke dalam folder `app` di project Android Studio kamu.

![Posisi file google-services.json di Android Studio](path/ke/gambar-2.png)

---

## 🗄️ Langkah 3: Aktivasi Firestore Database

Agar aplikasi tidak error `PERMISSION_DENIED`, database harus diaktifkan dulu.

1. Di menu kiri Firebase Console, pilih **Build** > **Firestore Database**.
2. Klik **Create Database**.
3. Pilih lokasi server (default saja), lalu klik **Next**.
4. Pilih **Start in Test Mode** (supaya bisa langsung baca/tulis data).
5. Klik **Create**.

### ⚠️ Penting: Update Rules
Jika masih gagal menyimpan data, cek tab **Rules** dan pastikan kodenya seperti ini:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true;
    }
  }
}


```

<img width="1918" height="938" alt="image" src="https://github.com/user-attachments/assets/3f07bff3-d706-4cab-a458-d644f96a9a22" />
<img width="617" height="826" alt="image" src="https://github.com/user-attachments/assets/5ca2ce59-f1ef-4405-93d2-cfe02ae0f742" />




