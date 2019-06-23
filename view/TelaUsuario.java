package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rodri
 */
//inicialização do painel 
public class TelaUsuario extends Application {
    protected AnchorPane paneUsuario;
    protected VBox vBoxMenu, vBoxMedPac;
    protected ToggleGroup rbGroup;
    protected HBox hBoxFiltro;
    protected TableView tbConsultas;
    protected RadioButton rbPaciente, rbMedico;
    protected Button btLogout, btPesquisarConsulta;
    protected TextField txFiltro;
    protected static Stage stage;
    protected static Scene sceneUsuario, sceneCadastroConsulta, 
            scenePaciente, sceneCadastroPaciente, sceneDeletarPaciente, 
            sceneFuncionario, sceneCadastroFuncionario, sceneDeletarFuncionario;
    
    @Override
    public void start(Stage stage) {
        initComponentsUsuario();
        initListenersUsuario();
        
        sceneUsuario = new Scene(paneUsuario);
        stage.setScene(sceneUsuario);
        stage.setTitle("Consultas");
        stage.show();
        
        initLayoutUsuario();
        
        TelaUsuario.stage = stage;
    }
    //inicialização dos componentes (view)
    protected void initComponentsUsuario() {
        
        // Pane
        paneUsuario = new AnchorPane();
        paneUsuario.setPrefSize(558, 392);
        
        // Table
        tbConsultas = new TableView();
        
        // Boxes
        vBoxMenu = new VBox();
        
        hBoxFiltro = new HBox();
        
        // Group Radio
        rbGroup = new ToggleGroup();
        
        rbPaciente = new RadioButton("Paciente");
        rbMedico = new RadioButton("Médico");
        
        rbPaciente.setToggleGroup(rbGroup);
        rbMedico.setToggleGroup(rbGroup);
        
        vBoxMedPac = new VBox(rbPaciente, rbMedico);
        
        // Text
        txFiltro = new TextField();
        
        // Buttons
        btLogout = new Button("Logout");
        btPesquisarConsulta = new Button("Pesquisar");
        
        // Incrementação das boxes e panes
        
        vBoxMenu.getChildren().addAll(btLogout);
        hBoxFiltro.getChildren().addAll(txFiltro, btPesquisarConsulta);
        paneUsuario.getChildren().addAll(vBoxMenu, vBoxMedPac, hBoxFiltro,
                tbConsultas);
    }
    
    //controler escutadores possivel observer
    protected void initListenersUsuario() {
        btLogout.setOnAction((ActionEvent event) -> {
            Login lg = new Login();
            lg.start(new Stage());
            stage.close();
        });
        
        btPesquisarConsulta.setOnAction((ActionEvent event) -> {
            RadioButton selectedRadioButton = 
                    (RadioButton) rbGroup.getSelectedToggle();
            System.out.println("Consulta Pesquisada");
            System.out.println(selectedRadioButton.getText());
        });
        
    }
    //view das consultas 
    protected void initLayoutUsuario() {
        // Table
        tbConsultas.setPrefSize(352, 268);
        tbConsultas.setLayoutX(189);
        tbConsultas.setLayoutY(100);
        
        // Boxes
        vBoxMenu.setPrefSize(149, 381);        
        vBoxMenu.setSpacing(10);
        
        vBoxMedPac.setPrefSize(90, 80);
        vBoxMedPac.setSpacing(10);
        vBoxMedPac.setLayoutX(170);
        vBoxMedPac.setLayoutY(27);
        
        hBoxFiltro.setPrefSize(309, 64);
        hBoxFiltro.setLayoutX(250);
        hBoxFiltro.setLayoutY(27);
        
        // Buttons
        btLogout.setPrefSize(138, 46);
    }
    
    public static Stage getStage() {
        return stage;
    }
    //controler 
    public static void mudarTela(String scr){
        System.out.println(scr);
        switch(scr){
            case "usuario":
                stage.setScene(sceneUsuario);
                break;
            case "cadastroConsulta":
                stage.setScene(sceneCadastroConsulta);
                break;
            case "paciente":
                stage.setScene(scenePaciente);
                break;
            case "cadastroPaciente":
                stage.setScene(sceneCadastroPaciente);
                break;
            case "deletarPaciente":
                stage.setScene(sceneDeletarPaciente);
                break;
            case "funcionario":
                stage.setScene(sceneFuncionario);
                break;
            case "cadastroFuncionario":
                stage.setScene(sceneCadastroFuncionario);
                break;
            case "deletarFuncionario":
                stage.setScene(sceneDeletarFuncionario);
                break;
        }
    }
    
    public TelaUsuario(){
        this.start(new Stage());
    }
}
