package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Conexao {

public static final int TIMEOUT = 300;

/**
 *
 * @param @ParamMetaData
 * @return Var
 */
// conexao
public static Var Executar(@ParamMetaData(description = "param_banco") Var param_banco) throws Exception {
 return new Callable<Var>() {

   // param
   private Var banco = param_banco;
   // end

   public Var call() throws Exception {

    System.out.println(
    Var.valueOf("qualquer coisa").getObjectAsString());

    System.out.println(
    cronapi.util.Operations.getCurrentUserName().getObjectAsString());

    System.out.println(banco.getObjectAsString());

    if (
    Var.valueOf(
    cronapi.util.Operations.getCurrentUserName().equals(
    Var.valueOf("admin"))).getObjectAsBoolean()) {

        banco =
        cronapi.database.Operations.configureConnection(
        Var.valueOf("com.mysql.jdbc.Driver"),
        Var.valueOf("jdbc:mysql://rds-oncronos-shared.cx8gelec2ybx.us-east-1.rds.amazonaws.com:3306/IBase64?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC&useSSL=false"),
        Var.valueOf("usr_db_doc"),
        Var.valueOf("rjfe2Vm9yQWg3R8Y"));
    }
    return banco;
   }
 }.call();
}

}

