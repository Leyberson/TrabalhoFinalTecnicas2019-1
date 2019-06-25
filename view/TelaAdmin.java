package view;

import controller.*;
import model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaAdmin extends TelaAtendente{
    protected AnchorPane 
            paneFuncionario, paneCadastroFuncionario, paneDeletarFuncionario;
    
    protected Button btCadastrarFuncionario, btDeletarFuncionario,
            btTelaFuncionario, btTelaCadastrarFuncionario, btTelaDeletarFuncionario;
    
    protected TextField txCadastrarLoginFuncionario, txCadastrarNomeFuncionario, 
            txDeletarFuncionario;
    
    protected PasswordField txCadastrarSenhaFuncionario;
    
    protected ComboBox cbCargo;

    AdminControlador admControl = new AdminControlador();
    
    @Override
    public void start(Stage stage) {
        
        super.start(stage);
        
        initComponentsAdmin();
        initListenersAdmin();
        initLayoutAdmin();
        
        sceneFuncionario = new Scene(paneFuncionario);
        sceneCadastroFuncionario = new Scene(paneCadastroFuncionario);
        sceneDeletarFuncionario = new Scene(paneDeletarFuncionario);
    }
    
    protected void initComponentsAdmin() {
        // Pane
        paneFuncionario = new AnchorPane();
        paneFuncionario.setPrefSize(558, 259);
        
        paneCadastroFuncionario = new AnchorPane();
        paneCadastroFuncionario.setPrefSize(558, 259);
        
        paneDeletarFuncionario = new AnchorPane();
        paneDeletarFuncionario.setPrefSize(558, 259);
        
        // Buttons
        btTelaFuncionario = new Button("Funcionario");
        btTelaCadastrarFuncionario = new Button("Cadastrar Funcionario");
        btTelaDeletarFuncionario = new Button("Deletar Funcionario");
        
        btCadastrarFuncionario = new Button("Cadastrar Funcionário");
        btDeletarFuncionario = new Button("Deletar Funcionario");
        
        // Texts
        txCadastrarNomeFuncionario = new TextField();
        txCadastrarLoginFuncionario = new TextField();
        txDeletarFuncionario = new TextField();
        txCadastrarSenhaFuncionario = new PasswordField();
        
        // Combo Box
        ObservableList<String> cargos = 
        FXCollections.observableArrayList(
            "Médico",
            "Atendente"
        );
        
        cbCargo = new ComboBox(cargos);
        
        // incrementação VBox
        vBoxMenu.getChildren().addAll(btTelaFuncionario);

        // incrementação Pane
        paneFuncionario.getChildren().addAll(btTelaCadastrarFuncionario, 
                btTelaDeletarFuncionario);
        
        paneCadastroFuncionario.getChildren().addAll(cbCargo, 
                btCadastrarFuncionario, txCadastrarNomeFuncionario,
                txCadastrarLoginFuncionario, txCadastrarSenhaFuncionario);
        
        paneDeletarFuncionario.getChildren().addAll(btDeletarFuncionario, 
                txDeletarFuncionario);
    }
    
    private void initListenersAdmin() {
        // Trocar telas
        
        btTelaFuncionario.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneFuncionario)
                paneFuncionario.getChildren().addAll(vBoxMenu);
            mudarTela("funcionario");
        });
        
        btTelaCadastrarFuncionario.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneCadastroFuncionario)
                paneCadastroFuncionario.getChildren().addAll(vBoxMenu);
            
            mudarTela("cadastroFuncionario");
        });
        
        btTelaDeletarFuncionario.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneDeletarFuncionario)
                paneDeletarFuncionario.getChildren().addAll(vBoxMenu);
            mudarTela("deletarFuncionario");
        });
        
        // Ações dos botões
        
        //botao cadastrar funcionario
        btCadastrarFuncionario.setOnAction((ActionEvent event) -> {
            if(cbCargo.getValue() != null && admControl.cadastrarFuncionario((String)cbCargo.getValue(), txCadastrarNomeFuncionario.getText(), txCadastrarLoginFuncionario.getText(), txCadastrarSenhaFuncionario.getText())){
               System.out.println(cbCargo.getValue() +"Cadastrado");
            } else if(cbCargo.getValue() == null){
                System.out.println("Por favor escolha o tipo de funcionario");
            } else {
                System.out.println("Usuario ja existe");
            }
        });
        

        //botao de deletar funcionario
        btDeletarFuncionario.setOnAction((ActionEvent event) -> {
            if(admControl.deletarFuncionario(txDeletarFuncionario.getText())){
                System.out.println("Paciente Deletado");
            }else{
                System.out.println("Funcionario inexistente");
            }
        });
    }
    
    private void initLayoutAdmin() {
        // Texts
        txCadastrarNomeFuncionario.setPromptText("Nome Funcionario");
        txCadastrarNomeFuncionario.setLayoutX(200);
        txCadastrarNomeFuncionario.setLayoutY(76);
        
        txCadastrarLoginFuncionario.setPromptText("Login");
        txCadastrarLoginFuncionario.setLayoutX(200);
        txCadastrarLoginFuncionario.setLayoutY(108);
        
        txCadastrarSenhaFuncionario.setPromptText("Senha");
        txCadastrarSenhaFuncionario.setLayoutX(200);
        txCadastrarSenhaFuncionario.setLayoutY(139);
        
        txDeletarFuncionario.setPromptText("Login Funcionario");
        txDeletarFuncionario.setLayoutX(215);
        txDeletarFuncionario.setLayoutY(108);

        // Buttons
        btTelaFuncionario.setPrefSize(138, 46);
        
        btTelaCadastrarFuncionario.setPrefSize(296, 129);
        btTelaCadastrarFuncionario.setLayoutX(206);
        btTelaCadastrarFuncionario.setLayoutY(40);
        
        btTelaDeletarFuncionario.setPrefSize(296, 129);
        btTelaDeletarFuncionario.setLayoutX(206);
        btTelaDeletarFuncionario.setLayoutY(200);
        
        btCadastrarFuncionario.setLayoutX(385);
        btCadastrarFuncionario.setLayoutY(108);
        
        btDeletarFuncionario.setLayoutX(390);
        btDeletarFuncionario.setLayoutY(108);
        
        // Combo box
        cbCargo.setPromptText("Cargo");
        cbCargo.setPrefWidth(150);
        cbCargo.setLayoutX(200);
        cbCargo.setLayoutY(40);
    }
    
    public TelaAdmin(){
        super();
    }
}
