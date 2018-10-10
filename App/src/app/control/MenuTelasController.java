/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.uitoolkit.ToolkitStore;
import com.sun.org.apache.bcel.internal.generic.L2D;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 04079893230
 */
public class MenuTelasController implements Initializable {

    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXRadioButton cbMostrar;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXTextField txtSenha2;

  @FXML
 private void mostrarSenha(ActionEvent event) {
 if(cbMostrar.isSelected()){
 txtSenha2.setText(txtSenha.getText());
 txtSenha2.setVisible(true);
 txtSenha.setVisible(false); 
 }
 else{
 txtSenha.setText(txtSenha.getText());
 txtSenha.setVisible(true);
 txtSenha2.setVisible(false); 
 }
 }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtSenha.setVisible(true);
        txtSenha2.setVisible(false);
    }    
 @FXML
 private void cadastroLogin(ActionEvent event) {
 try{
 FXMLLoader fxmlLoader = new FXMLLoader();
 fxmlLoader.setLocation(getClass().getResource("/app/view/CadastroLogin.fxml"));
 Scene scene = new Scene(fxmlLoader.load());
 
 Stage stage = new Stage();
 stage.setTitle("Cadastrar Login");
 stage.setScene(scene);
 stage.show();
 }
 catch(IOException e){

 }
 }
    @FXML
 public void efetuarLogin() throws IOException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividadeAva");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT l FROM Login as l WHERE l.usuario = :usuario");        
        //Query query = em.createQuery("SELECT l FROM Login as l WHERE l.usuario = :usuario and l.senha = :senha");
        query.setParameter("usuario", txtUsuario.getText());
        //query.setParameter("senha", txtSenha.getText());
        //Login login1 = (Login) query.getSingleResult();
        List<Login> l = query.getResultList();
        if (!l.isEmpty()) {
            //System.out.println(l[0]);
            Login login = l.get(0);
            String senha = txtSenha2.getText();
            String senha2 = txtSenha.getText();
            if (login.getSenha().equals(senha) || login.getSenha().equals(senha2)) {
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/app/view/Calculadora.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Calculadora");
                stage.setScene(scene);
                stage.show();
               
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Senha incorreta");
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "Usuário incorreto");
        }
        
        em.close();
        emf.close();
    }
    
}




