package tourism.network;

import tourism.network.utils.DateUtils;

import java.util.Date;

public class Product {
    private String id; // 主键
    private String roomNum; // 客房房间号
    private String roomType; // 客房类型
    private double productPrice; // 客房价格

    private Integer productStatus; // 状态 0 已预定 1 已满
    private String productStatusStr;
    private String roomDesc;
    public String getId() {
        return id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            if (productStatus == 0) {
                productStatusStr = "已满";
            }
            if (productStatus == 1) {
                productStatusStr = "可预定";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}


