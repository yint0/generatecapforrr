import com.github.cage.Cage;
import com.github.cage.GCage;
import com.github.cage.YCage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws IOException {
        for(int i=0;i<20000;i++) {
            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<4;j++){
                int number=random.nextInt(52);
                sb.append(str.charAt(number));
            }
            String text=sb.toString();
            //generate(new GCage(), 10, "cg1", ".jpg", "colding");
            //generate(new YCage(), 10, "cy1", ".jpg", "eT6wLAH");
            //generate(new GCage(), 100, "cg2", ".jpg", null);
            generate(new YCage(), 1, "cy2"+i, ".jpg", text);
        }
    }

    protected static void generate(Cage cage, int num, String namePrefix,
        String namePostfix, String text) throws IOException {
        for (int fi = 0; fi < num; fi++) {
            OutputStream os = new FileOutputStream("H:\\Javajob\\cagecap\\tu\\"+text+"_"+namePrefix + namePostfix, false);
            try {
                cage.draw(
                    text != null ? text : cage.getTokenGenerator().next(),
                    os);
            } finally {
                os.close();
            }
        }
    }
}