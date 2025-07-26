import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 * @Author Jemaroo
 * @Function Storage object for handling ItemDropData data
 * @Notes Built using information from ttyd-utils by Jdaster64: https://github.com/jdaster64/ttyd-utils/blob/master/docs/ttyd_structures_pseudocode.txt
 */
public class DropData
{
    public ImageView icon;
    public String name;
    public int size;
    public ArrayList<Integer> ids = new ArrayList<Integer>();
    public ArrayList<Integer> holdWeights = new ArrayList<Integer>();
    public ArrayList<Integer> dropWeights = new ArrayList<Integer>();
}