import java.io.*;

public class TxtToM3u {
    public static void main(String[] args)  {
        /**源文件路径*/
        String filePath = "/Users/ryan/Downloads/X直播TV0808.txt";
        /**输出文件路径*/
        String outPath = filePath.replace(".txt", ".m3u");
        File file2 = new File(filePath);
        String all = "#EXTM3U\r\n";
        try {
            InputStreamReader in2 = new InputStreamReader(new FileInputStream(file2), "UTF-8");
            BufferedReader buff = new BufferedReader(in2);
            String text = null;
            while ((text = buff.readLine()) != null) {
                if (text != null && text.trim().length() > 0) {
                    text = text.replace(",", "\r\n");
                    all += ("#EXTINF:-1 ," + text + "\r\n");
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
