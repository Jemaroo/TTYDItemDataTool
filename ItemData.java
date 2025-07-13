import javafx.scene.image.ImageView;

/**
 * @Author Jemaroo
 * @Function Storage object for handling ItemData data
 * @Notes Built using information from ttyd-utils by Jdaster64: https://github.com/jdaster64/ttyd-utils/blob/master/docs/ttyd_structures_pseudocode.txt
 */
public class ItemData
{
    public String name;
    public ImageView icon;
    
    public boolean UseLocationShop = false;
    public boolean UseLocationBattle = false;
    public boolean UseLocationField = false;
    public int sortOrder = 0;
    public int buyPrice = 0;
    public int discountPrice = 0;
    public int starPiecePrice = 0;
    public int sellPrice = 0;
    public int BPCost = 0;
    public int HPRestored = 0;
    public int FPRestored = 0;
    public int SPRestored = 0;

    public final int UseLocationFlags_offset = 16;
    public final int sortOrder_offset = 18;
    public final int buyPrice_offset = 20;
    public final int discountPrice_offset = 22;
    public final int starPiecePrice_offset = 24;
    public final int sellPrice_offset = 26;
    public final int BPCost_offset = 28;
    public final int HPRestored_offset = 29;
    public final int FPRestored_offset = 30;
    public final int SPRestored_offset = 31;

    public void setLocationFlagsValue(int input)
    {
        if(input == 7){this.UseLocationShop = true; this.UseLocationBattle = true; this.UseLocationField = true;}
        else if(input == 6){this.UseLocationShop = false; this.UseLocationBattle = true; this.UseLocationField = true;}
        else if(input == 5){this.UseLocationShop = true; this.UseLocationBattle = false; this.UseLocationField = true;}
        else if(input == 4){this.UseLocationShop = false; this.UseLocationBattle = false; this.UseLocationField = true;}
        else if(input == 3){this.UseLocationShop = true; this.UseLocationBattle = true; this.UseLocationField = false;}
        else if(input == 2){this.UseLocationShop = false; this.UseLocationBattle = true; this.UseLocationField = false;}
        else if(input == 1){this.UseLocationShop = true; this.UseLocationBattle = false; this.UseLocationField = false;}
        else{this.UseLocationShop = false; this.UseLocationBattle = false; this.UseLocationField = false;}
    }

    public int getUseLocationFlagsValue()
    {
        int retVal = 0;
        if(this.UseLocationShop){retVal += 1;}
        if(this.UseLocationBattle){retVal += 2;}
        if(this.UseLocationField){retVal += 4;}
        return retVal;
    }
}