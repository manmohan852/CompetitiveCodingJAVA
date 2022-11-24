package site.designPattern.structural.proxy.ex1;

public class CommandExecutorProxy implements CommandExecutor { //(Inheritence)

    private boolean isAdmin;
    private CommandExecutor executor;//Composition

    public CommandExecutorProxy(String user, String pwd){
        if("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) isAdmin=true;
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if(isAdmin){
            executor.runCommand(cmd);
        }else{
            if(cmd.trim().startsWith("rm")){
                throw new Exception("rm command is not allowed for non-admin users.");
            }else{
                executor.runCommand(cmd);
            }
        }
    }

}
