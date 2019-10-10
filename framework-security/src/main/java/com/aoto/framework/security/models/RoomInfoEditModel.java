package com.aoto.framework.security.models;

import org.springframework.web.multipart.MultipartFile;

/**
 * @program: framework-web
 * @description:
 * @author: Mr.wuj
 * @create: 2019-09-20 11:07
 **/
public class RoomInfoEditModel {
    private int roomID;
    /**
     * @Author: Mr.Wuj
     */
    private String roomName;
    /**
     * @Author: Mr.Wuj
     */
    private String community;
    /**
     * @Author: Mr.Wuj
     */
    private int rent;
    /**
     * @Author: Mr.Wuj
     */
    private String houseType;
    /**
     * @Author: Mr.Wuj
     */
    private String oriented;
    /**
     * @Author: Mr.Wuj
     */
    private String rentType;
    /**
     * @Author: Mr.Wuj
     */
    private double roomSize;
    /**
     * @Author: Mr.Wuj
     */
    private String address;
    /**
     * @Author: Mr.Wuj
     */
    private String indoorStructure;
    /**
     * @Author: Mr.Wuj
     */
    private String colour;
    /**
     * @Author: Mr.Wuj
     */
    private String detailedIntroduction;
    /**
     * @Author: Mr.Wuj
     */
    private String paymentMethod;
    /**
     * @Author: Mr.Wuj
     */
    private String buildingType;
    /**
     * @Author: Mr.Wuj
     */
    private String administrativeArea;
    /**
     * @Author: Mr.Wuj
     */
    private String indoorFacilities;
    /**
     * @Author: Mr.Wuj
     */
    private String outdoorFacilities;
    /**
     * @Author: Mr.Wuj
     */
    private String houseAdvantage;
    /**
     * @Author: Mr.Wuj
     */
    private String images;
    /**
     * @Author: Mr.Wuj
     */
    private String qrcode;
    /**
     * @Author: Mr.Wuj
     */
    private String visitTime;
    /**
     * @Author: Mr.Wuj
     */
    private String floor;
    /**
     * @Author: Mr.Wuj
     */
    private String publishingMethod;
    /**
     * @Author: Mr.Wuj
     */
    private int windowNum;
    /**
     * @Author: Mr.Wuj
     */
    private String parkSpace;
    /**
     * @Author: Mr.Wuj
     */
    private int buildYear;
    /**
     * @Author: Mr.Wuj
     */
    private String decoration;
    /**
     * @Author: Mr.Wuj
     */
    private String publicDate;
    /**
     * @Author: Mr.Wuj
     */
    private String updateDate;
    /**
     * @Author: Mr.Wuj
     */
    private String houseID;
    /**
     * @Author: Mr.Wuj
     */
    private String communityLongitude;
    /**
     * @Author: Mr.Wuj
     */
    private String communityDimension;
    /**
     * @Author: Mr.Wuj
     */
    private String roomLongitude;
    /**
     * @Author: Mr.Wuj
     */
    private String roomDimension;



    private String roomStatus;

    private String roomType;

    private String roomCheck;

    private String roomCause;

    public MultipartFile[] getFile1_edit() {
        return file1_edit;
    }

    public void setFile1_edit(MultipartFile[] file1_edit) {
        this.file1_edit = file1_edit;
    }

    public MultipartFile getFile2_edit() {
        return file2_edit;
    }

    public void setFile2_edit(MultipartFile file2_edit) {
        this.file2_edit = file2_edit;
    }

    private MultipartFile[] file1_edit;

    private MultipartFile file2_edit;

    public String getDelete_img() {
        return delete_img;
    }

    public void setDelete_img(String delete_img) {
        this.delete_img = delete_img;
    }

    private String delete_img;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getOriented() {
        return oriented;
    }

    public void setOriented(String oriented) {
        this.oriented = oriented;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public double getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(double roomSize) {
        this.roomSize = roomSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndoorStructure() {
        return indoorStructure;
    }

    public void setIndoorStructure(String indoorStructure) {
        this.indoorStructure = indoorStructure;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDetailedIntroduction() {
        return detailedIntroduction;
    }

    public void setDetailedIntroduction(String detailedIntroduction) {
        this.detailedIntroduction = detailedIntroduction;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    public String getIndoorFacilities() {
        return indoorFacilities;
    }

    public void setIndoorFacilities(String indoorFacilities) {
        this.indoorFacilities = indoorFacilities;
    }

    public String getOutdoorFacilities() {
        return outdoorFacilities;
    }

    public void setOutdoorFacilities(String outdoorFacilities) {
        this.outdoorFacilities = outdoorFacilities;
    }

    public String getHouseAdvantage() {
        return houseAdvantage;
    }

    public void setHouseAdvantage(String houseAdvantage) {
        this.houseAdvantage = houseAdvantage;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getPublishingMethod() {
        return publishingMethod;
    }

    public void setPublishingMethod(String publishingMethod) {
        this.publishingMethod = publishingMethod;
    }

    public int getWindowNum() {
        return windowNum;
    }

    public void setWindowNum(int windowNum) {
        this.windowNum = windowNum;
    }

    public String getParkSpace() {
        return parkSpace;
    }

    public void setParkSpace(String parkSpace) {
        this.parkSpace = parkSpace;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getHouseID() {
        return houseID;
    }

    public void setHouseID(String houseID) {
        this.houseID = houseID;
    }

    public String getCommunityLongitude() {
        return communityLongitude;
    }

    public void setCommunityLongitude(String communityLongitude) {
        this.communityLongitude = communityLongitude;
    }

    public String getCommunityDimension() {
        return communityDimension;
    }

    public void setCommunityDimension(String communityDimension) {
        this.communityDimension = communityDimension;
    }

    public String getRoomLongitude() {
        return roomLongitude;
    }

    public void setRoomLongitude(String roomLongitude) {
        this.roomLongitude = roomLongitude;
    }

    public String getRoomDimension() {
        return roomDimension;
    }

    public void setRoomDimension(String roomDimension) {
        this.roomDimension = roomDimension;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomCheck() {
        return roomCheck;
    }

    public void setRoomCheck(String roomCheck) {
        this.roomCheck = roomCheck;
    }

    public String getRoomCause() {
        return roomCause;
    }

    public void setRoomCause(String roomCause) {
        this.roomCause = roomCause;
    }
}
