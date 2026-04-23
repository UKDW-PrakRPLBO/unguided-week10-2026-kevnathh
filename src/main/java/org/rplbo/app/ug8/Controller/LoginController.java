package org.rplbo.app.ug8.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import org.rplbo.app.ug8.UmbrellaApp;
import org.rplbo.app.ug8.UmbrellaDBManager;

import java.io.IOException;

public class LoginController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblStatus;

    @FXML
    private void handleLogin(ActionEvent event) {
        // ==============================================================================
        // TODO 1: PROSES AUTENTIKASI (LOGIN)
        // ==============================================================================
        // 1. Ambil input teks dari txtUsername dan txtPassword.
        // 2. Buat instansiasi dari class UmbrellaDBManager.
        // 3. Panggil metode validateUser() dari db manager tersebut.
        // 4. Jika hasil validasi berhasil (tidak null):
        //    a. Simpan nama user ke variabel statis UmbrellaApp.loggedInUser.
        //    b. Pindah ke halaman "umbrella-view.fxml" menggunakan UmbrellaApp.switchScene().
        // 5. Jika gagal, tampilkan pesan error "AUTHENTICATION FAILED" pada lblStatus.
        // ==============================================================================

//        if (event.getSource() == KeyCode.ENTER) {
//            btnLoginClick();
//        }
//    }
//
//    @FXML
//    protected void btnLoginClick() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        UmbrellaDBManager db = new UmbrellaDBManager();

        if (db.validateUser(username, password) != null) {
            try {
                UmbrellaApp.loggedInUser = username;
                UmbrellaApp.switchScene("umbrella-view.fxml");
            } catch (IOException e) {
//                throw new RuntimeException(e);
                lblStatus.setText("AUTHENTICATION FAILED");
            }
        } else {
            lblStatus.setText("AUTHENTICATION FAILED");
        }
    }
}