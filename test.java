import java.util.ArrayList;

public class test 
{
    public static void testUnitData(FileItemData fileData)
    {
        testItemData(fileData.items);
        testShopData(fileData.shops);
    }

    private static void testItemData(ArrayList<ItemData> items)
    {
        if(items.size() > 0)
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

    private static void testShopData(ArrayList<ShopData> shops)
    {
        String retVal = "";
        for(int i = 0; i < shops.size(); i++)
        {
            retVal += "Name: " + shops.get(i).name + "\n"
            + "Size: " + shops.get(i).size + "\nItem ID's: ";

            if(shops.get(i).type != null)
            {
                retVal += "Type: " + shops.get(i).type + "\n";
            }

            for(int j = 0; j < shops.get(i).ids.size(); j++)
            {
                if((j + 1) == shops.get(i).ids.size())
                {
                    retVal += shops.get(i).ids.get(j) + "\n";
                }
                else
                {
                    retVal += shops.get(i).ids.get(j) + ", ";
                }
            }

            if(shops.get(i).throwWeights.size() > 0)
            {
                retVal += "Throw Weights: ";
                for(int j = 0; j < shops.get(i).throwWeights.size(); j++)
                {
                    if((j + 1) == shops.get(i).throwWeights.size())
                    {
                        retVal += shops.get(i).throwWeights.get(j) + "\n";
                    }
                    else
                    {
                        retVal += shops.get(i).throwWeights.get(j) + ", ";
                    }
                }
            }

            if(shops.get(i).sellPrices.size() > 0)
            {
                retVal += "Sell Prices: ";
                for(int j = 0; j < shops.get(i).sellPrices.size(); j++)
                {
                    if((j + 1) == shops.get(i).sellPrices.size())
                    {
                        retVal += shops.get(i).sellPrices.get(j) + "\n";
                    }
                    else
                    {
                        retVal += shops.get(i).sellPrices.get(j) + ", ";
                    }
                }
            }

           retVal += "\n";
        }
        System.out.println(retVal);
    }
}