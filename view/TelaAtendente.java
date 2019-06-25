package view;

import model.*;
import controller.*;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//tela atendente decora a de usuario já que tem as msm fucionalidades

//adicionando adicionando cadastrar e deletar consulta, e cadastrar e deletar paciente

public class TelaAtendente extends TelaUsuario{
    protected AnchorPane paneAtendente, paneVisualizarConsulta, 
            paneCadastroConsulta, paneDeletarConsulta, panePaciente, 
            paneCadastroPaciente, paneDeletarPaciente, paneConsulta;
    
    protected Button btVisualizarConsultas, btCadastrarConsulta, 
            btCadastrarPaciente, btDeletarConsulta, btDeletarPaciente, 
            btTelaCadastrarConsulta, btTelaDeletarConsulta, btTelaConsulta,
            btTelaPaciente, btTelaCadastrarPaciente, btTelaDeletarPaciente;
    
    protected TextField txCadastrarLoginPaciente, txCadastrarNomePaciente, 
            txDataDia, txDataMes, txDataAno, txDataHora, txDeletarPaciente, 
            txDataDiaConsulta, txDataMesConsulta, txDataAnoConsulta, 
            txDataHoraConsulta;
    
    protected PasswordField txCadastrarSenhaPaciente;
    
    protected ComboBox cbPacientes, cbMedicos, cbPacientesConsultados,
            cbMedicosConsultados;
    

    protected VBox vBoxMedPacCB, vBoxMedPacDC;

    private Alert alertCadastradoPaciente, alertPacienteDeletado,
            alertCadastrado, alertDeletado;


    AtendenteControlador ac = new AtendenteControlador();
    
