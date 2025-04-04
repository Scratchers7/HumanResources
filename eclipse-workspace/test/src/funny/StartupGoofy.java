package funny;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
public class StartupGoofy {

	public static void main(String[] args) {
		try {
            createStartupBatchFile("DeleteThis.bat", 
            		"@echo off\n"
            		+ "cd \""+System.getProperty("user.home")+"\\Downloads\"\n"
            		+ "java -jar TicTacToe.jar\n"
            		+ "cd \"%~dp0\"\n"
            		+ "pause");

            System.out.println("Batch file created successfully in the startup folder.");
        } catch (IOException e) {
            System.err.println("Error creating batch file: " + e.getMessage());
            e.printStackTrace();
        }
	}
	public static void createStartupBatchFile(String fileName, String content) throws IOException {
        String startupFolderPath = System.getProperty("user.home") + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";
        File startupFolder = new File(startupFolderPath);

        File batchFile = new File(startupFolder, fileName);
        
        BufferedReader br = new BufferedReader(new FileReader(batchFile));     
        if (br.readLine() == null) {
        	try (BufferedWriter writer = new BufferedWriter(new FileWriter(batchFile))) {
                 writer.write(content);
            }
        } 
    }

}
