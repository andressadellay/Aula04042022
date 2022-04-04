/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Andressa
 */
public class LimitadorCaracteres extends PlainDocument{
    private int quantidadeMax;
    //construtor
    public LimitadorCaracteres(int max){
        
        if(max<=0){
            throw  new IllegalArgumentException("Erro ao inserir quantidade!");
        }else{
            quantidadeMax = max;
        }    
        
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        /* 
        offs - posição do texto
        str - texto que deseja inserir
        a - atributos da fonte
        */
        //se estiver vazio ou então tiver atingido a quantidade máxima de caracteres, o projeto continua rodando sem erros
        if(str== null || getLength()== quantidadeMax)
            return;
        int totalQuantidade = (getLength()+str.length());
        //se a quantidade de caracteres for menor ou igual ao máximo estipulado pelo programador
        if(totalQuantidade<=quantidadeMax){
            //então só mostra na tela aqueles dígitos que forem caracteres determinado na linha a seguir
            super.insertString(offs, str.replaceAll("[^a-z^A-Z^!]",""), a);
            return;
        }
        //continua mostrando o que o usuário digitou no campo de texto, enquanto a quantidade não for superior a estipulada
        String nova = str.substring(0,getLength()-quantidadeMax);
        super.insertString(offs, nova, a);
    }
    
    
}
