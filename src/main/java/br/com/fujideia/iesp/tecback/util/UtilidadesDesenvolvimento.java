package br.com.fujideia.iesp.tecback.util;

import br.com.fujideia.iesp.tecback.util.message.MessageErro;
import org.apache.regexp.RE;

public class UtilidadesDesenvolvimento {

    public static String aplicaCpf(String cpf) throws Exception {

        RE expressaoTemporaria = null;
        final String STR_EXP_CPF_SEM_MASCARA =
                "^[0-9]{11}$";

        expressaoTemporaria = new RE(STR_EXP_CPF_SEM_MASCARA);

        if ((cpf != null) && (!cpf.equals(""))
                && expressaoTemporaria.match(cpf)) {

            StringBuffer cpfComMascara = new StringBuffer();

            try {

                cpfComMascara.append(cpf.substring(0, 3));
                cpfComMascara.append(".");
                cpfComMascara.append(cpf.substring(3, 6));
                cpfComMascara.append(".");
                cpfComMascara.append(cpf.substring(6, 9));
                cpfComMascara.append("-");
                cpfComMascara.append(cpf.substring(9, 11));
            } // try
            catch (StringIndexOutOfBoundsException ex) {
                throw new Exception(MessageErro.ERRO_AO_FORMATAR_CPF +"\n" +ex.getMessage());
            }
            catch (NumberFormatException ex) {
                throw new Exception(MessageErro.ERRO_AO_FORMATAR_CPF +"\n" +ex.getMessage());
            }
            return cpfComMascara.toString();

        }// if
        return cpf;
    } // converterFormatoCpf()

    public static String retiraCpf(String cpf) throws Exception {

        try{
            String cpfFormatado = cpf.replaceAll("[.\\-]", "");
            return cpfFormatado;
        }catch (Exception e){
            throw new Exception(MessageErro.ERRO_AO_FORMATAR_CPF +"\n" +e.getMessage());
        }
    }
}
