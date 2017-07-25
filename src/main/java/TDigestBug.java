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
        for(int i=0; i<5;i++) {
            System.out.println("******Iteration "+(i+1)+": ******");
            digest.add(getDigest());

            System.out.println("Count = "+digest.size()+"\t Median = "+digest.quantile(0.5));
        }
    }

    static TDigest getDigest() {
        TDigest digest = new AVLTreeDigest(10);

        digest.add(10, 300000000);
        digest.add(200, 300000000);
        digest.add(3000, 300000000);
        digest.add(4000, 300000000);
        digest.add(5000, 300000000);
        digest.add(47883554, 200);

        return digest;
    }
}
