package structural_patterns.proxy;

public interface CommandExecutor {
    
    public void runCommand(String cmd) throws Exception;
}
