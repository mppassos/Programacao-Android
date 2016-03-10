package br.com.wgbn.pm_20160310_mapas_layout;

/**
 * Created by vivasalute on 10/03/16.
 */
public class ItemData {
    public String title;
    public int imageUrl;
    public String block;
    public String village;
    public String latlong;

    public String getLatlong(){
        return latlong;
    }
    public String getTitle(){
        return title;
    }
    public int getImageUrl(){
        return imageUrl;
    }
    public String getBlock(){
        return block;
    }
    public String getVillage(){
        return village;
    }
}
