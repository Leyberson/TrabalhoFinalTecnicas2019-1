package view;

import controller.*;
import model.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

/**
 *
 * @author rodri
 */
public class Login extends Application {
    private Label titulo;
    private AnchorPane pane;
    private TextField txLogin;
    private PasswordField txSenha;
    private Button btEntrar;
    private Alert alert;
    private static Stage stage;

    LoginControlador lc = new LoginControlador("","");    
    
    @Override
    public void start(Stage stage) {
        initComponents();
        initListeners();
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Login");        
        stage.show();
        
        initLayout();
        
        Login.stage = stage;
    }
    //view das instanciações do archonpane
    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(274, 445);

        titulo = new Label("Clínica Médica");
        
        txLogin = new TextField();
        txLogin.setPromptText("Login");
        
        txSenha = new PasswordField();
        txSenha.setPromptText("Senha");
        
        btEntrar = new Button("Entrar");

        alert = new Alert(AlertType.WARNING);
        
        pane.getChildren().addAll(titulo, txLogin, txSenha, btEntrar);
    }
     
    private void initListeners() {
        btEntrar.setOnAction((ActionEvent event) -> {
            logar();
        });
    }
    //view inicialização do layout do login
    private void initLayout() {
        
        titulo.setLayoutX(90);
        titulo.setLayoutY(110);

        txLogin.setLayoutX(63);
        txLogin.setLayoutY(161);
    
        txSenha.setLayoutX(63);
        txSenha.setLayoutY(210);
      
        btEntrar.setLayoutX(111);
        btEntrar.setLayoutY(268);
        
        alert.setTitle("Senha Incorreta");
        alert.setHeaderText("Insira uma nova senha");
        // alert.setContentText("aaaaaa");
    }
    
    
    private void logar(){
        // if (txLogin.getText().equals("usr")) {
        //     System.out.println("Tela Usuario");
        //     TelaUsuario tUsr = new TelaUsuario();
        //     stage.close();
        // }
        // if (txLogin.getText().equals("atd")) {
        //     System.out.println("Tela Atendente");
        //     TelaAtendente tAtd = new TelaAtendente();
        //     stage.close();
        // }
        // if (txLogin.getText().equalsIgnoreCase("admin") && txSenha.getText().equals("admin")) {
        //     System.out.println("Tela Admin");
        //     TelaAdmin tAdm = new TelaAdmin();
        //     stage.close();
        // }

        lc.setLoginSenha(txLogin.getText(), txSenha.getText());
        if(lc.logar()){
            stage.close();
        }else{
            alert.showAndWait();
            txLogin.clear();
            txSenha.clear();
            //aparece aviso de Usuario/senha invalidos
        }

    }
    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
