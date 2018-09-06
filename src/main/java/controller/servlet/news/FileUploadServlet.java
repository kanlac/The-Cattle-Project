package controller.servlet.news;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get information in stream from request
        InputStream fileSource = request.getInputStream();

        // create temp file
        String tempFileName = "/Users/dean/Desktop/tempFile";
        File tempFile = new File(tempFileName);

        // point to OutputStream
        FileOutputStream outputStream = new FileOutputStream(tempFile);
        byte b[] = new byte[1024];
        int n;
        while ((n = fileSource.read(b)) != -1) {
            outputStream.write(b, 0, n);
        }

        fileSource.close();
        outputStream.close();

        // get file name
        RandomAccessFile tempFileAccess = new RandomAccessFile(tempFile, "r");
        tempFileAccess.readLine();
        String str = tempFileAccess.readLine();
        int beginIndex = str.lastIndexOf("filename=") + 10;
        int endIndex = str.lastIndexOf("\"");
        String filename = str.substring(beginIndex, endIndex);
        System.out.println("filename = " + filename);

        // set start position
        tempFileAccess.seek(0);
        long startPos = 0;
        int i = 1; // line count
        while ((n = tempFileAccess.readByte()) != -1 && i <= 4) {
            if (n == '\n') {
                startPos = tempFileAccess.getFilePointer();
                i++;
            }
        }
        startPos = tempFileAccess.getFilePointer() - 1;

        // set end position
        tempFileAccess.seek(tempFileAccess.length());
        long endPos = tempFileAccess.getFilePointer();
        int j = 1; // line count backward
        while (endPos > 0 && j <= 6) {
            endPos--;
            tempFileAccess.seek(endPos);
            if (tempFileAccess.readByte() == '\n') {
                j++;
            }
        }
        endPos = endPos - 1;

        // set path to save
        String realPath = getServletContext().getRealPath("/") + "img";
        File fileUpload = new File(realPath);
        if (!fileUpload.exists()) {
            fileUpload.mkdir();
        }

        File saveFile = new File(realPath, filename);
        RandomAccessFile saveFileAccess = new RandomAccessFile(saveFile, "rw");

        // read contents from temp file
        tempFileAccess.seek(startPos);
        while (startPos < endPos) {
            saveFileAccess.write(tempFileAccess.readByte());
            startPos = tempFileAccess.getFilePointer();
        }

        tempFileAccess.close();
        saveFileAccess.close();
        tempFile.delete();

        request.setAttribute("result", "上传成功！");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
