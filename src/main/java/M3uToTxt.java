import java.io.*;
import java.util.Scanner;

public class M3uToTxt {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String filePath = scan.nextLine();
        /**源文件路径*/
        String filePath = "/Users/ryan/Downloads/CN.m3u";
        /**输出文件路径*/
        String outPath = filePath.replace(".m3u", ".txt");
        File file2 = new File(filePath);
        String all = new String();
        try {
            InputStreamReader in2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
            BufferedReader buff = new BufferedReader(in2);
            String text = null;
            while ((text = buff.readLine()) != null) {
                if (text != null && text.trim().length() > 0) {
                    if (text.startsWith("#EXTM3U")){
                        text = text.replace("#EXTM3U","");
                    }
                    if (text.startsWith("#EXTINF:")){
                        text = text.substring(text.indexOf(",")+1);
                        text = (text+","+buff.readLine()+"\r\n");
                    }
                    all += text;
                }
            }
            PrintWriter out = new PrintWriter(outPath);
            out.write(all.toCharArray());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
    }
}