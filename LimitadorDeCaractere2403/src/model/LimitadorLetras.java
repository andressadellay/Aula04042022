/*
Limitador de TextField para letras
 */
package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Andressa
 */
public class LimitadorLetras extends PlainDocument {
    private int quantidadeMax;
    //construtor da classe - serve para inicializar variáveis da classe
    public LimitadorLetras(int max){
        /*verifica se o que o programador definiu no GUIPessoa para quantidade
        de caracteres é negativo ou nulo
        */
        if(max<=0){
            throw new IllegalArgumentException("Erro ao definir quantidade de caracteres máximos");
        /*caso o programador tenha definifo uma quantidade máxima de caracteres
            que NÃO seja negativa ou nula, então, a variável global receberá o
            parâmetro definido pelo programador.
        */    
        }else{
            this.quantidadeMax = max;
        }//fecha else
    }//fecha método construtor

    /*cria método inserString para verificar a quantidade de caracteres
    que foi digitada dentro do campo JTextField.
    */
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        /*
        offs - posição do texto
        str - texto que o usuário digita
        a - atributo da fonte, ou seja, se aceita letras, números, caracteres especiais
        */
        /*
        se o usuário não escreveu nada, então o usuário poderá prosseguir com seus dígitos
        */
        if(str == null){
            return;
        }
        //soma o tamanho total do JTextField com o tamanho total de caracteres digitados pelo usuário
        int totalQuantidade = (getLength()+str.length());
        //se a soma da quantidade for menor ou então igual à quantidade máxia definida
        if(totalQuantidade<=quantidadeMax){
             super.insertString(offs, str.replaceAll("[^a-z^A-Z^' ']",""), a); //To change body of generated methods, choose Tools | Templates.
             return;
        }//fecha if
        /*
        cria uma variável String que receba os dados que o usuário estão digitando.
        Continua mostrando(deixando visível) os caracteres que são permitidos. Caso usuário
        digite carcteres não permitidos, não serão visíveis no JTextField
        */
        String nova = str.substring(0,getLength() - quantidadeMax );
        super.insertString(offs, nova, a);
    }//fecha método

}//fecha classe
