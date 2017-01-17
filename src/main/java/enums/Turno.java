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
public enum Turno {
    MANHA{
        @Override
        public String toString(){
            return "Manhã";
        }
    },
    TARDE{
        @Override
        public String toString(){
            return "Tarde";
        }
    },
    NOITE{
        @Override
        public String toString(){
            return "Noite";
        }
    },
    INTEGRAL{
        @Override
        public String toString(){
            return "Integral";
        }
    },
}
