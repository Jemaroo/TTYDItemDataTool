import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @Author Jemaroo
 * @Function Main Functions for reading and parsing input data
 */
public class Main 
{
    /**
     * @Author Jemaroo
     * @Function Searches for matching files in a given directory
     */
    public static ArrayList<File> findMatchingFiles(File directory, ArrayList<String> targetFilenames) 
    {
        ArrayList<File> matchingFiles = new ArrayList<>();
        File[] files = directory.listFiles();

        if (files != null) 
        {
            for (File file : files) 
            {
                if (file.isDirectory()) 
                {
                    matchingFiles.addAll(findMatchingFiles(file, targetFilenames));
                } 
                else if (targetFilenames.contains(file.getName())) 
                {
                    matchingFiles.add(file);
                }
            }
        }

        return matchingFiles;
    }

    /**
     * @Author Jemaroo
     * @Function Will attempt to read the given file and the json file and parse them into an array of ItemData
     */
    public static FileItemData getTableData(File givenFile)
    {
        File jsonFile = new File("src\\ItemData.json");
        byte[] givenFiledata = ByteUtils.readData(givenFile);

        FileItemData fileData = new FileItemData();

        //Check for correct dol/rel in json
        try
        {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject)parser.parse(new FileReader(jsonFile));
            JSONArray fileArray = (JSONArray)root.get("File");
            JSONObject fileObj = null;
            int locator = 0;

            for(int i = 0; i < fileArray.size(); i ++)
            {
                fileObj = (JSONObject)fileArray.get(i);
                String name = (String)fileObj.get("Name");
                if(givenFile.getName().equalsIgnoreCase(name))
                {  
                    System.out.println(name + " File Structs Found in: " + jsonFile.getName());
                    break;
                }
            }

            if(givenFile.getName().equals("main.dol") || givenFile.getName().equals("Start.dol"))
            {
                JSONArray itemNameArray = (JSONArray)fileObj.get("Items");
                JSONArray itemOffsetArray = (JSONArray)fileObj.get("Offsets");
                
                //ItemData
                for(int i = 0; i < itemNameArray.size(); i++)
                {
                    ItemData item = new ItemData();

                    //Name
                    item.name = itemNameArray.get(i).toString();
                    
                    //UseLocationFlags
                    locator = item.UseLocationFlags_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.setLocationFlagsValue(ByteUtils.bytesToInt(givenFiledata[locator], givenFiledata[locator + 1]));

                    //Sort Order
                    locator = item.sortOrder_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.sortOrder = ByteUtils.bytesToInt(givenFiledata[locator], givenFiledata[locator + 1]);

                    //Buy Price
                    locator = item.buyPrice_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.buyPrice = ByteUtils.bytesToInt(givenFiledata[locator], givenFiledata[locator + 1]);
                    
                    //Discount Price
                    locator = item.discountPrice_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.discountPrice = ByteUtils.bytesToInt(givenFiledata[locator], givenFiledata[locator + 1]);

                    //Star Piece Price
                    locator = item.starPiecePrice_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.starPiecePrice = ByteUtils.bytesToInt(givenFiledata[locator], givenFiledata[locator + 1]);

                    //Sell Price
                    locator = item.sellPrice_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.sellPrice = ByteUtils.bytesToInt(givenFiledata[locator], givenFiledata[locator + 1]);

                    //BP Cost
                    locator = item.BPCost_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.BPCost = ByteUtils.bytesToInt(givenFiledata[locator]);

                    //HP Restored
                    locator = item.HPRestored_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.HPRestored = ByteUtils.bytesToInt(givenFiledata[locator]);

                    //FP Restored
                    locator = item.FPRestored_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.FPRestored = ByteUtils.bytesToInt(givenFiledata[locator]);

                    //SP Restored
                    locator = item.SPRestored_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    item.SPRestored = ByteUtils.bytesToInt(givenFiledata[locator]);

                    //Adding to list
                    fileData.items.add(item);
                }

                //ShopTables
                JSONArray shopTablesArray = (JSONArray)fileObj.get("ShopTables");
                
                for(int i = 0; i < shopTablesArray.size(); i++)
                {
                    ShopData shop = new ShopData();
                    shop.name = (String)((JSONObject)(shopTablesArray.get(i))).get("Name");
                    shop.size = Math.toIntExact((Long)((JSONObject)(shopTablesArray.get(i))).get("Size"));

                    locator = Math.toIntExact((Long)((JSONObject)(shopTablesArray.get(i))).get("Offset"));
                    for(int j = 0; j < shop.size; j++)
                    {
                        int id = ByteUtils.bytesToInt(givenFiledata[locator], givenFiledata[locator + 1], givenFiledata[locator + 2], givenFiledata[locator + 3]);
                        shop.ids.add(id);
                        locator += 4;
                    }

                    //Adding to list
                    fileData.shops.add(shop);
                }
            }
            else
            {
                //ShopTables
                JSONArray shopTablesArray = (JSONArray)fileObj.get("ShopTables");
                
                for(int i = 0; i < shopTablesArray.size(); i++)
                {
                    ShopData shop = new ShopData();
                    shop.name = (String)((JSONObject)(shopTablesArray.get(i))).get("Name");
                    shop.size = Math.toIntExact((Long)((JSONObject)(shopTablesArray.get(i))).get("Size"));

                    locator = Math.toIntExact((Long)((JSONObject)(shopTablesArray.get(i))).get("Offset"));
                    for(int j = 0; j < shop.size; j++)
                    {
                        int id = ByteUtils.bytesToInt(givenFiledata[locator], givenFiledata[locator + 1], givenFiledata[locator + 2], givenFiledata[locator + 3]);
                        shop.ids.add(id);
                        int sellPrice = ByteUtils.bytesToInt(givenFiledata[locator + 4], givenFiledata[locator + 5], givenFiledata[locator + 6], givenFiledata[locator + 7]);
                        shop.sellPrices.add(sellPrice);
                        locator += 8;
                    }

                    //Adding to list
                    fileData.shops.add(shop);
                }
            }

            return fileData;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("There was an Error Finding the JSON File");
        }
        catch (IOException e)
        {
            System.out.println("There was an Error Reading the JSON File");
        }
        catch (ParseException e)
        {
            System.out.println("There was an Error Parsing the JSON File");
        }

