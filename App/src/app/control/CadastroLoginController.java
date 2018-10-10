/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
 * @author ROMERA
 */
public class CadastroLoginController implements Initializable {

    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXPasswordField txtSenha2;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnLimpar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void salvar1(ActionEvent event) {
        if(txtUsuario.getText().equals("") || txtSenha.getText().equals("") || txtSenha2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha Corretamente os campos");
        }
        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividadeAva");
            EntityManager em = emf.createEntityManager();
                Login login1 = new Login();
                login1.setUsuario(txtUsuario.getText());
                login1.setSenha(txtSenha.getText());
                
                em.getTransaction().begin();                
                em.persist(login1);                
                em.getTransaction().commit();
                
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }
    private void salvar(ActionEvent event) {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("atividadeAva");
        EntityManager em = emf.createEntityManager();
        
        Login login1 = new Login();
        login1.setUsuario(txtUsuario.getText());
        login1.setSenha(txtSenha.getText());
        
        
        em.getTransaction().begin();
        
        em.persist(login1);
        
        em.getTransaction() .commit();
        
    }
    


    @FXML
    private void limpar(ActionEvent event) {
        txtUsuario.setText("");
        txtSenha.setText("");
        txtSenha2.setText("");
        txtUsuario.requestFocus();
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void Verificar(ActionEvent event) {
        if(txtUsuario.getText().equals("") || txtSenha.getText().equals("") || txtSenha2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Está faltando alguma informação!");
        }
        
        else if(txtSenha.getText().equals(txtSenha2.getText())){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividadeAva");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT l FROM Login as l WHERE l.usuario = :usuario");        
            //Query query = em.createQuery("SELECT l FROM Login as l WHERE l.usuario = :usuario and l.senha = :senha");
            query.setParameter("usuario", txtUsuario.getText());
            //query.setParameter("senha", txtSenha.getText());
            //Login login1 = (Login) query.getSingleResult();
            List<Login> l = query.getResultList();
            
            if (!l.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Usuário já existente!");
                
            } else {
                Login login1 = new Login();
                login1.setUsuario(txtUsuario.getText());
                login1.setSenha(txtSenha.getText());
                
                em.getTransaction().begin();                
                em.persist(login1);                
                em.getTransaction().commit();
                
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "As senhas não conferem!");
        }
    }
    
}

