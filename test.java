import java.util.ArrayList;

public class test 
{
    public static void testUnitData(ArrayList<ItemData> items)
    {
        testItemCount(items);
        testItemData(items);
    }

    private static void testItemCount(ArrayList<ItemData> items)
    {
        System.out.println("Items Stored: " + items.size());
    }

    private static void testItemData(ArrayList<ItemData> items)
    {
        String retVal = "";
        for(int i = 0; i < items.size(); i++)
        {
            retVal += "Name: " + items.get(i).name + "\n"
            + "UseLocationShop: " + items.get(i).UseLocationShop + " | "
            + "UseLocationBattle: " + items.get(i).UseLocationBattle + " | "
            + "UseLocationField: " + items.get(i).UseLocationField + " | "
            + "sortOrder: " + items.get(i).sortOrder + " | "
            + "buyPrice: " + items.get(i).buyPrice + " | "
            + "discountPrice: " + items.get(i).discountPrice + " | "
            + "starPiecePrice: " + items.get(i).starPiecePrice + " | "
            + "sellPrice: " + items.get(i).sellPrice + " | "
            + "BPCost: " + items.get(i).BPCost + " | "
            + "HPRestored: " + items.get(i).HPRestored + " | "
            + "FPRestored: " + items.get(i).FPRestored + " | "
            + "SPRestored: " + items.get(i).SPRestored + "\n\n";
        }
        System.out.println(retVal);
    }
}