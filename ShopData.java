import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 * @Author Jemaroo
 * @Function Storage object for handling ShopData data
 */
public class ShopData
{
    public ImageView icon;
    public String name;
    public int size;
    public ArrayList<Integer> ids = new ArrayList<Integer>();
    public ArrayList<Integer> sellPrices = new ArrayList<Integer>(); //Only used for stores
}