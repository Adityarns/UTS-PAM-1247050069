# Matchain - Matcha & Food Ordering Mobile App

Matchain adalah aplikasi Android native berbasis Kotlin yang dirancang dengan antarmuka modern menggunakan konsep **Glassmorphism**, desain *Edge-to-Edge*, serta navigasi antar-halaman yang mulus untuk pemesanan makanan dan minuman bertema matcha.

---

## 🛠 Tech Stack & Arsitektur
- **Bahasa Pemrograman**: Kotlin
- **UI Toolkit**: XML Layouts (`ConstraintLayout`, `RecyclerView`, `CardView`, *Custom Shape Drawables*)
- **Manajemen State / Data**: In-Memory Singleton Repositories (`UserRepository`, `OrderManager`)
- **Desain Sistem**: Frosted Glassmorphism dengan latar belakang gradien hutan hijau dan overlay redup *fullscreen*.

---

## 📱 Daftar Halaman & Alur Aplikasi (Activities)

### 1. Splash / Welcome (`MainActivity`)
- Halaman pembuka aplikasi dengan logo merek dan tombol **"Mulai"**.
- Mengarahkan pengguna ke halaman onboarding Sign Up.
<img width="375" height="831" alt="Screenshot 2026-11-01 211814" src="https://github.com/user-attachments/assets/b69e25cf-4dea-4135-b5e4-ad788c766d58" />

### 2. Onboarding Sign Up (`SignUpActivity`)
- Pusat sambutan bagi pengguna baru.
- Menyediakan tombol **Register** untuk pendaftaran akun baru dan **Login** bagi pengguna yang sudah memiliki akun.
<img width="375" height="827" alt="image" src="https://github.com/user-attachments/assets/1c9a8d5d-5764-42a0-9dd7-bbc1686a860b" />


### 3. Halaman Login (`LoginActivity`)
- Formulir masuk akun dengan validasi email dan password yang dicocokkan dengan penyimpanan statis (`UserRepository`).
- Tautan pintasan ke halaman registrasi jika belum memiliki akun.
<img width="375" height="828" alt="image" src="https://github.com/user-attachments/assets/3d3d606b-38e7-4588-b34d-9f43e29350f8" />


### 4. Halaman Register (`RegisterActivity`)
- Formulir pendaftaran akun baru (Nama Lengkap, Email, Password).
- Dilengkapi validasi pencegahan duplikasi email terdaftar.
<img width="371" height="827" alt="image" src="https://github.com/user-attachments/assets/26fc4872-4517-4562-ab85-e6592d570d09" />


### 5. Halaman Utama / Home (`HomeActivity`)
- **Sapaan Dinamis**: Menampilkan teks sapaan *"Halo [Nama User]"* sesuai dengan akun yang sedang aktif.
- **Katalog Menu (*RecyclerView*)**: Menampilkan daftar produk kuliner matcha (Matcha Espresso Latte, Croissant, Cheesecake, dll.) yang di-*looping* secara dinamis dari adapter (`FoodAdapter`).
- **Modal Jumlah Pesanan**: Tombol `+` pada setiap kartu menu membuka dialog modal kustom untuk menentukan jumlah pesanan.
- **Tombol Checkout**: Menampilkan ringkasan item dalam keranjang pada dialog modal sebelum melanjutkan ke halaman pengiriman.
- **Navbar Bawah (*Bottom Navigation*)**: Navigasi cepat antara tab **Home** dan **Profile**.
<img width="370" height="835" alt="image" src="https://github.com/user-attachments/assets/7b02c156-6d68-4cf6-964c-ed846743241e" />
<img width="367" height="828" alt="image" src="https://github.com/user-attachments/assets/ee61bb20-814c-4134-9441-f6fb057987f8" />
<img width="372" height="825" alt="image" src="https://github.com/user-attachments/assets/7a51a12b-3d37-40a5-9737-2a6dbad68cb4" />



### 6. Halaman Checkout & Alamat (`OrderActivity`)
- Menampilkan ringkasan menu beserta kuantitas yang dipesan dari keranjang.
- Formulir input **Alamat Pengiriman** dan **Patokan / Alamat Lengkap**.
<img width="370" height="831" alt="image" src="https://github.com/user-attachments/assets/774c3621-b9c6-4aa1-9996-d9e5e7147191" />

### 7. Halaman Konfirmasi Pesanan (`OrderSuccessActivity`)
- Layar sukses setelah pesanan dibuat dengan lencana hijau bertuliskan *"OK"*.
- Tombol **"Oke"** untuk kembali ke halaman utama (*Home*).
<img width="375" height="832" alt="image" src="https://github.com/user-attachments/assets/fd9ecceb-7dc7-474f-a5fc-69fa8112a358" />


### 8. Halaman Profil (`ProfileActivity`)
- Halaman bagi pengguna untuk melihat dan memperbarui informasi akun (Nama Lengkap, Email, dan Password baru).
- Dilengkapi dengan *bottom navigation bar* yang aktif untuk berpindah kembali ke tab Home.
<img width="370" height="822" alt="image" src="https://github.com/user-attachments/assets/4e267cb6-4b9e-4518-ab0b-8add8bc4d4a3" />

---

## 🚶‍♂️ Alur Penggunaan Aplikasi (User Journey)
1. **Mulai**: Saat aplikasi dibuka (`MainActivity`), klik tombol **"Mulai"** untuk menuju halaman Sign Up.
    
2. **Autentikasi**: 
   - Jika belum punya akun, klik **Register**, isi data diri, lalu klik tombol pendaftaran (akun tersimpan secara statis).
   - Jika sudah punya akun, klik **Login** dan masukkan email & password yang terdaftar.

3. **Eksplorasi Menu**: Di halaman **Home**, Anda akan disambut dengan nama Anda. Gulir daftar menu matcha yang tersedia.

4. **Pemesanan**: 
   - Klik tombol **`+`** pada salah satu menu untuk memilih jumlah pesanan melalui dialog modal, lalu klik **Tambah**.
   - Setelah selesai memilih menu, klik tombol **"Checkout Pesanan"** di atas navbar.
   - Periksa ringkasan pesanan di dialog, lalu klik **"Pesan Sekarang"**.

5. **Pengisian Alamat**: Di halaman **Order**, masukkan Alamat Pengiriman dan Patokan/Alamat Lengkap, lalu tekan **"Konfirmasi Pesanan"**.

6. **Konfirmasi Sukses**: Anda akan melihat halaman sukses (`OrderSuccessActivity`). Tekan tombol **"Oke"** untuk kembali ke beranda Home.

7. **Profil**: Anda dapat berpindah ke tab **Profile** kapan saja melalui navbar bawah untuk melihat atau memperbarui informasi akun Anda.

---

## 🚀 Cara Menjalankan Proyek
1. Buka proyek ini di **Android Studio**.
2. Pastikan Gradle sync telah selesai.
3. Jalankan aplikasi pada emulator Android atau perangkat fisik menggunakan tombol **Run (`▶`)**.