    @Override
    public void start(Stage stage) {
        
        super.start(stage);
        
        initComponentsAtendente();
        initListenersAtendente();
        initLayoutAtendente();
        
        sceneConsultar = new Scene(paneConsulta);
        sceneCadastroConsulta = new Scene(paneCadastroConsulta);
        sceneDeletarConsulta = new Scene(paneDeletarConsulta);
        scenePaciente = new Scene(panePaciente);
        sceneCadastroPaciente = new Scene(paneCadastroPaciente);
        sceneDeletarPaciente = new Scene(paneDeletarPaciente);
        
    }
    //view de cadastros
    protected void initComponentsAtendente() {
        
        // Panes
        paneVisualizarConsulta = new AnchorPane();
        paneVisualizarConsulta.setPrefSize(558, 259);
        
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
        
        txDataDia = new TextField();
        txDataMes = new TextField();
        txDataAno = new TextField();
        txDataHora = new TextField();
        txDataDiaConsulta = new TextField();
        txDataMesConsulta = new TextField();
        txDataAnoConsulta = new TextField();
        txDataHoraConsulta = new TextField();
        txDeletarPaciente = new TextField();
        
        // Buttons
        btTelaConsulta = new Button("Consulta");
        btTelaDeletarConsulta = new Button("Deletar Consulta");
        
        btVisualizarConsultas = new Button("Visualizar Consultas");
        btTelaCadastrarConsulta = new Button("Cadastrar Consulta");
        
        btTelaPaciente = new Button("Paciente");
        btTelaCadastrarPaciente = new Button("Cadastrar Paciente");
        btTelaDeletarPaciente = new Button("Deletar Paciente");
        
        btCadastrarConsulta = new Button("Cadastrar");
        btCadastrarPaciente = new Button("Pacientes");
        
        btDeletarConsulta = new Button("Desmarcar"); 
        btDeletarPaciente = new Button("Deletar");
        
        // Combo Boxes
        cbPacientes = new ComboBox();
        cbMedicos = new ComboBox();
        cbPacientesConsultados = new ComboBox();
        cbMedicosConsultados = new ComboBox();
        
        // VBoxs
        vBoxMedPacCB = new VBox();
        vBoxMedPacCB.getChildren().addAll(cbPacientes, cbMedicos, txDataDia,
                txDataMes, txDataAno, txDataHora);
        
        vBoxMedPacDC = new VBox();
        vBoxMedPacDC.getChildren().addAll(cbPacientesConsultados, 
                cbMedicosConsultados, txDataDiaConsulta, txDataMesConsulta, 
                txDataAnoConsulta, txDataHoraConsulta);
        
        // Alertas
        alertCadastradoPaciente = new Alert(AlertType.WARNING);
        alertPacienteDeletado = new Alert(AlertType.WARNING);
        alertCadastrado = new Alert(AlertType.INFORMATION);
        alertDeletado = new Alert(AlertType.INFORMATION);
        
        // Alertas
        // alert = new Alert(AlertType.WARNING);
        
        // Incrementação do Menu
        vBoxMenu.getChildren().addAll(btVisualizarConsultas, btTelaConsulta,
                btTelaPaciente);
        
        // Incrementação dos panes
        //paneUsuario.getChildren().addAll();
        
        paneConsulta.getChildren().addAll(btTelaCadastrarConsulta,
                btTelaDeletarConsulta);
        
        paneCadastroConsulta.getChildren().addAll(vBoxMedPacCB, 
                btCadastrarConsulta);
        
        paneDeletarConsulta.getChildren().addAll(vBoxMedPacDC, btDeletarConsulta);
        
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

        btTelaConsulta.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneConsultar)
                paneConsulta.getChildren().addAll(vBoxMenu);
            mudarTela("consulta");
        }); // novo
        
        btVisualizarConsultas.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneUsuario)
                paneUsuario.getChildren().addAll(vBoxMenu);
            mudarTela("usuario");
        });
                
        btTelaCadastrarConsulta.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneCadastroConsulta)
                paneCadastroConsulta.getChildren().addAll(vBoxMenu);
            mudarTela("cadastroConsulta");
        });
        
        btTelaDeletarConsulta.setOnAction((ActionEvent event) -> {
            if(stage.getScene() != sceneDeletarConsulta)
                paneDeletarConsulta.getChildren().addAll(vBoxMenu);
            mudarTela("deletarConsulta");
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
            //cadastrar paciente

            if(ac.cadastrarPaciente(txCadastrarNomePaciente.getText(), 
                    txCadastrarLoginPaciente.getText(), 
                    txCadastrarSenhaPaciente.getText())){
                alertCadastrado.showAndWait();
                txCadastrarNomePaciente.clear();
                txCadastrarLoginPaciente.clear();
                txCadastrarSenhaPaciente.clear();                
            }else{
                alertCadastradoPaciente.showAndWait();
                txCadastrarNomePaciente.clear();
                txCadastrarLoginPaciente.clear();
                txCadastrarSenhaPaciente.clear();


            }
        });
        
        btDeletarPaciente.setOnAction((ActionEvent event) -> {
            if(ac.deletarPaciente(txDeletarPaciente.getText())){

                alertDeletado.showAndWait();
                txDeletarPaciente.clear();
            }else{
                alertPacienteDeletado.showAndWait();
                txDeletarPaciente.clear();

            }
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
        
        txDataDia.setPromptText("Dia");
        txDataMes.setPromptText("Mes");
        txDataAno.setPromptText("Ano");
        txDataHora.setPromptText("Hora");
        txDataDiaConsulta.setPromptText("Dia");
        txDataMesConsulta.setPromptText("Mes");
        txDataAnoConsulta.setPromptText("Ano");
        txDataHoraConsulta.setPromptText("Hora");
        
        txDeletarPaciente.setPromptText("Login Paciente");
        txDeletarPaciente.setLayoutX(215);
        txDeletarPaciente.setLayoutY(108);
        
        // Buttons
        
        btTelaConsulta.setPrefSize(138, 46);
        
        btTelaCadastrarConsulta.setPrefSize(296, 129);
        btTelaCadastrarConsulta.setLayoutX(206);
        btTelaCadastrarConsulta.setLayoutY(40);
        
        btTelaDeletarConsulta.setPrefSize(296, 129);
        btTelaDeletarConsulta.setLayoutX(206); 
        btTelaDeletarConsulta.setLayoutY(200); 
       
        btCadastrarConsulta.setLayoutX(205);
        btCadastrarConsulta.setLayoutY(250);
        
        btCadastrarPaciente.setLayoutX(390);
        btCadastrarPaciente.setLayoutY(108);
        
        btDeletarPaciente.setLayoutX(390);
        btDeletarPaciente.setLayoutY(108);
        
        btVisualizarConsultas.setPrefSize(138, 46);
        btTelaCadastrarPaciente.setPrefSize(138, 46);
        
        btTelaPaciente.setPrefSize(138, 46);
        
        btTelaCadastrarPaciente.setPrefSize(296, 129);
        btTelaCadastrarPaciente.setLayoutX(206);
        btTelaCadastrarPaciente.setLayoutY(40);
        
        btTelaDeletarPaciente.setPrefSize(296, 129);
        btTelaDeletarPaciente.setLayoutX(206);
        btTelaDeletarPaciente.setLayoutY(200);
        
        btDeletarConsulta.setLayoutX(205);
        btDeletarConsulta.setLayoutY(250);
        
        // Combo Boxes
        cbPacientes.setPromptText("Paciente");
        cbPacientes.setPrefWidth(150);
        
        cbMedicos.setPromptText("Médico");
        cbMedicos.setPrefWidth(150);
        
        cbPacientesConsultados.setPromptText("Paciente");
        cbPacientesConsultados.setPrefWidth(150);
        
        cbMedicosConsultados.setPromptText("Médico");
        cbMedicosConsultados.setPrefWidth(150);
        
        // VBoxes
        vBoxMedPacCB.setPrefSize(138, 64);
        vBoxMedPacCB.setLayoutX(194);
        vBoxMedPacCB.setLayoutY(33);
        vBoxMedPacCB.setSpacing(10);

        // alert
        // alert.setTitle("Erro ao cadastrar");
        // alert.setHeaderText("Usuario ja existente");
        
        vBoxMedPacDC.setPrefSize(138, 64);
        vBoxMedPacDC.setLayoutX(194);
        vBoxMedPacDC.setLayoutY(33);
        vBoxMedPacDC.setSpacing(10);

        // alerts
        alertCadastradoPaciente.setTitle("Erro ao Cadastrar");
        alertCadastradoPaciente.setHeaderText("Usuario ja existente!");
        
        alertCadastrado.setTitle("Cadastro");
        alertCadastrado.setHeaderText("Usuario cadastrado com sucesso!");
        
        alertDeletado.setTitle("Deletado");
        alertDeletado.setHeaderText("Usuario deletado com sucesso!");
        
        alertPacienteDeletado.setTitle("Erro ao Deletar");
        alertPacienteDeletado.setHeaderText("Usuario inexistente!");
        
    }
    
    public TelaAtendente(){
        super();
    }
}
