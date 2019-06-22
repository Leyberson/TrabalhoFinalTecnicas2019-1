package trabalhofinal.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author rodri
 */
public class Login extends Application {
    private AnchorPane pane;
    private TextField txLogin;
    private PasswordField txSenha;
    private Button btEntrar;
    private static Stage stage;
    
    
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
        
        txLogin = new TextField();
        txLogin.setPromptText("Login");
        
        txSenha = new PasswordField();
        txSenha.setPromptText("Senha");
        
        btEntrar = new Button("Entrar");
        
        pane.getChildren().addAll(txLogin, txSenha, btEntrar);
    }
     
    private void initListeners() {
        btEntrar.setOnAction((ActionEvent event) -> {
            logar();
        });
    }
    //view inicialização do layout do login
    private void initLayout() {
        
        txLogin.setLayoutX(63);
        txLogin.setLayoutY(161);
    
        txSenha.setLayoutX(63);
        txSenha.setLayoutY(210);
      
        btEntrar.setLayoutX(111);
        btEntrar.setLayoutY(268);
        
        
    }
    
    
    private void logar(){
        if (txLogin.getText().equals("usr")) {
            System.out.println("Tela Usuario");
            TelaUsuario tUsr = new TelaUsuario();
            stage.close();
        }
        if (txLogin.getText().equals("atd")) {
            System.out.println("Tela Atendente");
            TelaAtendente tAtd = new TelaAtendente();
            stage.close();
        }
        if (txLogin.getText().equals("admin")) {
            System.out.println("Tela Admin");
            TelaAdmin tAdm = new TelaAdmin();
            stage.close();
        }
    }
    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
