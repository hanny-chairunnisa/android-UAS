
    package com.ac.id.todolist.model;

    public class ProfileModel {

        private int uid;
        private String nama;
        private String email;
        private String pass;
        private String alamat;
        private String status;
        private String pendidikan;


        public ProfileModel(int uid, String nama, String alamat, String pendidikan, String email, String pass) {
            this.uid = uid;
            this.nama = nama;
            this.email = email;
            this.pass = pass;
            this.alamat = alamat;
            //this.status = status;
            this.pendidikan = pendidikan;
        }

        public String toString() {
            return "FriendModel{" +
                    "ID=" + uid +
                    ", nama='" + nama + '\'' +
                    ", email=" + email +
                    ", pass=" + pass +
                    ", alamat=" + alamat +
                    ", pendidikan=" + pendidikan +
                    '}';
        }

        public void GetUid() {
            this.uid = uid;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPendidikan() {
            return pendidikan;
        }

        public void setPendidikan(String pendidikan) {
            this.pendidikan = pendidikan;
        }

}
