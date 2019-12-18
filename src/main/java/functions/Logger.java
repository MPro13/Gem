package functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static menu.Runner.logger;

public class Logger {
    private File file;

    public void CreateLogger(String buff) {
        try {
            try {
                file = new File("res//LogInfo.txt");
            } catch (Exception e) {
                logger.info("File wasn't created while creating a logger file!");
                SendMail.sendError("File wasn't created while creating a logger file!");
                e.printStackTrace();
            }
            BufferedWriter bf = new BufferedWriter(new FileWriter(file, true));
            bf.write(new SimpleDateFormat("dd/MM/yyy  HH:mm:ss").format(new Date()));
            bf.newLine();
            bf.write(buff);
            bf.newLine();
            bf.close();
        } catch (IOException e) {
            logger.info("Exception thread while creating FileWriter!");
            SendMail.sendError("Exception thread while creating FileWriter!");
            e.printStackTrace();
        }
    }

}
