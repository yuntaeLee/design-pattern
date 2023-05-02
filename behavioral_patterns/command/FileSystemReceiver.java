package behavioral_patterns.command;

public interface FileSystemReceiver {
    
    void openFile();
    void writeFile();
    void closeFile();
}
