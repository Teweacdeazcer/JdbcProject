package jdbc3.entity;

public class Product {
    private String productNum;
    private String productName;
    private int proStock;
    private int proPrice;
    private String prduceName;

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProStock() {
        return proStock;
    }

    public void setProStock(int proStock) {
        this.proStock = proStock;
    }

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

    public String getPrduceName() {
        return prduceName;
    }

    public void setPrduceName(String prduceName) {
        this.prduceName = prduceName;
    }
}
