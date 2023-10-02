/* Nesse projeto irei fazer um editor de texto "vintage", no terminal
 * Com selecao de de linhas e uma forma de salvar em um arquivo o conteudo 
 *  Editor no estilo VI                                                  */

import java.util.*; //usar o scanner desta classe para receber inputs do user
import java.util.ArrayList; //importando uma classe que cria um array expansivo
import java.util.Iterator;

import java.io.File; //classe io.File para criar e escrever em um arquivo
import java.io.FileWriter;
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
             System.out.print("Digite o nome do arquivo e sua extensao (Ex: arquivo.java): ");
        String nomeArquivo = sc.nextLine();

        try{     //CRIAR O ARQUIVO TXT NO DIRETORIO PADRAO COM A CLASSE FILE
            File Arquivo = new File(nomeArquivo);

            if(Arquivo.createNewFile()){
                System.out.println("Arquivo criado com sucesso: " + Arquivo.getName());

                //ADICIONAR O CONTEUDO AO ARQUIVO COM FILEWRITER

                FileWriter addConteudo = new FileWriter(Arquivo.getName());
                int tamanhoArray = lnConteudo.size();
                for(int n = 0; n < tamanhoArray; n++){
                    addConteudo.write(lnConteudo.get(n)); //usa o index N para escrever as linhas do array
                    addConteudo.write("\n"); //quebra a linha a cada entrada
                }
                addConteudo.close();
                
            } 
        }catch(IOException erro){
            System.out.print("ERRO: ");
            erro.printStackTrace();  
        }    



            //sair do for loop infinito
            break;

        } else if(input.equals(":EDIT")){ //EDITAR UMA LINHA JA ESCRITA
            System.out.print("Linha para a edicao: ");
            String editLinha = sc.nextLine();
            int editIndex = Integer.parseInt(editLinha) - 1; //convertendo String para Int (+1 Para igualar numero da linha e index do array)

            //Aplicar o conteudo no index com o método set
            String conteudoEditado = sc.nextLine();
            lnConteudo.set(editIndex, conteudoEditado);

            i--; // (voltando uma linha para trás ja que comando nao conta)
        } 
        else{
            lnConteudo.add(input);  
        }  
       }

    }
}