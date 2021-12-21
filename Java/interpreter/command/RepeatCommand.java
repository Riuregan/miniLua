package interpreter.command;

import interpreter.expr.Expr;

public class RepeatCommand extends Command {

    private Expr expr;
    
    private Command cmds; 

    public RepeatCommand(int line, Expr expr, Command cmds){
        super(line);
        this.expr = expr;
        this.cmds = cmds;
    }

    @Override
    public void execute(){

        Value<?> v = expr.expr();

        while (v != null && v.eval){
            cmds.execute();
        }

    }

}
