import com.tdunning.math.stats.AVLTreeDigest;
import com.tdunning.math.stats.TDigest;

/**
 * Created by rsharma on 7/18/17.
 */
public class TDigestBug {
    public static void main(String[] args) {
        /*
        """
      {"10":300000000, "200":300000000, "3000":300000000,
      "4000":300000000,"5000":300000000,
      "47883554":200}
    """
        */

        TDigest digest = new AVLTreeDigest(10);
        digest.add(addInput(10,300000000));
        digest.add(addInput(200,300000000));
        digest.add(addInput(3000,300000000));
        digest.add(addInput(4000,300000000));
        digest.add(addInput(5000,300000000));
        digest.add(addInput(47883554,200));

        System.out.println("Media = "+digest.quantile(0.5));
    }

    static TDigest addInput(double x, int y) {
        TDigest digest = new AVLTreeDigest(10);
        digest.add(x,y);
        return digest;
    }
}