        //Failsafe
        return null;
    }

    /**
     * @Author Jemaroo
     * @Function Will export the array of units back into the same format as the given file
     */
    public static byte[] buildNewFile(File givenFile, FileItemData fileData)
    {
        File jsonFile = new File("src\\ItemData.json");
        byte[] givenFiledata = ByteUtils.readData(givenFile);
        int locator = 0;

        try
        {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject)parser.parse(new FileReader(jsonFile));
            JSONArray fileArray = (JSONArray)root.get("File");
            JSONObject fileObj = null;

            for(int i = 0; i < fileArray.size(); i ++)
            {
                fileObj = (JSONObject)fileArray.get(i);
                String name = (String)fileObj.get("Name");
                if(givenFile.getName().equalsIgnoreCase(name))
                {  
                    break;
                }
            }

            if(givenFile.getName().equals("main.dol") || givenFile.getName().equals("Start.dol"))
            {
                JSONArray itemOffsetArray = (JSONArray)fileObj.get("Offsets");
                for(int i = 0; i < fileData.items.size(); i++)
                {
                    //ItemData
                    //UseLocationFlags
                    locator = fileData.items.get(i).UseLocationFlags_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    byte[] tempFlag = ByteUtils.intTo2Bytes(fileData.items.get(i).getUseLocationFlagsValue());
                    for(int k = 0; k < 2 ; k++)
                    {
                        givenFiledata[locator + k] = tempFlag[k];
                    }

                    //Sort Order
                    locator = fileData.items.get(i).sortOrder_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    byte[] TempSortOrder = ByteUtils.intTo2Bytes(fileData.items.get(i).sortOrder);
                    for(int k = 0; k < 2 ; k++)
                    {
                        givenFiledata[locator + k] = TempSortOrder[k];
                    }
                    
                    //Buy Price
                    locator = fileData.items.get(i).buyPrice_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    byte[] TempBuyPrice = ByteUtils.intTo2Bytes(fileData.items.get(i).buyPrice);
                    for(int k = 0; k < 2 ; k++)
                    {
                        givenFiledata[locator + k] = TempBuyPrice[k];
                    }

                    //Discount Price
                    locator = fileData.items.get(i).discountPrice_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    byte[] TempDiscountPrice = ByteUtils.intTo2Bytes(fileData.items.get(i).discountPrice);
                    for(int k = 0; k < 2 ; k++)
                    {
                        givenFiledata[locator + k] = TempDiscountPrice[k];
                    }

                    //Star Piece Price
                    locator = fileData.items.get(i).starPiecePrice_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    byte[] TempStarPiecePrice = ByteUtils.intTo2Bytes(fileData.items.get(i).starPiecePrice);
                    for(int k = 0; k < 2 ; k++)
                    {
                        givenFiledata[locator + k] = TempStarPiecePrice[k];
                    }

                    //Sell Price
                    locator = fileData.items.get(i).sellPrice_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    byte[] TempSellPrice = ByteUtils.intTo2Bytes(fileData.items.get(i).sellPrice);
                    for(int k = 0; k < 2 ; k++)
                    {
                        givenFiledata[locator + k] = TempSellPrice[k];
                    }

                    //BP Cost
                    locator = fileData.items.get(i).BPCost_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    givenFiledata[locator] = ByteUtils.intTo1Byte(fileData.items.get(i).BPCost);

                    //HP Restored
                    locator = fileData.items.get(i).HPRestored_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    givenFiledata[locator] = ByteUtils.intTo1Byte(fileData.items.get(i).HPRestored);

                    //FP Restored
                    locator = fileData.items.get(i).FPRestored_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    givenFiledata[locator] = ByteUtils.intTo1Byte(fileData.items.get(i).FPRestored);

                    //SP Restored
                    locator = fileData.items.get(i).SPRestored_offset + Math.toIntExact((Long)itemOffsetArray.get(i));
                    givenFiledata[locator] = ByteUtils.intTo1Byte(fileData.items.get(i).SPRestored);
                }

                //ShopData
                JSONArray shopTablesArray = (JSONArray)fileObj.get("ShopTables");
                for(int i = 0; i < shopTablesArray.size(); i++)
                {
                    int shopSize = Math.toIntExact((Long)((JSONObject)(shopTablesArray.get(i))).get("Size"));
                    locator = Math.toIntExact((Long)((JSONObject)(shopTablesArray.get(i))).get("Offset"));

                    for(int j = 0; j < shopSize; j++)
                    {
                        byte[] tempID = ByteUtils.intTo4Bytes(fileData.shops.get(i).ids.get(j));
                        for(int k = 0; k < 4 ; k++)
                        {
                            givenFiledata[locator + k] = tempID[k];
                        }

                        locator += 4;
                    }
                }
            }
            else
            {
                //ShopData
                JSONArray shopTablesArray = (JSONArray)fileObj.get("ShopTables");
                for(int i = 0; i < shopTablesArray.size(); i++)
                {
                    int shopSize = Math.toIntExact((Long)((JSONObject)(shopTablesArray.get(i))).get("Size"));
                    locator = Math.toIntExact((Long)((JSONObject)(shopTablesArray.get(i))).get("Offset"));

                    for(int j = 0; j < shopSize; j++)
                    {
                        byte[] tempID = ByteUtils.intTo4Bytes(fileData.shops.get(i).ids.get(j));
                        for(int k = 0; k < 4 ; k++)
                        {
                            givenFiledata[locator + k] = tempID[k];
                        }

                        locator += 4;

                        byte[] tempsellPrice = ByteUtils.intTo4Bytes(fileData.shops.get(i).sellPrices.get(j));
                        for(int k = 0; k < 4 ; k++)
                        {
                            givenFiledata[locator + k] = tempsellPrice[k];
                        }

                        locator += 4;
                    }
                }
            }

            return givenFiledata;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("There was an Error Finding the JSON File");
        }
        catch (IOException e)
        {
            System.out.println("There was an Error Reading the JSON File");
        }
        catch (ParseException e)
        {
            System.out.println("There was an Error Parsing the JSON File");
        }

        //Failsafe
        return null;
    }
}