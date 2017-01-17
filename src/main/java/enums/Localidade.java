/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author bernardolopes at id.uff.br
 */
public enum Localidade {
    NITEROI {
        @Override
        public String toString(){
            return "Niterói";
        }
    },
    RIO_DAS_OSTRAS{
        @Override
        public String toString(){
            return "Rio das Ostras";
        }
    }
    
}
