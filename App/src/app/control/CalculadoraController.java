/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.control;

import app.modelo.historico;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author 04079893230
 */
public class CalculadoraController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
     private TextField txtNumero1;
    @FXML
     private TextField txtNumero2;
    @FXML
     private TextField txtResultado;
    @FXML
    private Button btnSoma;
    @FXML
    private TableView<?> tbCalculadora;
    @FXML
    private void soma(ActionEvent event) {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("atividadeAva");
        EntityManager em = emf.createEntityManager();
        
        historico h = new historico();
        Double num1 = Double.parseDouble(txtNumero1.getText()); 
        Double num2 = Double.parseDouble(txtNumero2.getText());
        h.setPrimeiroValor(num1);
        h.setSegundoValor(num2);
        h.setOperador("+");
        Double resultado =num1 + num2;
        h.setResultado(resultado);
        txtResultado.setText(resultado.toString());
       
        
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction() .commit();
        JOptionPane.showMessageDialog(null, "o calculo foi feito e salvo");
    }
    
    
    @FXML
    private void subtracao(ActionEvent event) {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("atividadeAva");
        EntityManager em = emf.createEntityManager();
        
        historico h = new historico();
        Double num1 = Double.parseDouble(txtNumero1.getText()); 
        Double num2 = Double.parseDouble(txtNumero2.getText());
        h.setPrimeiroValor(num1);
        h.setSegundoValor(num2);
        h.setOperador("-");
        Double resultado =num1 - num2;
        h.setResultado(resultado);
        txtResultado.setText(resultado.toString());
       
        
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction() .commit();
        JOptionPane.showMessageDialog(null, "o calculo foi feito e salvo");
    }
    
    @FXML
    private void divisao(ActionEvent event) {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("atividadeAva");
        EntityManager em = emf.createEntityManager();
        
        historico h = new historico();
        Double num1 = Double.parseDouble(txtNumero1.getText()); 
        Double num2 = Double.parseDouble(txtNumero2.getText());
        h.setPrimeiroValor(num1);
        h.setSegundoValor(num2);
        h.setOperador("/");
        Double resultado =num1 / num2;
        h.setResultado(resultado);
        txtResultado.setText(resultado.toString());
       
        
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction() .commit();
        JOptionPane.showMessageDialog(null, "o calculo foi feito e salvo");
    }
    
    @FXML
    private void multiplicacao(ActionEvent event) {
       EntityManagerFactory emf =Persistence.createEntityManagerFactory("atividadeAva");
        EntityManager em = emf.createEntityManager();
        
        historico h = new historico();
        Double num1 = Double.parseDouble(txtNumero1.getText()); 
        Double num2 = Double.parseDouble(txtNumero2.getText());
        h.setPrimeiroValor(num1);
        h.setSegundoValor(num2);
        h.setOperador("*");
        Double resultado =num1 * num2;
        h.setResultado(resultado);
        txtResultado.setText(resultado.toString());
       
        
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction() .commit();
        JOptionPane.showMessageDialog(null, "o calculo foi feito e salvo");
    }
    @FXML
    private void limpar(ActionEvent event) {
        txtResultado.setText(null); 
        txtNumero1.setText(null);
        txtNumero2.setText(null);
    }
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("atividadeAva");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT c FROM historico as c");
        //query.setParameter("id");
        
        List<historico> Historico = query.getResultList();
        
        ObservableList obHistorico = FXCollections.observableArrayList(Historico);
        tbCalculadora.setItems(obHistorico);
    }    
    
}
