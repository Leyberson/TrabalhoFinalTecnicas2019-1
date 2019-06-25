package model;

import java.io.*;
import java.util.ArrayList;


//Essa classe é a aplicacao do padrao Singleton
//This class will be used as a Singleton design pattern
public final class ManipulacaoArquivo{
	public static ManipulacaoArquivo instacia;
	public ArrayList<Usuario> lista = new ArrayList<Usuario>();
	public ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	public String caminho = "dados.tmp";

	private ManipulacaoArquivo(){
		try{
			File arquivo = new File(this.caminho);
			if(arquivo.exists()){
				FileInputStream fis = new FileInputStream(arquivo);

				ObjectInputStream ois = new ObjectInputStream(fis);

				lista = (ArrayList<Usuario>) ois.readObject();
				consultas = (ArrayList<Consulta>) ois.readObject();

				ois.close();
				fis.close();
			}
		}catch(Exception e){
			System.out.println("ERROR Leitura");
			System.out.println("Dados armazenados no arquivo \"dados.tmp\" sao incompativeis");
		}
	}

	public void escreverNoArquivo(){
		try{
			File arquivo = new File(this.caminho);

			FileOutputStream fos = new FileOutputStream(arquivo);

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(this.lista);
			oos.writeObject(this.consultas);

			oos.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ManipulacaoArquivo getInstancia(){
		if(instacia == null){
			instacia = new ManipulacaoArquivo();
		}
		return instacia;
	}
	
}