package behavioral_patterns.command;

public class FileSystemClient {
    
    public static void main(String[] args) {
        // creating the receiver obejct
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

        // creating command and association with receiver
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);

        // creating invoker and association with command
        FileInvoker file = new FileInvoker(openFileCommand);

        // perform action on invoker object
        file.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
        file = new FileInvoker(writeFileCommand);
        file.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        file = new FileInvoker(closeFileCommand);
        file.execute();
    }
}
