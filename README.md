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

### 2. Onboarding Sign Up (`SignUpActivity`)
- Pusat sambutan bagi pengguna baru.
- Menyediakan tombol **Register** untuk pendaftaran akun baru dan **Login** bagi pengguna yang sudah memiliki akun.

### 3. Halaman Login (`LoginActivity`)
- Formulir masuk akun dengan validasi email dan password yang dicocokkan dengan penyimpanan statis (`UserRepository`).
- Tautan pintasan ke halaman registrasi jika belum memiliki akun.

### 4. Halaman Register (`RegisterActivity`)
- Formulir pendaftaran akun baru (Nama Lengkap, Email, Password).
- Dilengkapi validasi pencegahan duplikasi email terdaftar.

### 5. Halaman Utama / Home (`HomeActivity`)
- **Sapaan Dinamis**: Menampilkan teks sapaan *"Halo [Nama User]"* sesuai dengan akun yang sedang aktif.
- **Katalog Menu (*RecyclerView*)**: Menampilkan daftar produk kuliner matcha (Matcha Espresso Latte, Croissant, Cheesecake, dll.) yang di-*looping* secara dinamis dari adapter (`FoodAdapter`).
- **Modal Jumlah Pesanan**: Tombol `+` pada setiap kartu menu membuka dialog modal kustom untuk menentukan jumlah pesanan.
- **Tombol Checkout**: Menampilkan ringkasan item dalam keranjang pada dialog modal sebelum melanjutkan ke halaman pengiriman.
- **Navbar Bawah (*Bottom Navigation*)**: Navigasi cepat antara tab **Home** dan **Profile**.

### 6. Halaman Checkout & Alamat (`OrderActivity`)
- Menampilkan ringkasan menu beserta kuantitas yang dipesan dari keranjang.
- Formulir input **Alamat Pengiriman** dan **Patokan / Alamat Lengkap**.

### 7. Halaman Konfirmasi Pesanan (`OrderSuccessActivity`)
- Layar sukses setelah pesanan dibuat dengan lencana hijau bertuliskan *"OK"*.
- Tombol **"Oke"** untuk kembali ke halaman utama (*Home*).

### 8. Halaman Profil (`ProfileActivity`)
- Halaman bagi pengguna untuk melihat dan memperbarui informasi akun (Nama Lengkap, Email, dan Password baru).
- Dilengkapi dengan *bottom navigation bar* yang aktif untuk berpindah kembali ke tab Home.

---

## 🚀 Cara Menjalankan Proyek
1. Buka proyek ini di **Android Studio**.
2. Pastikan Gradle sync telah selesai.
3. Jalankan aplikasi pada emulator Android atau perangkat fisik menggunakan tombol **Run (`▶`)**.
