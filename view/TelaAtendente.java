package trabalhofinal.view;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//tela atendente decora a de usuarui já que tem as msm fucionalidades
//adicionando adicionando cadastrar e deletar consulta, e cadastrar e deletar paciente

public class TelaAtendente extends TelaUsuario{
    protected AnchorPane paneAtendente, 
            paneConsulta, paneCadastroConsulta, paneDeletarConsulta, 
            panePaciente, paneCadastroPaciente, paneDeletarPaciente;
    
    protected Button btConsultas, btCadastrarConsulta, btCadastrarPaciente,
            btDeletarConsulta, btDeletarPaciente,
            btTelaCadastrarConsulta, 
            btTelaPaciente, btTelaCadastrarPaciente, btTelaDeletarPaciente;
    
    protected TextField txCadastrarLoginPaciente, txCadastrarNomePaciente, 
            txDataConsulta,
            txDeletarPaciente;
    
    protected PasswordField txCadastrarSenhaPaciente;
    
    protected ComboBox cbPacientes, cbMedicos;
    
    protected VBox vBoxMedPacCB;
    
    @Override
    public void start(Stage stage) {
        
        super.start(stage);
        
        initComponentsAtendente();
        initListenersAtendente();
        initLayoutAtendente();
        
        sceneCadastroConsulta = new Scene(paneCadastroConsulta);
        scenePaciente = new Scene(panePaciente);
        sceneCadastroPaciente = new Scene(paneCadastroPaciente);
        sceneDeletarPaciente = new Scene(paneDeletarPaciente);
        
    }
    //view de cadastros
    protected void initComponentsAtendente() {
        
        // Panes
        paneConsulta = new AnchorPane();
        paneConsulta.setPrefSize(558, 259);
        
        panePaciente = new AnchorPane();
        panePaciente.setPrefSize(558, 259);
        
        paneCadastroConsulta = new AnchorPane();
        paneCadastroConsulta.setPrefSize(558, 259);
        
        paneCadastroPaciente = new AnchorPane();
        paneCadastroPaciente.setPrefSize(558, 259);
        
        paneDeletarConsulta = new AnchorPane();
        paneDeletarConsulta.setPrefSize(558, 259);
        
        paneDeletarPaciente = new AnchorPane();
        paneDeletarPaciente.setPrefSize(558, 258);
        
        // Texts
        txCadastrarNomePaciente = new TextField();
        
        txCadastrarLoginPaciente = new TextField();
        
        txCadastrarSenhaPaciente = new PasswordField();
        
        txDataConsulta = new TextField();
        txDeletarPaciente = new TextField();
        
        // Buttons
        btConsultas = new Button("Consultas");
        btTelaCadastrarConsulta = new Button("Cadastrar Consulta");
        
        btTelaPaciente = new Button("Paciente");
        btTelaCadastrarPaciente = new Button("Cadastrar Paciente");
        btTelaDeletarPaciente = new Button("Deletar Paciente");
        
        btCadastrarConsulta = new Button("Cadastrar Consulta");
        btCadastrarPaciente = new Button("Pacientes");
        
        btDeletarConsulta = new Button("Desmarcar Consulta"); 
        btDeletarPaciente = new Button("Deletar");
        
        // Combo Boxes
        cbPacientes = new ComboBox();
        cbMedicos = new ComboBox();
        
        // VBoxs
        vBoxMedPacCB = new VBox();
        vBoxMedPacCB.getChildren().addAll(cbPacientes, cbMedicos, 
                txDataConsulta);
        
        // Incrementação do Menu
        vBoxMenu.getChildren().addAll(btConsultas, btTelaCadastrarConsulta,
                btTelaPaciente);
        
        // Incrementação dos panes
        paneUsuario.getChildren().addAll(btDeletarConsulta);
        
        paneCadastroConsulta.getChildren().addAll(vBoxMedPacCB, 
                btCadastrarConsulta);
        
        panePaciente.getChildren().addAll(btTelaCadastrarPaciente, 
                btTelaDeletarPaciente);
        
        paneCadastroPaciente.getChildren().addAll(txCadastrarNomePaciente,
                txCadastrarLoginPaciente, txCadastrarSenhaPaciente, 
                btCadastrarPaciente);
        
        paneDeletarPaciente.getChildren().addAll(btDeletarPaciente, 
                txDeletarPaciente);
    }
    //escutador de atendente  (observer)
    private void initListenersAtendente() {
        // Mudanças de telas

        btConsultas.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneUsuario)
                paneUsuario.getChildren().addAll(vBoxMenu);
            mudarTela("usuario");
        });
                
        btTelaCadastrarConsulta.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneCadastroConsulta)
                paneCadastroConsulta.getChildren().addAll(vBoxMenu);
            mudarTela("cadastroConsulta");
        });
        
        btTelaPaciente.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != scenePaciente)
                panePaciente.getChildren().addAll(vBoxMenu);
            mudarTela("paciente");
        });
        
        btTelaCadastrarPaciente.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneCadastroPaciente)
                paneCadastroPaciente.getChildren().addAll(vBoxMenu);
            mudarTela("cadastroPaciente");
        });
        
        btTelaDeletarPaciente.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneDeletarPaciente)
                paneDeletarPaciente.getChildren().addAll(vBoxMenu);
            mudarTela("deletarPaciente");
        });
        
        // Funções dos botões
        
        btCadastrarConsulta.setOnAction((ActionEvent event) -> {
            System.out.println("Consulta Cadastrada");
        });
        
        btDeletarConsulta.setOnAction((ActionEvent event) -> {
            System.out.println("Consulta Deletada");
        });
        
        btCadastrarPaciente.setOnAction((ActionEvent event) -> {
            System.out.println("Paciente Cadastrado");
        });
        
        btDeletarPaciente.setOnAction((ActionEvent event) -> {
            System.out.println("Paciente Deletado");
        });
    }
    //view das interações com o paciente
    private void initLayoutAtendente() {  
        // Texts
        txCadastrarNomePaciente.setPromptText("Nome Paciente");
        txCadastrarNomePaciente.setLayoutX(200);
        txCadastrarNomePaciente.setLayoutY(76);
        
        txCadastrarLoginPaciente.setPromptText("Login");
        txCadastrarLoginPaciente.setLayoutX(200);
        txCadastrarLoginPaciente.setLayoutY(108);
        
        txCadastrarSenhaPaciente.setPromptText("Senha");
        txCadastrarSenhaPaciente.setLayoutX(200);
        txCadastrarSenhaPaciente.setLayoutY(139);
        
        txDataConsulta.setPromptText("Data");
        
        txDeletarPaciente.setPromptText("Login Paciente");
        txDeletarPaciente.setLayoutX(215);
        txDeletarPaciente.setLayoutY(108);
        
        // Buttons
        
        btCadastrarConsulta.setLayoutX(205);
        btCadastrarConsulta.setLayoutY(150);
        
        btCadastrarPaciente.setLayoutX(390);
        btCadastrarPaciente.setLayoutY(108);
        
        btDeletarPaciente.setLayoutX(390);
        btDeletarPaciente.setLayoutY(108);
        
        btConsultas.setPrefSize(138, 46);
        btTelaCadastrarConsulta.setPrefSize(138, 46);
        btTelaCadastrarPaciente.setPrefSize(138, 46);
        
        btTelaPaciente.setPrefSize(138, 46);
        
        btTelaCadastrarPaciente.setPrefSize(296, 129);
        btTelaCadastrarPaciente.setLayoutX(206);
        btTelaCadastrarPaciente.setLayoutY(40);
        
        btTelaDeletarPaciente.setPrefSize(296, 129);
        btTelaDeletarPaciente.setLayoutX(206);
        btTelaDeletarPaciente.setLayoutY(200);
        
        btDeletarConsulta.setLayoutX(375);
        btDeletarConsulta.setLayoutY(58);
        
        // Combo Boxes
        cbPacientes.setPromptText("Paciente");
        cbPacientes.setPrefWidth(150);
        
        cbMedicos.setPromptText("Médico");
        cbMedicos.setPrefWidth(150);
        
        // VBoxes
        vBoxMedPacCB.setPrefSize(138, 64);
        vBoxMedPacCB.setLayoutX(194);
        vBoxMedPacCB.setLayoutY(33);
        vBoxMedPacCB.setSpacing(10);
        
    }
    
    public TelaAtendente(){
        super();
    }
}
