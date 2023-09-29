/* Nesse projeto irei fazer um editor de texto "vintage", no terminal
 * Com selecao de de linhas e uma forma de salvar em um arquivo o conteudo 
 *  Editor no estilo Apple II                                            */

import java.util.*; //usar o scanner desta classe para receber inputs do user
import java.util.ArrayList; //importando uma classe que cria um array expansivo
import java.util.Iterator;

import java.io.File; //classe io.File para criar e escrever em um arquivo
import java.io.IOException;

public class main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in); //classe scanner para ler inputs depois

       ArrayList<String> lnConteudo = new ArrayList<String>(); //cria a lista array expansivo


        System.out.println("EDITOR DE TEXTO, DIGITE \":SALVAR\" PARA SALVAR NO DIRETORIO PADRAO");
       for(int i = 1; i > 0; i++){
        System.out.print(i + "  ");
        String input = sc.nextLine();

        if(input.equals(":SALVAR")){
            break;
        } else{
            lnConteudo.add(input);
        }
       }

       //Transformar em txt
        
        System.out.print("Digite o nome do arquivo: ");
        String diretorioNome = sc.nextLine();

        try{    
            File Arquivo = new File(diretorioNome + ".txt");

            if(Arquivo.createNewFile()){
                System.out.println("Arquivo criado com sucesso: " + Arquivo.getName());
            } else{
                System.out.println("Arquivo já existe!");
            }
        }catch(IOException erro){
            System.out.print("ERRO: ");
            erro.printStackTrace();  
        }    
       




      //codigo para printar
       /* Iterator<String> linhas = lnConteudo.iterator(); 
        while (linhas.hasNext()){
        System.out.println(linhas.next());
       } */
    }
}